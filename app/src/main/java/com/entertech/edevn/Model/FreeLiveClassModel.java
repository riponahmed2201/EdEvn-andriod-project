package com.entertech.edevn.Model;

public class FreeLiveClassModel {
    private int courseId,categoryId,coursePrice,isDownloadable,totalSeats;
    private String courseType,courseTitle,publishType,categoryName,lavel,duration,language,paymentType,classTime,coverImage;

    public FreeLiveClassModel(int courseId, int categoryId, int coursePrice, int isDownloadable, int totalSeats, String courseType, String courseTitle, String publishType, String categoryName, String lavel, String duration, String language, String paymentType, String classTime, String coverImage) {
        this.courseId = courseId;
        this.categoryId = categoryId;
        this.coursePrice = coursePrice;
        this.isDownloadable = isDownloadable;
        this.totalSeats = totalSeats;
        this.courseType = courseType;
        this.courseTitle = courseTitle;
        this.publishType = publishType;
        this.categoryName = categoryName;
        this.lavel = lavel;
        this.duration = duration;
        this.language = language;
        this.paymentType = paymentType;
        this.classTime = classTime;
        this.coverImage = coverImage;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(int coursePrice) {
        this.coursePrice = coursePrice;
    }

    public int getIsDownloadable() {
        return isDownloadable;
    }

    public void setIsDownloadable(int isDownloadable) {
        this.isDownloadable = isDownloadable;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
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