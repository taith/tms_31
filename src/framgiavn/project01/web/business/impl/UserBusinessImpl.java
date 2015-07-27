package framgiavn.project01.web.business.impl;

import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.dao.UserDAO;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.ulti.Helpers;

public class UserBusinessImpl implements UserBusiness {

	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User findById(Integer id) throws Exception {
		try {
			return getUserDAO().findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public User findByName(String name) throws Exception {
		try {
			return getUserDAO().findByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public User login(String email, String pass) throws Exception {
		if (pass.equals("") || email.equals("")) {			
			return null;
		}		
		User user = getUserDAO().findByEmail(email);
	
		if (user != null && user.getPassword().equals(Helpers.encryptMd5(pass))) {										
			return user;
		}
		return null;
	}

}