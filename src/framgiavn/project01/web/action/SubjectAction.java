package framgiavn.project01.web.action;

import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import framgiavn.project01.web.business.*;
import framgiavn.project01.web.model.Subject;

public class SubjectAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SubjectBusiness subjectBusiness;
	Subject subject;
	
	public List<Subject> subjectList = new ArrayList<Subject>();

	public void setSubjectBusiness(SubjectBusiness subjectBusiness) {
		this.subjectBusiness = subjectBusiness;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<Subject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	
	public String listAllSubject() {
		subjectList = subjectBusiness.listSubject();
		
		return SUCCESS;
	}
	
	public String showSubject() {
		try {
			subject = subjectBusiness.findById(subject.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String newSubject() {
		subjectBusiness.addSubject(subject);
		subjectList = null;
		subjectList = subjectBusiness.listSubject();
		
		return SUCCESS;
	}
	
	public String updateSubject() throws Exception {
		subjectBusiness.updateSubject(subject);
		subjectList = null;
		subjectList = subjectBusiness.listSubject();
		
		return SUCCESS;
	}
	
	public String destroySubject() {
		subjectBusiness.deleteSubject(subject.getId());
		subjectList = null;
		subjectList = subjectBusiness.listSubject();
		
		return SUCCESS;
	}
	
	public String  editSubjectPage() {
		try{
			subject = subjectBusiness.findById(subject.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
}
