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
public class Comment {

    /**
     *
     */
    public Comment() {
    }

   

    @Override
    public String toString() {
        return "Comment{" + "comment_id=" + comment_id + "article_id=" + article_id + "reply_id=" + reply_id + "comment=" + comment + "comment_added_on=" + comment_added_on + "comment_flag=" + comment_flag + "comment_flag_count=" + comment_flag_count + "username=" + username + "first_name=" + first_name + "last_name=" + last_name + "user_type=" + user_type + '}';
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
     * @param article_id
     */
    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    /**
     *
     * @return
     */
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     *
     * @return
     */
    public String getComment_id() {
        return comment_id;
    }

    /**
     *
     * @param comment_id
     */
    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    /**
     *
     * @return
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     *
     * @param first_name
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     *
     * @return
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     *
     * @param last_name
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     *
     * @return
     */
    public String getReply_id() {
        return reply_id;
    }

    /**
     *
     * @param reply_id
     */
    public void setReply_id(String reply_id) {
        this.reply_id = reply_id;
    }

    /**
     *
     * @return
     */
    public String getUser_type() {
        return user_type;
    }

    /**
     *
     * @param user_type
     */
    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public boolean isComment_flag() {
        return comment_flag;
    }

    /**
     *
     * @param comment_flag
     */
    public void setComment_flag(boolean comment_flag) {
        this.comment_flag = comment_flag;
    }

    /**
     *
     * @return
     */
    public int getComment_flag_count() {
        return comment_flag_count;
    }

    /**
     *
     * @param comment_flag_count
     */
    public void setComment_flag_count(int comment_flag_count) {
        this.comment_flag_count = comment_flag_count;
    }

    /**
     *
     * @return
     */
    public Date getComment_added_on() {
        return comment_added_on;
    }

    /**
     *
     * @param comment_added_on
     */
    public void setComment_added_on(Date comment_added_on) {
        this.comment_added_on = comment_added_on;
    }

    /**
     *
     * @return
     */
    public String getResource_large() {
        return resource_large;
    }

    /**
     *
     * @param resource_large
     */
    public void setResource_large(String resource_large) {
        this.resource_large = resource_large;
    }

    /**
     *
     * @return
     */
    public String getResource_medium() {
        return resource_medium;
    }

    /**
     *
     * @param resource_medium
     */
    public void setResource_medium(String resource_medium) {
        this.resource_medium = resource_medium;
    }

    /**
     *
     * @return
     */
    public String getResource_tiny() {
        return resource_tiny;
    }

    /**
     * 
     * @param resource_tiny
     */
    public void setResource_tiny(String resource_tiny) {
        this.resource_tiny = resource_tiny;
    }


    private String comment_id;
    private String article_id;
    private String reply_id;
    private String comment;
    private Date comment_added_on;
    private boolean comment_flag;
    private int comment_flag_count;
    private String username;
    private String first_name;
    private String last_name;
    private String user_type;
    private String resource_tiny;
private String resource_medium;
private String resource_large;
}
