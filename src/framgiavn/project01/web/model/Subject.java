package framgiavn.project01.web.model;

import java.io.Serializable;

public class Subject implements Serializable {
	
	private Integer id;
	private String name;
	private String detail;
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Subject() {

	}
	
	

}
