package framgiavn.project01.web.dao.impl;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import framgiavn.project01.web.dao.SubjectCourseDAO;
import framgiavn.project01.web.model.SubjectCourse;
import framgiavn.project01.web.ulti.Logit2;

public class SubjectCourseDAOImpl extends HibernateDaoSupport implements SubjectCourseDAO {
	
	private static final Logit2 log = Logit2.getInstance(SubjectCourseDAO.class);
	
	protected void initDao() {
		// do nothing
	}

	@Override
	public void addSubjectToCourse(SubjectCourse subjectCourse) {
		log.debug("Add subject to course");
		try {
			getHibernateTemplate().saveOrUpdate(subjectCourse);
		} catch (RuntimeException re) {
			log.error("Add subject course failed", re);
			throw re;
		}
	}

	@Override
	public void removeSubjectFromCourse(Integer subject_id, Integer course_id) {
		log.debug("Remove subject from course");
		try {
			Query query = getSession().getNamedQuery("SubjectCourse.RemoveSubjectFromCourse");
			query.setParameter("subject_id", subject_id);
			query.setParameter("course_id", course_id);
			query.executeUpdate();
		} catch (RuntimeException re) {
			log.error("Remove failed");
			throw re;
		}
	}

}
