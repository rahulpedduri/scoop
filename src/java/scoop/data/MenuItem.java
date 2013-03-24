/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scoop.data;

/**
 *
 * @author Rahul
 */
public class MenuItem {

    public MenuItem() {
    }

    public MenuItem(String category_id, String sub_category_id,
            String sub_category_name, String sub_category_description,
            String sub_category_added_on, String category_name,
            String category_description, String category_added_on) {
        this.category_id = category_id;
        this.sub_category_id = sub_category_id;
        this.sub_category_name = sub_category_name;
        this.sub_category_description = sub_category_description;
        this.sub_category_added_on = sub_category_added_on;
        this.category_name = category_name;
        this.category_description = category_description;
        this.category_added_on = category_added_on;
    }

    public void setCategory_added_on(String category_added_on) {
        this.category_added_on = category_added_on;
    }

    public void setCategory_description(String category_description) {
        this.category_description = category_description;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public void setSub_category_added_on(String sub_category_added_on) {
        this.sub_category_added_on = sub_category_added_on;
    }

    public void setSub_category_description(String sub_category_description) {
        this.sub_category_description = sub_category_description;
    }

    public void setSub_category_id(String sub_category_id) {
        this.sub_category_id = sub_category_id;
    }

    public void setSub_category_name(String sub_category_name) {
        this.sub_category_name = sub_category_name;
    }

    public String getCategory_added_on() {
        return category_added_on;
    }

    public String getCategory_description() {
        return category_description;
    }

    public String getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public String getSub_category_added_on() {
        return sub_category_added_on;
    }

    public String getSub_category_description() {
        return sub_category_description;
    }

    public String getSub_category_id() {
        return sub_category_id;
    }

    public String getSub_category_name() {
        return sub_category_name;
    }

    @Override
    public String toString() {
        return "MenuItem{" + "category_id=" + category_id + "sub_category_id=" + sub_category_id + "sub_category_name=" + sub_category_name + "sub_category_description=" + sub_category_description + "sub_category_added_on=" + sub_category_added_on + "category_name=" + category_name + "category_description=" + category_description + "category_added_on=" + category_added_on + '}';
    }



public static final int ALL = 1;
private String category_id;
private String sub_category_id;
private String sub_category_name;
private String sub_category_description;
private String sub_category_added_on;
private String category_name;
private String category_description;
private String category_added_on;

}
