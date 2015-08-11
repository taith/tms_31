package framgiavn.project01.web.action;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import framgiavn.project01.web.business.TaskBusiness;
import framgiavn.project01.web.model.Task;

public class TaskAction extends ActionSupport {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
		
	TaskBusiness subjectBusiness;
	Task task;
	public List<Task> taskList;
	
}