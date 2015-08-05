package framgiavn.project01.web.dao;

import framgiavn.project01.web.model.SubjectCourse;

public interface SubjectCourseDAO {
	
	public void addSubjectToCourse(SubjectCourse subjectCourse);
	
	public void removeSubjectFromCourse(Integer subject_id, Integer course_id);

}
