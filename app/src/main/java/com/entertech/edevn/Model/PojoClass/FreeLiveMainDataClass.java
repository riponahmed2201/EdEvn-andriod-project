
package com.entertech.edevn.Model.PojoClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FreeLiveMainDataClass {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("courses")
    @Expose
    private List<FreeLiveCourse> courses = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<FreeLiveCourse> getCourses() {
        return courses;
    }

    public void setCourses(List<FreeLiveCourse> courses) {
        this.courses = courses;
    }

}
