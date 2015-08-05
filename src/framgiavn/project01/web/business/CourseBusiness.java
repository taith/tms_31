package framgiavn.project01.web.business;

import java.util.List;

import framgiavn.project01.web.model.*;

public interface CourseBusiness {
	
	List<Course> listCourse();
	
	List<Subject> listSubjectInCourse(Integer id);
	
	List<Subject> listSubjectNotInCourse(Integer id);
	
	Course findById(Integer id) throws Exception;

	void addCourse(Course course);
	
	void updateCourse(Course course) throws Exception;
	
	void deleteCourse(Integer id);
	
	void addSubjectToCourse(SubjectCourse subjectCourse);
	
	void removeSubjectFromCourse(Integer subject_id, Integer course_id);
	
}
