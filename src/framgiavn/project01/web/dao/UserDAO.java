package framgiavn.project01.web.dao;

import java.util.List;

import framgiavn.project01.web.model.User;

public interface UserDAO {
	public User findById(Integer id) throws Exception;
	public User findById(Integer id, boolean lock) throws Exception;
	public User findByName(String name) throws Exception;
	public User findByEmail(String email) throws Exception;
	public void addUser(User user) throws Exception;
	public void updateUser(User user) throws Exception;	
	public void deleteUser(Integer id) throws Exception;
	public List<User> listUser();
	public List<User> listUserNotInCourse(Integer id, boolean lock);
}