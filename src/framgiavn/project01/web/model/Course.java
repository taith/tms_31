package framgiavn.project01.web.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Course implements Serializable {

	private Integer id;
	private String name;
	private String detail;
	private Date startDate;
	private Date endDate;

	private List<User> users;
	private List<Integer> listSubjectId;
	private List<SubjectCourse> subjectCourses;
	private List<TakeCourse> takeCourses;

	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<TakeCourse> getTakeCourses() {
		return takeCourses;
	}
	public void setTakeCourses(List<TakeCourse> takeCourses) {
		this.takeCourses = takeCourses;
	}
	public List<Integer> getListSubjectId() {
		return listSubjectId;
	}
	public void setListSubjectId(List<Integer> listSubjectId) {
		this.listSubjectId = listSubjectId;
	}

	public List<SubjectCourse> getSubjectCourses() {
		return subjectCourses;
	}
	public void setSubjectCourses(List<SubjectCourse> subjectCourses) {
		this.subjectCourses = subjectCourses;
	}
	public Course() {

	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
