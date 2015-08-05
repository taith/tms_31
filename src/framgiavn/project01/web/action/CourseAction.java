package framgiavn.project01.web.action;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import framgiavn.project01.web.business.*;
import framgiavn.project01.web.model.*;
import framgiavn.project01.web.ulti.Logit2;

public class CourseAction extends ActionSupport {
	
	CourseBusiness courseBusiness;
	Course course;
	SubjectCourse subjectCourse;
	
	public List<Course> courseList = new ArrayList<Course>();
	public List<Subject> subjectInCourse = new ArrayList<Subject>();
	public List<Subject> subjectNotInCourse = new ArrayList<Subject>();
	
	public SubjectCourse getSubjectCourse() {
		return subjectCourse;
	}
	public void setSubjectCourse(SubjectCourse subjectCourse) {
		this.subjectCourse = subjectCourse;
	}
	public List<Subject> getSubjectNotInCourse() {
		return subjectNotInCourse;
	}
	public void setSubjectNotInCourse(List<Subject> subjectNotInCourse) {
		this.subjectNotInCourse = subjectNotInCourse;
	}
	public List<Subject> getSubjectInCourse() {
		return subjectInCourse;
	}
	public void setSubjectInCourse(List<Subject> subjectInCourse) {
		this.subjectInCourse = subjectInCourse;
	}
	public void setCourseBusiness(CourseBusiness courseBusiness) {
		this.courseBusiness = courseBusiness;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	
	public String listAllCourse() {
		
		courseList = courseBusiness.listCourse();
		
		return SUCCESS;
	}
	
	public String showCourse() {
		try {
			course = courseBusiness.findById(course.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String newCourse() throws Exception {
		
		course.setStartDate(new Date());
		courseBusiness.addCourse(course);
		courseList = null;
		courseList = courseBusiness.listCourse();
		
		return SUCCESS;
	}
	
	public String updateCourse() throws Exception {
		courseBusiness.updateCourse(course);
		courseList = null;
		courseList = courseBusiness.listCourse();
		
		return SUCCESS;
	}
	
	public String destroyCourse() {
		courseBusiness.deleteCourse(course.getId());
		courseList = null;
		courseList = courseBusiness.listCourse();
		
		return SUCCESS;
	}
	
	public String editCoursePage() {
		try {
			course = courseBusiness.findById(course.getId());
			subjectInCourse = courseBusiness.listSubjectInCourse(course.getId());
			subjectNotInCourse = courseBusiness.listSubjectNotInCourse(course.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String addSubjectCourse() {
		courseBusiness.addSubjectToCourse(subjectCourse);
		
		return SUCCESS;
	}
	
	public String removeSubjectCourse() {
		courseBusiness.removeSubjectFromCourse(subjectCourse.getSubject_id(), subjectCourse.getCourse_id());
		
		return SUCCESS;
	}
}
