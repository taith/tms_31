package framgiavn.project01.web.action;

import com.opensymphony.xwork2.ActionSupport;

import framgiavn.project01.web.model.*;

public class AssignUserAction extends ActionSupport {
	
	CourseAction courseAction;
	Course course;

	public CourseAction getCourseAction() {
		return courseAction;
	}

	public void setCourseAction(CourseAction courseAction) {
		this.courseAction = courseAction;
	}
	
	public String addUserCourseNew() throws Exception {
		System.out.println(course.getId());
		return SUCCESS;
	}

}
