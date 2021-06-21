
package com.entertech.edevn.Model.PojoClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Course {

    @SerializedName("course_id")
    @Expose
    private Integer courseId;
    @SerializedName("course_type")
    @Expose
    private String courseType;
    @SerializedName("course_title")
    @Expose
    private String courseTitle;
    @SerializedName("publish_type")
    @Expose
    private String publishType;
    @SerializedName("category_id")
    @Expose
    private Integer categoryId;
    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("lavel")
    @Expose
    private String lavel;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("payment_type")
    @Expose
    private String paymentType;
    @SerializedName("course_price")
    @Expose
    private Integer coursePrice;
    @SerializedName("is_downloadable")
    @Expose
    private Integer isDownloadable;
    @SerializedName("total_seats")
    @Expose
    private Integer totalSeats;
    @SerializedName("class_time")
    @Expose
    private String classTime;
    @SerializedName("cover_image")
    @Expose
    private String coverImage;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getPublishType() {
        return publishType;
    }

    public void setPublishType(String publishType) {
        this.publishType = publishType;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(Integer coursePrice) {
        this.coursePrice = coursePrice;
    }

    public Integer getIsDownloadable() {
        return isDownloadable;
    }

    public void setIsDownloadable(Integer isDownloadable) {
        this.isDownloadable = isDownloadable;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

}
