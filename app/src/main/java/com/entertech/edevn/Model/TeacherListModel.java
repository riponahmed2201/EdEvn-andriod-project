package com.entertech.edevn.Model;

public class TeacherListModel {

    private String teacherName, teacherImage;

    public TeacherListModel(String teacherName, String teacherImage) {
        this.teacherName = teacherName;
        this.teacherImage = teacherImage;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherImage() {
        return teacherImage;
    }

    public void setTeacherImage(String teacherImage) {
        this.teacherImage = teacherImage;
    }
}
