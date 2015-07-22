package framgiavn.project01.web.business;

import java.util.List;

import framgiavn.project01.web.model.User;

public interface UserBusiness {	
	public User findById(Integer id) throws Exception;
	public User findById(Integer id, boolean lock) throws Exception;
	public User findByName(String name) throws Exception;
	public User login(String email, String pass) throws Exception;
	public void addUser(User user) throws Exception;
	public void updateUser(User user) throws Exception;	
	public void deleteUser(Integer id) throws Exception;
	public List<User> listUser();
}