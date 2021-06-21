
package com.entertech.edevn.Model.PojoClass;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeacherListPojo {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("instructors")
    @Expose
    private List<Instructor> instructors = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

}
