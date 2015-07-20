package framgiavn.project01.web.action;

import com.opensymphony.xwork2.ActionSupport;

import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.model.User;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private Logit2 log = Logit2.getInstance(UserAction.class);

	private UserBusiness userBusiness = null;
	private User user = null;

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String findUserById() {
		try {
			user = userBusiness.findById(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String findUserByName() {
		try {
			user = userBusiness.findByName(user.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String homePage() {
			
		return SUCCESS;
	}

}