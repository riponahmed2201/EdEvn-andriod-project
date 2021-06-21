
package com.entertech.edevn.Model.PojoClass;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FreeLivePojoClass {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("courses")
    @Expose
    private List<Course> courses = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}
