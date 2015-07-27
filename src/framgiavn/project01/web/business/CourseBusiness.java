package framgiavn.project01.web.business;

import java.util.List;

import framgiavn.project01.web.model.Course;

public interface CourseBusiness {
	
	List<Course> listCourse();
	
	Course findById(Integer id) throws Exception;

	void addCourse(Course course);
	
	void updateCourse(Course course) throws Exception;
	
	void deleteCourse(Integer id);
}
