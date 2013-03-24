/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scoop.doers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import scoop.data.Article;
import scoop.data.ArticleInMagazine;
import scoop.database.ConnectionParameters;
import scoop.database.Database;
import scoop.exception.BeanIncompleteException;

/**
 *
 * @author Rahul
 */
public class GetMagazine implements GetData {

    public GetMagazine() {
    }

    public GetMagazine(String mag_id, ConnectionParameters cp) throws SQLException, BeanIncompleteException {
        this.mag_id = mag_id;
        this.cp = cp;
        fetch();
    }

    public final void fetch() throws SQLException, BeanIncompleteException {
        String theme;
        Date mag_date;
        Date mag_added_on;
        String page_id;
        String article_id;
        Date pages_last_modified;
        Date page_added_on;
        Date page_last_modified;
        String article;
        String article_type;
        String author;
        Date article_date;
        Date article_timestamp;
        String sub_category_id;
        int article_rating;
        String article_layout;
        String article_heading;

        int count = 0;
        Database db = null;
        PreparedStatement ps = null;
        String msg = null;
        boolean flag = false;
        try {
            if (mag_id == null || mag_id.equals("")) {
                msg = "magazine Id not set. ";
            }
            if (cp == null) {
                msg = " connection parameters have not been supplied. ";
                flag = true;
            }
            if (flag) {
                throw new BeanIncompleteException(msg);
            }

            db = new Database(cp);
            String query = "select mag_id,theme,mag_date,mag_added_on,page_id,"
                    + "article_id,pages_last_modified,page_added_on,"
                    + "page_last_modified,article,article_type,author,"
                    + "article_date,article_timestamp,sub_category_id,"
                    + "article_rating,article_layout,article_heading,"
                    + "(select * from magazines_view where mag_id=?) as result_count "
                    + "from magazines_view where mag_id=? order by page_id";
            ps = (PreparedStatement) db.getPreparedStatement(query);
            int id = 0;
            try {
                id = Integer.parseInt(mag_id);
            } catch (Exception e) {
                System.out.println("error in parsing: ");
                e.printStackTrace();
            }
            ps.setInt(1, id);
            ps.setInt(2, id);
            ResultSet rs = db.runPreparedStatement(ps);

            /*
             * The idea is to extract the total number of rows in the result and make
             * exactly the same number of comment array elements. Set each comment
             * object with the result values and add to list object. So that
             *
             */
            //assuming we have the number of rows of the resultset in a count
            //variable, needs revamp though
            if (rs.next()) {
                count = rs.getInt("result_count");
                rs.beforeFirst();
            } //needs to be the num of rows in resultset
            articles = new ArticleInMagazine[count];
            list = new ArrayList();
            for (int i = 0; rs.next(); i++) {

                mag_id = rs.getString("mag_id");
                theme = rs.getString("theme");
                mag_date = rs.getDate("mag_date");
                mag_added_on = rs.getDate("mag_added_on");
                page_id = rs.getString("page_id");
                article_id = rs.getString("article_id");
                pages_last_modified = rs.getTimestamp("pages_last_modified");
                page_added_on = rs.getDate("page_added_on");
                page_last_modified = rs.getTimestamp("page_last_modified");
                article = rs.getString("article");
                article_type = rs.getString("article_type");
                author = rs.getString("author");
                article_date = rs.getDate("article_date");
                article_timestamp = rs.getTimestamp("article_timestamp");
                sub_category_id = rs.getString("sub_category_id");
                article_rating = rs.getInt("article_rating");
                article_layout = rs.getString("article_layout");
                article_heading = rs.getString("article_heading");
                articles[i] = new ArticleInMagazine();

                articles[i].setMag_id(mag_id);
                articles[i].setTheme(theme);
                articles[i].setMag_date(mag_date);
                articles[i].setMag_added_on(mag_added_on);
                articles[i].setPage_id(page_id);
                articles[i].setArticle_id(article_id);
                articles[i].setPages_last_modified(pages_last_modified);
                articles[i].setPage_last_modified(page_last_modified);
                articles[i].setPage_added_on(page_added_on);
                articles[i].setArticle(article);
                articles[i].setArticle_type(article_type);
                articles[i].setAuthor(author);
                articles[i].setArticle_date(article_date);
                articles[i].setArticle_timestamp(article_timestamp);
                articles[i].setSub_category_id(sub_category_id);
                articles[i].setArticle_rating(article_rating);
                articles[i].setArticle_layout(article_layout);
                articles[i].setArticle_heading(article_heading);

                try {
                    list.add(articles[i]);
                } catch (Exception e) {
                    System.out.println("Error in adding element... :");
                    e.printStackTrace();
                }
                /*Rules..*/
            }
        } catch (SQLException e) {
            System.out.println("Error in Comments class... :");
            e.printStackTrace();
            throw e;
        } catch (Exception ex) {
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error making database obj.");
        } finally {
            if(db!=null)
            db.close();
        }
    }

    @Override
    public String toString() {
        return "Magazine{" + "cp=" + cp + "mag_id=" + mag_id + "articles=" + articles + "list=" + list + '}';
    }

    public ArticleInMagazine[] getArticles() {
        return articles;
    }

    public ArrayList getList() {
        return list;
    }

    public String getMag_id() {
        return mag_id;
    }

    public void setCp(ConnectionParameters cp) {
        this.cp = cp;
    }

    public void setMag_id(String mag_id) {
        this.mag_id = mag_id;
    }
    private ConnectionParameters cp = null;
    private String mag_id;
    private ArticleInMagazine[] articles;
    private ArrayList list = null;
    public static final int ALL = 1;
}
