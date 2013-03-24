/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scoop.data;

import java.util.Date;

/**
 *
 * @author Rahul
 */
public class User {

    public User() {
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + "first_name=" + first_name + "last_name=" + last_name + "email_id=" + email_id + "phone=" + phone + "dob=" + dob + "type=" + type + "flag=" + flag + "flag_count=" + flag_count + "description=" + description + "role=" + role + '}';
    }
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getFlag_count() {
        return flag_count;
    }

    public void setFlag_count(int flag_count) {
        this.flag_count = flag_count;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public static final int ALL = 1;
    private String username;
    private String first_name;
    private String last_name;
    private String email_id;
    private String phone;
    private Date dob;
    private String type;
    private boolean flag;
    private int flag_count;
    private String description;
    private String role;
}
