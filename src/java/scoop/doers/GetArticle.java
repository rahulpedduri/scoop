/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scoop.doers;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import scoop.data.Article;
import scoop.database.ConnectionParameters;
import scoop.database.Database;
import scoop.exception.BeanIncompleteException;
import scoop.exception.ResourceNotFoundException;

/**
 *
 * @author Rahul
 */
public class GetArticle implements GetData {

    public GetArticle() {
    }

    public GetArticle(String article_id, ConnectionParameters cp) throws SQLException, BeanIncompleteException {
        this.article_id = article_id;
        this.cp = cp;
        fetch();
    }

    public final void fetch() throws SQLException, BeanIncompleteException {

        String type;
        String author;
        Date date_added;
        Date last_modified;
        String sub_category_id;
        int rating;
        boolean flag;
        int flag_count;
        String heading;
        String layout;
        String extra_desc;
        boolean author_done;
        boolean editor_done;
        boolean designer_done;
        String extra_doc;
        String resource_tiny;
        String resource_medium;
        String resource_large;
        String resource_type;
        String resource_username;

        Database db = null;
        PreparedStatement ps = null;
        String msg = null;
        boolean f = false;
        errors = new Error();
        try {

            if (article_id == null || article_id.equals("")) {
                msg += " Article Id is not given. ";
                f = true;
            }
            if (cp == null) {
                msg += " Connection Parameters have not been supplied. ";
                f = true;
            }if (context == null) {
                msg += " Servlet Context has not been supplied. ";
                f = true;
            }
            if (f) {
                throw new BeanIncompleteException(msg);
            }

            db = new Database(cp);
            String query = "select article_id,article, type,author,timestamp, sub_category_id,"
                    + "rating, flag,flag_count, heading,layout, extra_desc,"
                    + "author_done, editor_done,DATE_FORMAT(date, '%d %m %Y') as dt,"
                    + "designer_done, extra_doc,resource_tiny,"
                    + "resource_medium,resource_large,resource_type,"
                    + "resource_username from article_view where article_id=?";
            ps = db.getPreparedStatement(query);
            int id = 0;
            try {
                id = Integer.parseInt(article_id);
            } catch (Exception e) {
                System.out.println("error in parsing: ");
                e.printStackTrace();
            }
            ps.setInt(1, id);
            ResultSet rs = db.runPreparedStatement(ps);
            while (rs.next()) {

                type = rs.getString("type");
                author = rs.getString("author");
                date_added = rs.getDate("dt");
                last_modified = rs.getTimestamp("timestamp");
                sub_category_id = rs.getString("sub_category_id");
                rating = rs.getInt("rating");
                flag = rs.getBoolean("flag");
                flag_count = rs.getInt("flag_count");
                heading = rs.getString("heading");
                layout = rs.getString("layout");
                extra_desc = rs.getString("extra_desc");
                author_done = rs.getBoolean("author_done");
                editor_done = rs.getBoolean("editor_done");
                designer_done = rs.getBoolean("designer_done");
                extra_doc = rs.getString("extra_doc");
                resource_tiny = rs.getString("resource_tiny");
                resource_medium = rs.getString("resource_medium");
                resource_large = rs.getString("resource_large");
                resource_type = rs.getString("resource_type");
                resource_username = rs.getString("resource_username");

                if((resource_tiny==null && resource_medium==null && resource_large==null )
                 || (! new File(context.getRealPath(resource_tiny)).exists() &&
                        ! new File(context.getRealPath(resource_medium)).exists() &&
                        ! new File(context.getRealPath(resource_large)).exists()))
                {throw new ResourceNotFoundException();}

                article = new Article();
                article.setArticle_id(article_id);
                article.setAuthor(author);
                article.setType(type);
                article.setDate_added(date_added);
                article.setLast_modified(last_modified);
                article.setSub_category_id(sub_category_id);
                article.setRating(rating);
                article.setFlag(flag);
                article.setFlag_count(flag_count);
                article.setHeading(heading);
                article.setLayout(layout);
                article.setExtra_desc(extra_desc);
                article.setAuthor_done(author_done);
                article.setEditor_done(editor_done);
                article.setDesigner_done(designer_done);
                article.setExtra_doc(extra_doc);
                article.setResource_tiny(resource_tiny);
                article.setResource_medium(resource_medium);
                article.setResource_large(resource_large);
                article.setResource_type(resource_type);
                article.setResource_username(resource_username);

                /* Rules..*/
                fetch = true;

            }
        } catch (SQLException e) {
            fetch = false;
            errors.add("SQLExceptionInGetArticle");
            e.printStackTrace();
            
        } catch (BeanIncompleteException e) {
            fetch = false;
            errors.add("BeanIncompleteExceptionInGetArticle");
      
        }catch(ResourceNotFoundException e){
            fetch=false;
            errors.add("ResourceNotFoundExceptionInGetArticle");
            message=Constants.EMPTY_RESOURCE;
        }
        catch (Exception ex) {
            fetch = false;
            errors.add("UnknownExceptionInGetArticle");
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }

    @Override
    public String toString() {
        return "GetArticle{" + "article_id=" + article_id + "article=" + article + "cp=" + cp + '}';
    }

    public Article getArticle() {
        return article;
    }

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public void setCp(ConnectionParameters cp) {
        this.cp = cp;
    }

    public boolean isFetch() {
        if (!fetch) {
            try {
                fetch();
            } catch (SQLException ex) {
                Logger.getLogger(GetArticle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BeanIncompleteException ex) {
                Logger.getLogger(GetArticle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return fetch;
    }

    public Error getErrors() {
        return errors;
    }

    public String getMessage() {
        return message;
    }

    public void setContext(ServletContext context) {
        this.context = context;
    }


    private ServletContext context;
    private String message="";
    private Error errors;
    private boolean fetch;
    private String article_id;
    private Article article = null;
    private ConnectionParameters cp = null;
}
