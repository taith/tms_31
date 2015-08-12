package framgiavn.project01.web.business;

import java.util.List;

import framgiavn.project01.web.model.*;

public interface CourseBusiness {
	
	List<Course> listCourse();
	
	List<Subject> listSubjectInCourse();
	
	List<User> listUserNotInCourse(Integer id);
	
	Course findById(Integer id) throws Exception;
	
	User findUserById(Integer id) throws Exception;

	void addCourse(Course course);
	
	void updateCourse(Course course) throws Exception;
	
	void deleteCourse(Integer id);
	
	void addSubjectCourse(SubjectCourse subjectCourse);
	
	void removeSubjectCourse(Integer subject_id, Integer course_id);
	
	void addUserCourse(TakeCourse takeCourse);
	
	void removeUserCourse(Integer user_id, Integer course_id);
}
