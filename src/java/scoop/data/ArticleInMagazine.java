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
public class ArticleInMagazine {
   private String mag_id;
   private String theme;
   private Date mag_date;
   private Date mag_added_on;
   private String page_id;
   private String article_id;
   private Date pages_last_modified;
   private Date page_added_on;
   private Date page_last_modified;
   private String article;
   private String article_type;
   private String author;
   private Date article_date;
   private Date article_timestamp;
   private String sub_category_id;
   private int article_rating;
   private String article_layout;
   private String article_heading;

    public ArticleInMagazine() {
    }

    public ArticleInMagazine(String mag_id, String theme, Date mag_date,
            Date mag_added_on, String page_id, String article_id,
            Date pages_last_modified, Date page_added_on,
            Date page_last_modified, String article, String article_type,
            String author, Date article_date, Date article_timestamp,
            String sub_category_id, int article_rating, String article_layout,
            String article_heading) {
        this.mag_id = mag_id;
        this.theme = theme;
        this.mag_date = mag_date;
        this.mag_added_on = mag_added_on;
        this.page_id = page_id;
        this.article_id = article_id;
        this.pages_last_modified = pages_last_modified;
        this.page_added_on = page_added_on;
        this.page_last_modified = page_last_modified;
        this.article = article;
        this.article_type = article_type;
        this.author = author;
        this.article_date = article_date;
        this.article_timestamp = article_timestamp;
        this.sub_category_id = sub_category_id;
        this.article_rating = article_rating;
        this.article_layout = article_layout;
        this.article_heading = article_heading;
    }

    @Override
    public String toString() {
        return "ArticleInMagazine{" + "mag_id=" + mag_id + "theme=" + theme + "mag_date=" + mag_date + "mag_added_on=" + mag_added_on + "page_id=" + page_id + "article_id=" + article_id + "pages_last_modified=" + pages_last_modified + "page_added_on=" + page_added_on + "page_last_modified=" + page_last_modified + "article=" + article + "article_type=" + article_type + "author=" + author + "article_date=" + article_date + "article_timestamp=" + article_timestamp + "sub_category_id=" + sub_category_id + "article_rating=" + article_rating + "article_layout=" + article_layout + "article_heading=" + article_heading + '}';
    }


    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getArticle_heading() {
        return article_heading;
    }

    public void setArticle_heading(String article_heading) {
        this.article_heading = article_heading;
    }

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getArticle_layout() {
        return article_layout;
    }

    public void setArticle_layout(String article_layout) {
        this.article_layout = article_layout;
    }

    public String getArticle_type() {
        return article_type;
    }

    public void setArticle_type(String article_type) {
        this.article_type = article_type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMag_id() {
        return mag_id;
    }

    public void setMag_id(String mag_id) {
        this.mag_id = mag_id;
    }

    public String getPage_id() {
        return page_id;
    }

    public void setPage_id(String page_id) {
        this.page_id = page_id;
    }

    public String getSub_category_id() {
        return sub_category_id;
    }

    public void setSub_category_id(String sub_category_id) {
        this.sub_category_id = sub_category_id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Date getArticle_date() {
        return article_date;
    }

    public void setArticle_date(Date article_date) {
        this.article_date = article_date;
    }

    public int getArticle_rating() {
        return article_rating;
    }

    public void setArticle_rating(int article_rating) {
        this.article_rating = article_rating;
    }

    public Date getArticle_timestamp() {
        return article_timestamp;
    }

    public void setArticle_timestamp(Date article_timestamp) {
        this.article_timestamp = article_timestamp;
    }

    public Date getMag_added_on() {
        return mag_added_on;
    }

    public void setMag_added_on(Date mag_added_on) {
        this.mag_added_on = mag_added_on;
    }

    public Date getMag_date() {
        return mag_date;
    }

    public void setMag_date(Date mag_date) {
        this.mag_date = mag_date;
    }

    public Date getPage_added_on() {
        return page_added_on;
    }

    public void setPage_added_on(Date page_added_on) {
        this.page_added_on = page_added_on;
    }

    public Date getPage_last_modified() {
        return page_last_modified;
    }

    public void setPage_last_modified(Date page_last_modified) {
        this.page_last_modified = page_last_modified;
    }

    public Date getPages_last_modified() {
        return pages_last_modified;
    }

    public void setPages_last_modified(Date pages_last_modified) {
        this.pages_last_modified = pages_last_modified;
    }

    
}
