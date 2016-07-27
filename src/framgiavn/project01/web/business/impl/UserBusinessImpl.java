package framgiavn.project01.web.business.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.dao.*;
import framgiavn.project01.web.model.*;
import framgiavn.project01.web.ulti.Helpers;
import framgiavn.project01.web.ulti.Logit2;

public class UserBusinessImpl    implements UserBusiness {

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
	public User findById(Integer id, boolean lock) throws Exception {
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

	@Override
	public void addUser(User user) throws Exception {
		user.setCreateAt(new Date());
		user.setPassword(Helpers.encryptMd5(user.getPassword()));
		if(user.getStrSupervisor() != null)
			user.setSuppervisor(1);
		else
			user.setSuppervisor(0);
		
		userDAO.addUser(user);
	}

	@Override
	public void updateUser(User user) throws Exception {		
		try {			
			User userDB = userDAO.findById(user.getId(), true);			

			userDB.setId(user.getId());
			userDB.setName(user.getName());
			userDB.setEmail(user.getEmail());						
			userDB.setUpdateAt(new Date());
			userDB.setCreateAt(user.getCreateAt());
			
			if(user.getSuppervisor()!=null)				
				userDB.setSuppervisor(user.getSuppervisor());
			if(!user.getConfirmPass().equals(""))
				userDB.setPassword(Helpers.encryptMd5(user.getConfirmPass()));				
			else
				userDB.setPassword(Helpers.encryptMd5(user.getPassword()));
			
			userDAO.updateUser(userDB);
		} catch (Exception e) {
			throw e;
		}		
	}

	
	@Override
	public void deleteUser(Integer id) throws Exception {
		userDAO.deleteUser(id);		
	}

	@Override
	public List<User> listUser() {
		return userDAO.listUser();		
	}
}