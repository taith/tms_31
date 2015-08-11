package framgiavn.project01.web.business;

import java.util.List;

import framgiavn.project01.web.model.Subject;

public interface SubjectBusiness {
	
	List<Subject> listSubject();
	
	List<Subject> listSubjectByCoureId(Integer id);
	
	List<Subject> listSubjectByNotCourseId(Integer id);
	
	void addSubject(Subject subject);
	
	void updateSubject(Subject subject) throws Exception;
	
	void deleteSubject(Integer id);

	Subject findById(Integer id) throws Exception;

}
