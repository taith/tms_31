package framgiavn.project01.web.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import framgiavn.project01.web.dao.SubjectDAO;
import framgiavn.project01.web.model.Course;
import framgiavn.project01.web.model.Subject;
import framgiavn.project01.web.ulti.Logit2;

public class SubjectDAOImpl extends HibernateDaoSupport implements SubjectDAO{
	
	private static final Logit2 log = Logit2.getInstance(SubjectDAO.class);
	
	protected void initDao() {
		// do nothing
	}

	@Override
	public List<Subject> listSubject() {
		log.debug("List all subject");
		try{
			Query query = getSession().getNamedQuery("Subject.SelectSubjectAll");
			return query.list();
		} catch (RuntimeException re) {
			log.error("List all subject error!", re);
			throw re;
		}
	}

	@Override
	public void addSubject(Subject subject) {
		log.debug("Add subject");
		try {
			getHibernateTemplate().save(subject);
		} catch (RuntimeException re) {
			log.error("Add subject failed", re);
			throw re;
		}
	}

	@Override
	public void updateSubject(Subject subject) {
		log.debug("Update subject");
		try {
			getHibernateTemplate().update(subject);
		} catch (RuntimeException re) {
			log.error("Update subject failed", re);
			throw re;
		}
	}

	@Override
	public void deleteSubject(Integer id) {
		log.debug("Delete a subject");
		try {
			Query query = getSession().getNamedQuery("Subject.DeleteSubjectById");
			query.setParameter("id", id);
			query.executeUpdate();
		} catch (RuntimeException re) {
			log.error("Delete failed");
			throw re;
		}
	}

	@Override
	public Subject findById(Integer id, boolean lock) throws Exception {
		try {
			Query query = getSession().getNamedQuery("Subject.SelectSubjectById");
			if (lock)
				query.setLockMode("subject", LockMode.UPGRADE);
			query.setParameter("id", id);
			return (Subject) query.uniqueResult();
		} catch (RuntimeException re) {
			log.error("get course by id failed", re);
			throw re;
		}
	}

	@Override
	public List<Subject> listSubjectByCourseId(Integer id, boolean lock) {
		log.debug("List subject by course_id");
		try {
			Query query = getSession().getNamedQuery("SubjectCourse.SelectSCById");
			if(lock)
				query.setLockMode("subject", LockMode.UPGRADE);
			query.setParameter("id", id);
			return query.list();
		} catch (RuntimeException re) {
			log.error("get subject by course_id failed", re);
			throw re;
		}
	}

	@Override
	public List<Subject> listSubjectNotInCourseById(Integer id, boolean lock) {
		log.debug("List subject not in course");
		try {
			Query query = getSession().getNamedQuery("SubjectCourse.SelectSCNotById");
			if(lock)
				query.setLockMode("subject", LockMode.UPGRADE);
			query.setParameter("id", id);
			return query.list();
		} catch (RuntimeException re) {
			log.error("get task by subject id failed", re);
			throw re;
		}
	}
	

}
