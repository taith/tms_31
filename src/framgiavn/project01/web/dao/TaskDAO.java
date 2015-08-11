package framgiavn.project01.web.dao;

import java.util.List;

import framgiavn.project01.web.model.Task;

public interface TaskDAO {
	
	public List<Task> listTask();
	
	public void addTask(Task task);
	
	public void updateTask(Task task);
	
	public void deleteTask(Integer id);

	public Task findById(Integer id, boolean lock) throws Exception;

}
