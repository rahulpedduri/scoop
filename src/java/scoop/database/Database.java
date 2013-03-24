/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scoop.database;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rahul
 */
public class Database {

    private Connection conn = null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;

    public Database(String driver, String url, String db, String username, String password, String props) throws Exception {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + db+props, username, password);

        } catch (Exception e) {
            System.out.println("could not connect to database, error:");
            e.printStackTrace();
            throw e;
        }
    }
    public Database(ConnectionParameters cp) throws Exception{
        String url=cp.getUrl();
        String driver=cp.getDriver();
        String db=cp.getDb();
        String username=cp.getUsername();
        String password=cp.getPassword();
        String props=cp.getProps();

        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + db+props, username, password);

        } catch (Exception e) {
            System.out.println("could not connect to database, error:");
            e.printStackTrace();
            throw e;
        }
    }
    public Database() throws Exception{
        String url = "jdbc:mysql://localhost:3306/";
        String driver = "com.mysql.jdbc.Driver";
        String db = "scoop";
        String username = "root";
        String password="";
        String props="";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + db+props, username, password);

        } catch (Exception e) {
            System.out.println("could not connect to database, error:");
            e.printStackTrace();
            throw e;
        }
    }

    public PreparedStatement getPreparedStatement(String query){
        try{
            ps=conn.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
        }
        catch(Exception e){
            System.out.println("Error creating prepared statement: ");
            e.printStackTrace();
        }
        return ps;   
    }

    public ResultSet runPreparedStatement(PreparedStatement ps){
        try{
            rs=ps.executeQuery();
        }
        catch(Exception e){
            System.out.println("Error in running prepared statement: ");
            e.printStackTrace();
        }
        return rs;
    }
     public ResultSet runPreparedStatement(){
        try{
            rs=ps.executeQuery();
        }
        catch(Exception e){
            System.out.println("Error in running prepared statement: ");
            e.printStackTrace();
        }
        return rs;
    }
     public void close(){
        try {
            rs.close();
            ps.close();
            conn.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

     }


        /*
        public static void main(String ar[]){
        String driver="com.mysql.jdbc.Driver", url="jdbc:mysql://localhost:3306/", db="scoop",username="root", password="";
        try {
        Class.forName(driver).newInstance();
        Connection conn = DriverManager.getConnection(url + db, username, password);
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from articles");
        while(rs.next()){
        System.out.println(rs.getString("author")+" "+rs.getString("article")+" "+rs.getString("article_id"));
        }
        } catch (Exception e) {
        System.out.println("could not connect to database, error:");
        e.printStackTrace();
        }
        }
         */
    /*
    public static void main(String ar[]){
        String driver="com.mysql.jdbc.Driver", url="jdbc:mysql://localhost:3306/", db="scoop",username="root", password="";
         try {
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url + db, username, password);
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from articles");
            while(rs.next()){
                System.out.println(rs.getString("author")+" "+rs.getString("article")+" "+rs.getString("article_id"));
            }

        } catch (Exception e) {
            System.out.println("could not connect to database, error:");
            e.printStackTrace();
        }
    }
 */

}

