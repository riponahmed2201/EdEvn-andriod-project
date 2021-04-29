
package com.entertech.edevn.Model.PojoClass;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResumeMainDataClass {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("resume_study")
    @Expose
    private List<ResumeStudy> resumeStudy = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ResumeStudy> getResumeStudy() {
        return resumeStudy;
    }

    public void setResumeStudy(List<ResumeStudy> resumeStudy) {
        this.resumeStudy = resumeStudy;
    }

}
