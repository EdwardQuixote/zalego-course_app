package uk.co.edwardquixote.Zalego.ZalegoCourseApp.DataModels;

import java.io.Serializable;

public class ModelCourse implements Serializable {

    private String course_title;
    private String course_description;


    public ModelCourse() {}


    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

}
