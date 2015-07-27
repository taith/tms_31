package framgiavn.project01.web.business;

import java.util.List;

import framgiavn.project01.web.model.Subject;

public interface SubjectBusiness {
	
	List<Subject> listSubject();
	
	void addSubject(Subject subject);
	
	void updateSubject(Subject subject) throws Exception;
	
	void deleteSubject(Integer id);

	Subject findById(Integer id) throws Exception;

}
