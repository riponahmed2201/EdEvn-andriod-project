
package com.entertech.edevn.Model;

public class FreeLiveModelClass {

    Integer  course_id, categoryId, total_seats,is_downloadable;
    String course_type, courseTitle, publish_type, category_name,lavel, duration, language,payment_type, course_price, cover_image, class_time;

    public FreeLiveModelClass(Integer course_id, Integer categoryId, Integer total_seats, Integer is_downloadable, String course_type, String courseTitle, String publish_type, String category_name, String lavel, String duration, String language, String payment_type, String course_price, String cover_image, String class_time) {
        this.course_id = course_id;
        this.categoryId = categoryId;
        this.total_seats = total_seats;
        this.is_downloadable = is_downloadable;
        this.course_type = course_type;
        this.courseTitle = courseTitle;
        this.publish_type = publish_type;
        this.category_name = category_name;
        this.lavel = lavel;
        this.duration = duration;
        this.language = language;
        this.payment_type = payment_type;
        this.course_price = course_price;
        this.cover_image = cover_image;
        this.class_time = class_time;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getTotal_seats() {
        return total_seats;
    }

    public void setTotal_seats(Integer total_seats) {
        this.total_seats = total_seats;
    }

    public Integer getIs_downloadable() {
        return is_downloadable;
    }

    public void setIs_downloadable(Integer is_downloadable) {
        this.is_downloadable = is_downloadable;
    }

    public String getCourse_type() {
        return course_type;
    }

    public void setCourse_type(String course_type) {
        this.course_type = course_type;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getPublish_type() {
        return publish_type;
    }

    public void setPublish_type(String publish_type) {
        this.publish_type = publish_type;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getLavel() {
        return lavel;
    }

    public void setLavel(String lavel) {
        this.lavel = lavel;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getCourse_price() {
        return course_price;
    }

    public void setCourse_price(String course_price) {
        this.course_price = course_price;
    }

    public String getCover_image() {
        return cover_image;
    }

    public void setCover_image(String cover_image) {
        this.cover_image = cover_image;
    }

    public String getClass_time() {
        return class_time;
    }

    public void setClass_time(String class_time) {
        this.class_time = class_time;
    }
}
