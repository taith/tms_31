package framgiavn.project01.web.dao;

import java.util.List;

import framgiavn.project01.web.model.Subject;

public interface SubjectDAO {
	
	public List<Subject> listSubject();
	
	public List<Subject> listSubjectByCoureId(Integer id, boolean lock);
	
	public List<Subject> listSubjectNotByCourseId(Integer id, boolean lock);
	
	public void addSubject(Subject subject);
	
	public void updateSubject(Subject subject);
	
	public void deleteSubject(Integer id);

	public Subject findById(Integer id, boolean lock) throws Exception;

}
