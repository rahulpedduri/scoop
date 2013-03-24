/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scoop.doers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import scoop.data.Article;
import scoop.data.Permission;
import scoop.database.ConnectionParameters;
import scoop.database.Database;
import scoop.exception.BeanIncompleteException;

/**
 *
 * @author Rahul
 */
public class GetPermissions implements GetData {

    public GetPermissions() {
    }

    public GetPermissions(String username, ConnectionParameters cp) throws SQLException, BeanIncompleteException {
        this.username = username;
        this.cp = cp;
        fetch();
    }

    public final void fetch() throws SQLException, BeanIncompleteException {
        Database db = null;
        PreparedStatement ps = null;
        String role;
        String perm_name;
        boolean perm_value;
        String perm_category;
        String perm_display_name;
        boolean flag = false;
        String msg = null;
        int count = 0;
        errors = new Error();
        try {

            if (username == null || username.equals("")) {
                msg += " Username is not given. ";
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
            String query = "select username,role,perm_name, perm_value,perm_category,"
                    + "perm_display_name,(select count(username)from user_perm_view"
                    + " where username =? and perm_value=true ) as result_count "
                    + "from user_perm_view where username=? and perm_value=true"
                    + " order by perm_category, perm_name desc";

            ps = db.getPreparedStatement(query);
            ps.setString(1, username);
            ps.setString(2, username);
            ResultSet rs = db.runPreparedStatement(ps);
            if (rs.next()) {
                count = rs.getInt("result_count");
                rs.beforeFirst();
            } //needs to be the num of rows in resultset
            System.out.println(count);
            if(count==0) {
                fetch=true;
                message=Constants.EMPTY_RESULT;
                return;
            }
            message=Constants.NORMAL;
            perm = new Permission[count];
            list = new HashMap<Object, Permission>();
            for (int i = 0; rs.next(); i++) {
                role = rs.getString("role");
                perm_name = rs.getString("perm_name");
                perm_value = rs.getBoolean("perm_value");
                perm_category = rs.getString("perm_category");
                perm_display_name = rs.getString("perm_display_name");

                perm[i] = new Permission();
                perm[i].setUsername(username);
                perm[i].setPerm_name(perm_name);
                perm[i].setPerm_value(perm_value);
                perm[i].setPerm_display_name(perm_display_name);
                perm[i].setPerm_category(perm_category);
                perm[i].setRole(role);
                
                try {
                    list.put(perm_name, perm[i]);
                }catch(Exception e){
                    throw e;
                }
                /* Rules..*/
                fetch=true;
            }
        } catch (SQLException e) {
            fetch = false;
            System.out.println("Error in GetPermissions class... :");
            errors.add("SQLExceptionInGetPermission");
            e.printStackTrace();            
        } catch (BeanIncompleteException e) {
            fetch = false;
            errors.add("BeanIncompleteExceptionInGetPermission");
        } catch (Exception ex) {
            fetch = false;
            Logger.getLogger(Article.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error making database obj.");
            errors.add("UnknownExceptionInGetPermission");
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }

    @Override
    public String toString() {
        return "Permissions{" + "username=" + username + "cp=" + cp + "list=" + list + "perm=" + perm + '}';
    }


    public void setCp(ConnectionParameters cp) {
        this.cp = cp;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public HashMap getList() {
        return list;
    }

    public Permission[] getPerm() {
        return perm;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
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
    public HashMap getHeader(){
        if(header==null){
            String previous="";
           header = new HashMap<Object,ArrayList<Permission>>();
           ArrayList val[] = new ArrayList[perm.length];

            for(int i=0,col=-1; i<perm.length;i++){
                if( i==0 ){
                    col++;
                    val[col]=new ArrayList<Permission>();
                }
                if(i>0 && !previous.equalsIgnoreCase(perm[i].getPerm_category())){
                   
                     col++;
                     val[col]=new ArrayList<String>();
                }
                try{
                    System.out.println("col="+col+"i="+i);
               val[col].add(perm[i]);
                 header.put(perm[i].getPerm_category(), val[col]);
                }catch(Exception e){
                    System.out.println("error adding to array list: "+e);
                }
                previous=perm[i].getPerm_category();

               
            }
           
        }
        System.out.println("header:"+header);
        return header;
    }

    public void setContext(ServletContext context) {
        this.context = context;
    }

    private ServletContext context;
   private HashMap header=null;
    private Error errors;
    private boolean fetch;
    private String message="";
    private String username = null;
    private ConnectionParameters cp = null;
    private HashMap<Object, Permission> list;
    private Permission[] perm=null;
    
}
