package framgiavn.project01.web.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import framgiavn.project01.web.dao.TaskDAO;
import framgiavn.project01.web.model.Task;
import framgiavn.project01.web.ulti.Logit2;

public class TaskDAOImpl extends HibernateDaoSupport implements TaskDAO{
	
	private static final Logit2 log = Logit2.getInstance(TaskDAO.class);
	
	protected void initDao() {
		// do nothing
	}

	@Override
	public List<Task> listTask() {
		log.debug("List all Task");
		try{
			Query query = getSession().getNamedQuery("Task.SelectTaskAll");
			return query.list();
		} catch (RuntimeException re) {
			log.error("List all Task error!", re);
			throw re;
		}
	}

	@Override
	public void addTask(Task Task) {
		log.debug("Add Task");
		try {
			getHibernateTemplate().save(Task);
			
		} catch (RuntimeException re) {
			log.error("Add Task failed", re);
			throw re;
		}
	}

	@Override
	public void updateTask(Task Task) {
		log.debug("Update Task");
		try {
			getHibernateTemplate().update(Task);
		} catch (RuntimeException re) {
			log.error("Update Task failed", re);
			throw re;
		}
	}

	@Override
	public void deleteTask(Integer id) {
		log.debug("Delete a Task");
		try {
			Query query = getSession().getNamedQuery("Task.DeleteTaskById");
			query.setParameter("id", id);
			query.executeUpdate();
		} catch (RuntimeException re) {
			log.error("Delete failed");
			throw re;
		}
	}

	@Override
	public Task findById(Integer id, boolean lock) throws Exception {
		try {
			Query query = getSession().getNamedQuery("Task.SelectTaskById");
			if (lock)
				query.setLockMode("task", LockMode.UPGRADE);
			query.setParameter("id", id);
			return (Task) query.uniqueResult();
		} catch (RuntimeException re) {
			log.error("get course by id failed", re);
			throw re;
		}
	}	
}