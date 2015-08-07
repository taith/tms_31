package framgiavn.project01.web.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Subject implements Serializable {
	
	private Integer id;
	private String name;
	private String detail;
	private Set<SubjectCourse> subjectCourses;

	public Set<SubjectCourse> getSubjectCourses() {
		return subjectCourses;
	}
	public void setSubjectCourses(Set<SubjectCourse> subjectCourses) {
		this.subjectCourses = subjectCourses;
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
	public Subject() {

	}	

}
