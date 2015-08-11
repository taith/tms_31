package framgiavn.project01.web.business;

import java.util.List;
import framgiavn.project01.web.model.Task;

public interface TaskBusiness {
	
	List<Task> listTasks();
	
	void addTask(Task task);
	
	void updateTask(Task task) throws Exception;
	
	void deleteTask(Integer id);	
}