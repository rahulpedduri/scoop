/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scoop.doers;

import scoop.database.ConnectionParameters;
import scoop.database.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import scoop.data.MenuItem;
import scoop.exception.BeanIncompleteException;

/**
 *
 * @author Rahul
 */
public class GetCategoryMenu implements GetData{

    public GetCategoryMenu() {
    }

    public GetCategoryMenu(ConnectionParameters cp) throws SQLException, BeanIncompleteException {
        this.cp=cp;
        fetch();
    }

    public final void fetch() throws SQLException, BeanIncompleteException {
         Database db = null;
        PreparedStatement ps = null;
        int count=0;
        String category_id;
        String sub_category_id;
        String sub_category_name;
        String sub_category_description;
        String sub_category_added_on;
        String category_name;
        String category_description;
        String category_added_on;
        String msg=null;
        boolean flag=false;
        try {
             if(cp == null){
                 msg=" connection parameters have not been supplied. ";
                 flag=true;
             }
             if(flag){
                 throw new BeanIncompleteException(msg);
             }

            db = new Database(cp);
            String query = "select category_id,sub_category_id,sub_category_name,"
                    + "sub_category_description,sub_category_added_on,"
                    + "category_name,category_description,category_added_on,"
                    + "(select count(*) from category_view) as result_count"
                    + " from category_view order by category_name";
            ps = (PreparedStatement) db.getPreparedStatement(query);
            ResultSet rs = db.runPreparedStatement(ps);
            if (rs.next()) {
                count = rs.getInt("result_count");
                rs.beforeFirst();
            } //needs to be the num of rows in resultset

            item = new MenuItem[count];
            list = new ArrayList();
            for (int i = 0; rs.next(); i++) {
                category_id = rs.getString("category_id");
                sub_category_id = rs.getString("sub_category_id");
                sub_category_name = rs.getString("sub_category_name");
                sub_category_description = rs.getString("sub_category_description");
                sub_category_added_on = rs.getString("sub_category_added_on");
                category_name = rs.getString("category_name");
                category_description = rs.getString("category_description");
                category_added_on = rs.getString("category_added_on");
                
                item[i] = new MenuItem();
                item[i].setCategory_id(category_id);
                item[i].setSub_category_id(sub_category_id);
                item[i].setCategory_name(category_name);
                item[i].setSub_category_name(sub_category_name);
                item[i].setSub_category_description(sub_category_description);
                item[i].setCategory_added_on(category_added_on);
                item[i].setSub_category_added_on(sub_category_added_on);
                item[i].setCategory_description(category_description);

                try {
                    list.add(item[i]);
                } catch (Exception e) {
                    System.out.println("error in adding to list.");
                }
            }

        } catch (SQLException e) {
            throw e;
        } catch(BeanIncompleteException e){
            throw e;
        } catch (Exception e) {
        } finally {
            if(db!=null)
            db.close();
        }
    }

    @Override
    public String toString() {
        return "CategoryMenu{" + "item=" + item + "list=" + list + "cp=" + cp + '}';
    }


    public MenuItem[] getItem() {
        return item;
    }

    public ArrayList getList() {
        return list;
    }

    public void setCp(ConnectionParameters cp) {
        this.cp = cp;
    }


    public static final int ALL = 1;
    private MenuItem[] item;
    private ArrayList list = null;
    private ConnectionParameters cp=null;

}
