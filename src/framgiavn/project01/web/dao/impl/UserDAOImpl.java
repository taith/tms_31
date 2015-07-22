package framgiavn.project01.web.dao.impl;

import java.util.List;

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
			//if (lock)
				//query.setLockMode("User", LockMode.UPGRADE);
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


	@Override
	public User findByEmail(String email) throws Exception {
		try {
			Query query = getSession().getNamedQuery("User.SelectByEmail");
			query.setParameter("email", email);
			return (User) query.uniqueResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public void addUser(User user) throws Exception {
		log.debug("Add user");
		try {			
			getHibernateTemplate().save(user);
		} catch (RuntimeException re) {
			log.error("Add user failed", re);
			throw re;
		}
	}

	@Override
	public void updateUser(User user) throws Exception {
		log.debug("Update user");
		try {
			getHibernateTemplate().update(user);
		} catch (RuntimeException re) {
			log.error("Update failed", re);
			throw re;
		}
	}

	@Override
	public void deleteUser(Integer id) throws Exception {
		try {
			Query query = getSession().getNamedQuery("User.DeleteById");
			query.setParameter("id", id);
			query.executeUpdate();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<User> listUser() {
		log.debug("List all users");
		try{
			Query query = getSession().getNamedQuery("User.SelectAll");
			return query.list();
		} catch (RuntimeException re) {
			log.error("List all users error!", re);
			throw re;
		}
	}
}