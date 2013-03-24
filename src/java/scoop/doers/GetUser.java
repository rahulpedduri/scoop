/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scoop.doers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import scoop.data.User;
import scoop.database.ConnectionParameters;
import scoop.database.Database;
import scoop.exception.BeanIncompleteException;

/**
 *
 * @author Rahul
 */
public class GetUser implements GetData {

    public GetUser() {
    }

    public GetUser(String username, ConnectionParameters cp) throws SQLException, BeanIncompleteException {
        this.username = username;
        this.cp = cp;
        fetch();
    }

    public final void fetch() throws SQLException, BeanIncompleteException {
        String first_name;
        String last_name;
        String email_id;
        String phone;
        Date dob;
        String type;
        boolean flag;
        int flag_count;
        String description;
        String role;

        Database db = null;
        PreparedStatement ps = null;
        String msg=null;
        boolean f=false;
        try {
             if (username == null || username.equals("")) {
                msg += " Username is not given. ";
                f = true;
            }
            if (cp == null) {
                msg += " Connection Parameters have not been supplied. ";
                f = true;
            }
            if (f) {
                throw new BeanIncompleteException(msg);
            }

            db = new Database(cp);
            String query = "select username,first_name, last_name, email_id, "
                    + "description, dob, flag, flag_count, phone, role, type "
                    + "from users where username=?";

            ps = db.getPreparedStatement(query);
            ps.setString(1, username);
            ResultSet rs = db.runPreparedStatement(ps);
            while (rs.next()) {

                first_name = rs.getString("first_name");
                last_name = rs.getString("last_name");
                email_id = rs.getString("email_id");
                description = rs.getString("description");
                dob = rs.getDate("dob");
                flag = rs.getBoolean("flag");
                flag_count = rs.getInt("flag_count");
                phone = rs.getString("phone");
                role = rs.getString("role");
                type = rs.getString("type");

                user = new User();
                user.setUsername(username);
                user.setFirst_name(first_name);
                user.setLast_name(last_name);
                user.setEmail_id(email_id);
                user.setDescription(description);
                user.setDob(dob);
                user.setFlag(flag);
                user.setFlag_count(flag_count);
                user.setPhone(phone);
                user.setRole(role);
                user.setType(type);
            }
        } catch (SQLException e) {
            System.out.println("Error in User class... :");
            e.printStackTrace();
            throw e;
        } catch (Exception ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error making database obj.");
        } finally {
            if(db!=null)
            db.close();
        }

    }

    @Override
    public String toString() {
        return "GetUser{" + "username=" + username + "cp=" + cp + "user=" + user + '}';
    }

    
    public User getUser() {
        return user;
    }

    public String getUsername() {
        return username;
    }

    public void setCp(ConnectionParameters cp) {
        this.cp = cp;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    private String username;
    private ConnectionParameters cp = null;
    private User user = null;
}
