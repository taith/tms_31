package framgiavn.project01.web.dao.impl;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import framgiavn.project01.web.dao.UserDAO;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.ulti.Logit2;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	private static final Logit2 log = Logit2.getInstance(UserDAOImpl.class);
	public static final String NAME = "customerName";

	protected void initDAO() {
		// Do nothing
	}

	@Override
	public User findById(Integer id) throws Exception {
		return findById(id, false);
	}

	public User findById(Integer id, boolean lock) throws Exception {
		try {
			Query query = getSession().getNamedQuery("User.SelectUserById");
			if (lock)
				query.setLockMode("User", LockMode.UPGRADE);
			query.setParameter("id", id);
			return (User) query.uniqueResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public User findByname(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByName(String username) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}