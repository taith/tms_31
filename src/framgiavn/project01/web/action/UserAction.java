package framgiavn.project01.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import framgiavn.project01.web.business.*;
import framgiavn.project01.web.model.*;
import framgiavn.project01.web.ulti.Helpers;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserBusiness userBusiness = null;
	CourseBusiness courseBusiness;
	private User user = null;
	Course course;
	private Map<String, Object> session;
	public List<User> userList = new ArrayList<User>();
	public List<Course> courseList = new ArrayList<Course>();
	
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public void setCourseBusiness(CourseBusiness courseBusiness) {
		this.courseBusiness = courseBusiness;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
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

	public String login() {
		return SUCCESS;
	}

	public String dologin() throws Exception {
		String input_email = user.getEmail();
		String input_pass = user.getPassword();
		user = userBusiness.login(input_email, input_pass);

		if (user == null) {
			session = ActionContext.getContext().getSession();			
			return ERROR;
		} else {
			session = ActionContext.getContext().getSession();
			session.put("currentUser", user);						
			session.put("context", (new Date()).toString());			
			return SUCCESS;
		}
	}

	public String logout() {
		user = null;
		session = ActionContext.getContext().getSession();
		session.remove("currentUser");
		session.remove("update_success");						
		session.remove("context");				
		return SUCCESS;
	}
	public String showUser() {
		try {
			user = userBusiness.findById(user.getId(), false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String viewAll() {
		userList = userBusiness.listUser();
		return SUCCESS;
	}
	public String create(){			
		try {			
			if(user.getPassword().equals(user.getConfirmPass())){				
				userBusiness.addUser(user);
				userList = userBusiness.listUser();
			}			
		}catch (Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}


	public String editUserPage() {
		try {
			user = userBusiness.findById(user.getId(), false);
			session = ActionContext.getContext().getSession();
			session.remove("update_success");			
			if (session.get("currentUser") == null) {
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String updateUser() throws Exception {
		User userDB = userBusiness.findById(user.getId(), false);		

		if (!Helpers.encryptMd5(user.getPassword()).equals(userDB.getPassword())){
			session = ActionContext.getContext().getSession();
			session.put("update_success", "false");
			return ERROR;
		} else{
			userBusiness.updateUser(user);
			session = ActionContext.getContext().getSession();			
			session.put("currentUser", user);
			user = userBusiness.findById(user.getId(), false);
			return SUCCESS;
		}
	}

	public String destroyUser() {
		try {
			userBusiness.deleteUser(user.getId());
			userList = userBusiness.listUser();
		} catch (Exception e) {
			e.printStackTrace();
		}						
		return SUCCESS;
	}
	
	public String addUserPage() {
		courseList = courseBusiness.listCourse();
		
		return SUCCESS;
	}
}