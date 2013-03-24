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
public class Article {

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAuthor_done() {
        return author_done;
    }

    public void setAuthor_done(boolean author_done) {
        this.author_done = author_done;
    }

    public Date getDate_added() {
        return date_added;
    }

    public void setDate_added(Date date) {
        this.date_added = date;
    }

    public boolean isDesigner_done() {
        return designer_done;
    }

    public void setDesigner_done(boolean designer_done) {
        this.designer_done = designer_done;
    }

    public boolean isEditor_done() {
        return editor_done;
    }

    public void setEditor_done(boolean editor_done) {
        this.editor_done = editor_done;
    }

    public String getExtra_desc() {
        return extra_desc;
    }

    public void setExtra_desc(String extra_desc) {
        this.extra_desc = extra_desc;
    }

    public String getExtra_doc() {
        return extra_doc;
    }

    public void setExtra_doc(String extra_doc) {
        this.extra_doc = extra_doc;
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

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getResource_large() {
        return resource_large;
    }

    public void setResource_large(String resource_large) {
        this.resource_large = resource_large;
    }

    public String getResource_medium() {
        return resource_medium;
    }

    public void setResource_medium(String resource_medium) {
        this.resource_medium = resource_medium;
    }

    public String getResource_tiny() {
        return resource_tiny;
    }

    public void setResource_tiny(String resource_tiny) {
        this.resource_tiny = resource_tiny;
    }

    public String getResource_type() {
        return resource_type;
    }

    public void setResource_type(String resource_type) {
        this.resource_type = resource_type;
    }

    public String getResource_username() {
        return resource_username;
    }

    public void setResource_username(String resource_username) {
        this.resource_username = resource_username;
    }

    public String getSub_category_id() {
        return sub_category_id;
    }

    public void setSub_category_id(String sub_category_id) {
        this.sub_category_id = sub_category_id;
    }

    public Date getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(Date timestamp) {
        this.last_modified = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

   
    private String article_id;
    private String article;
    private String type;
    private Date date_added;
    private Date last_modified;
    private String sub_category_id;
    private int rating;
    private boolean flag;
    private int flag_count;
    private String layout;
    private String heading;
    private String extra_desc;
    private boolean author_done;
    private boolean editor_done;
    private boolean designer_done;
    private String extra_doc;
    private String author;
    private String resource_tiny;
    private String resource_medium;
    private String resource_large;
    private String resource_type;
    private String resource_username;
}
