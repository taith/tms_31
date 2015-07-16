package framgiavn.project01.web.business;

import framgiavn.project01.web.model.User;

public interface UserBusiness {
	public User findById(Integer id) throws Exception;

	public User findByName(String name) throws Exception;
}