package framgiavn.project01.web.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String email;	
	private Integer suppervisor;
	private String password;
	private Date  createAt;
	private Date updateAt;
	private String strSupervisor;	
	private String confirmPass;
	
	private List<Course> userCourses;
	private List<Integer> listid; 
	private List<TakeCourse> takeCourses;
	
	public List<Course> getUserCourses() {
		return userCourses;
	}
	public void setUserCourses(List<Course> userCourses) {
		this.userCourses = userCourses;
	}
	public List<TakeCourse> getTakeCourses() {
		return takeCourses;
	}
	public void setTakeCourses(List<TakeCourse> takeCourses) {
		this.takeCourses = takeCourses;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getSuppervisor() {
		return suppervisor;
	}
	public void setSuppervisor(Integer suppervisor) {
		this.suppervisor = suppervisor;
	}
	public String getPassword() {
		return password;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	public String getStrSupervisor() {
		return strSupervisor;
	}
	public void setStrSupervisor(String strSupervisor) {
		this.strSupervisor = strSupervisor;
	}
	public String getConfirmPass() {
		return confirmPass;
	}
	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Integer> getListid() {
		return listid;
	}
	public void setListid(List<Integer> listid) {
		this.listid = listid;
	}			
}