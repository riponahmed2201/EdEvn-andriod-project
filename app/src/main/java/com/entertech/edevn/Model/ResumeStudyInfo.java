package com.entertech.edevn.Model;

public class ResumeStudyInfo {
    Integer id, userId, categoryId,totalLesson, isCompletedLesson;
    String chapterName, coverImage, createdAt, updatedAt;

    public ResumeStudyInfo(Integer id, Integer userId, Integer categoryId, Integer totalLesson, Integer isCompletedLesson, String chapterName, String coverImage, String createdAt, String updatedAt) {
        this.id = id;
        this.userId = userId;
        this.categoryId = categoryId;
        this.totalLesson = totalLesson;
        this.isCompletedLesson = isCompletedLesson;
        this.chapterName = chapterName;
        this.coverImage = coverImage;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getTotalLesson() {
        return totalLesson;
    }

    public void setTotalLesson(Integer totalLesson) {
        this.totalLesson = totalLesson;
    }

    public Integer getIsCompletedLesson() {
        return isCompletedLesson;
    }

    public void setIsCompletedLesson(Integer isCompletedLesson) {
        this.isCompletedLesson = isCompletedLesson;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
