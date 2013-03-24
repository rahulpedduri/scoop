/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scoop.data;

/**
 *
 * @author Rahul
 */
public class Permission {

    public Permission() {
    }


    public String getPerm_category() {
        return perm_category;
    }

    public void setPerm_category(String perm_category) {
        this.perm_category = perm_category;
    }

    public String getPerm_display_name() {
        return perm_display_name;
    }

    public void setPerm_display_name(String perm_display_name) {
        this.perm_display_name = perm_display_name;
    }

    public String getPerm_name() {
        return perm_name;
    }

    public void setPerm_name(String perm_name) {
        this.perm_name = perm_name;
    }

    public boolean isPerm_value() {
        return perm_value;
    }

    public void setPerm_value(boolean perm_value) {
        this.perm_value = perm_value;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Permission{" + "username=" + username + "role=" + role +
                "perm_name=" + perm_name + "perm_value=" + perm_value +
                "perm_category=" + perm_category + "perm_display_name=" +
                perm_display_name + '}';
    }


 private String username;
private String role;
private String perm_name;
private boolean perm_value;
private String perm_category;
private String perm_display_name;

}
