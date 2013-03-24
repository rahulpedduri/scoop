/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scoop.doers;

import java.io.File;
import scoop.database.ConnectionParameters;
import scoop.database.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import scoop.data.Article;
import scoop.data.Comment;
import scoop.exception.BeanIncompleteException;

/**
 *
 * @author Rahul
 */
public class GetComments implements GetData {

    /**
     *
     */
    public GetComments() {
    }

    /**
     *
     * @param article_id
     * @param cp
     * @throws SQLException
     * @throws BeanIncompleteException
     */
    public GetComments(String article_id, ConnectionParameters cp) throws SQLException, BeanIncompleteException {
        this.article_id = article_id;
        this.cp = cp;
        fetch();
    }

    /**
     *
     * @throws SQLException
     * @throws BeanIncompleteException
     */
    public final void fetch() throws SQLException, BeanIncompleteException {
        String comment_id;
        String reply_id;
        String comment;
        Date comment_added_on;
        boolean comment_flag;
        int comment_flag_count;
        String username;
        String first_name;
        String last_name;
        String user_type;
        String resource_tiny;
        String resource_medium;
        String resource_large;

        int count = 0;
        Database db = null;
        PreparedStatement ps = null;
        String msg = null;
        boolean flag = false;
        errors = new Error();

        try {

            if (article_id == null || article_id.equals("")) {
                msg += " Article Id is not given. ";
                flag = true;
            }
            if (cp == null) {
                msg += " Connection Parameters have not been supplied. ";
                flag = true;
            }
            if (context == null) {
                msg += " Servlet Context has not been supplied. ";
                flag = true;
            }
            if (flag) {
                throw new BeanIncompleteException(msg);
            }

            db = new Database(cp);
            String query = "select comment_id,article_id,reply_id,comment,"
                    + "comment_added_on,comment_flag,comment_flag_count,"
                    + "username,first_name,last_name,user_type,resource_tiny,"
                    + "resource_medium,resource_large,"
                    + "(select count(*) from comments_view where article_id=?) "
                    + "as result_count from comments_view "
                    + "where article_id=? order by comment_added_on asc";
            ps = (PreparedStatement) db.getPreparedStatement(query);
            int id = 0;
            try {
                id = Integer.parseInt(article_id);
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
            if (count == 0) {
                fetch = true;
                message = Constants.EMPTY_RESULT;
                return;
            }

            comm = new Comment[count];
            list = new ArrayList();
            for (int i = 0; rs.next(); i++) {
                comment_id = rs.getString("comment_id");
                reply_id = rs.getString("reply_id");
                comment = rs.getString("comment");
                comment_added_on = rs.getTimestamp("comment_added_on");
                comment_flag = rs.getBoolean("comment_flag");
                comment_flag_count = rs.getInt("comment_flag_count");
                username = rs.getString("username");
                first_name = rs.getString("first_name");
                last_name = rs.getString("last_name");
                user_type = rs.getString("user_type");
                resource_tiny = rs.getString("resource_tiny");
                resource_medium = rs.getString("resource_medium");
                resource_large = rs.getString("resource_large");

                if ((resource_tiny == null && resource_medium == null && resource_large == null)
                        || (!new File(context.getRealPath(resource_tiny)).exists()
                        && !new File(context.getRealPath(resource_medium)).exists()
                        && !new File(context.getRealPath(resource_large)).exists())) {
                    message = Constants.EMPTY_RESOURCE;
                    errors.add("ResourceNotFoundExceptionInGetArticle");
                }

                comm[i] = new Comment();
                comm[i].setComment_id(comment_id);
                comm[i].setArticle_id(article_id);
                comm[i].setReply_id(reply_id);
                comm[i].setComment(comment);
                comm[i].setComment_added_on(comment_added_on);
                comm[i].setComment_flag(comment_flag);
                comm[i].setComment_flag_count(comment_flag_count);
                comm[i].setUsername(username);
                comm[i].setFirst_name(first_name);
                comm[i].setLast_name(last_name);
                comm[i].setUser_type(user_type);
                comm[i].setResource_tiny(resource_tiny);
                comm[i].setResource_medium(resource_medium);
                comm[i].setResource_large(resource_large);

                try {
                    list.add(comm[i]);
                } catch (Exception e) {
                    System.out.println("Error in adding element... :");
                    e.printStackTrace();
                }

                /*Rules..*/
                fetch = true;

            }
        } catch (SQLException e) {
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, e);
            fetch = false;
            errors.add("SQLExceptionInGetArticle");
        } catch (BeanIncompleteException e) {
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, e);
            fetch = false;
            errors.add("BeanIncompleteExceptionInGetArticle");
        } catch (Exception ex) {
            fetch = false;
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error making database obj.");
            errors.add("BeanIncompleteExceptionInGetArticle");
        } finally {
            db.close();
        }
    }

    @Override
    public String toString() {
        return "GetComments{" + "article_id=" + article_id + "cp=" + cp + "comm=" + comm + "list=" + list + '}';
    }

    /**
     *
     * @return
     */
    public String getArticle_id() {
        return article_id;
    }

    /**
     *
     * @return
     */
    public Comment[] getComm() {
        return comm;
    }

    /**
     *
     * @return
     */
    public ArrayList getList() {
        return list;
    }

    /**
     *
     * @param article_id
     */
    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    /**
     *
     * @param cp
     */
    public void setCp(ConnectionParameters cp) {
        this.cp = cp;
    }

    /**
     *
     * @return
     */
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

    /**
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * sets the ServletContext to the context(of type ServletContext) object in the class.
     * This way, servlet related possibilities that depend on that object can be achieved without any unnecessary intervention of any servlet.
     * @param context
     */
    public void setContext(ServletContext context) {
        this.context = context;
    }

    private ServletContext context;
    private Error errors;
    private String message = "";
    private boolean fetch;
    private String article_id;
    private ConnectionParameters cp = null;
    private Comment[] comm;
    private ArrayList list = null;
    /**
     *
     */
}
