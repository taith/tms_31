package framgiavn.project01.web.dao;

import framgiavn.project01.web.model.TakeCourse;

public interface TakeCourseDAO {

	public void addUserToSubject(TakeCourse takeCourse);
	
	public void removeUserFromCourse(Integer user_id, Integer course_id);
}
