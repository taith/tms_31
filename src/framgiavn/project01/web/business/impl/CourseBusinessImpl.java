package framgiavn.project01.web.business.impl;

import framgiavn.project01.web.model.*;
import framgiavn.project01.web.dao.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import framgiavn.project01.web.business.CourseBusiness;

public class CourseBusinessImpl implements CourseBusiness {

	private CourseDAO courseDAO;
	private UserDAO userDAO;
	private SubjectDAO subjectDAO;
	private SubjectCourseDAO subjectCourseDAO;
	private TakeCourseDAO takeCourseDAO;
	
	public TakeCourseDAO getTakeCourseDAO() {
		return takeCourseDAO;
	}

	public void setTakeCourseDAO(TakeCourseDAO takeCourseDAO) {
		this.takeCourseDAO = takeCourseDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public SubjectCourseDAO getSubjectCourseDAO() {
		return subjectCourseDAO;
	}

	public void setSubjectCourseDAO(SubjectCourseDAO subjectCourseDAO) {
		this.subjectCourseDAO = subjectCourseDAO;
	}

	public SubjectDAO getSubjectDAO() {
		return subjectDAO;
	}

	public void setSubjectDAO(SubjectDAO subjectDAO) {
		this.subjectDAO = subjectDAO;
	}

	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@Override
	public List<Course> listCourse() {
		return courseDAO.listCourse();
	}

	@Override
	public Course findById(Integer id) throws Exception {
		try{
			return getCourseDAO().findById(id, false);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void updateCourse(Course course) throws Exception {
		try {
			Course courseDB = courseDAO.findById(course.getId(), true);
			courseDB.setId(course.getId());
			courseDB.setName(course.getName());
			courseDB.setDetail(course.getDetail());
			courseDB.setStartDate(course.getStartDate());
			courseDB.setEndDate(course.getEndDate());
			
			courseDAO.updateCourse(courseDB);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteCourse(Integer id) {
		courseDAO.deleteCourse(id);
	}

	@Override
	public void addCourse(Course course) {

		courseDAO.addCourse(course);
		Iterator<Integer> subjectId = course.getListSubjectId().iterator();
		while(subjectId.hasNext()){
			SubjectCourse subjectCourse = new SubjectCourse();
			subjectCourse.setSubject_id(subjectId.next());
			subjectCourse.setCourse_id(course.getId());
			subjectCourseDAO.addSubjectToCourse(subjectCourse);
		}
		List<User> users;
		users = course.getUsers();
		for(User userCourses : users) {
			TakeCourse takeCourse = new TakeCourse();
			takeCourse.setUser_id(userCourses.getId());
			takeCourse.setCourse_id(course.getId());
			takeCourse.setFinished(0);
			takeCourse.setCreateAt(new Date());
			takeCourse.setUpdateAt(new Date());
			
			takeCourseDAO.addUserToSubject(takeCourse);
		}
	}

	@Override
	public List<Subject> listSubjectInCourse() {
		return subjectDAO.listSubject();
	}

	@Override
	public void addSubjectCourse(SubjectCourse subjectCourse) {
		subjectCourseDAO.addSubjectToCourse(subjectCourse);
	}

	@Override
	public void removeSubjectCourse(Integer subject_id, Integer course_id) {
		subjectCourseDAO.removeSubjectFromCourse(subject_id, course_id);
	}

	@Override
	public User findUserById(Integer id) throws Exception {
		try{
			return getUserDAO().findById(id, false);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<User> listUserNotInCourse(Integer id) {
		return getUserDAO().listUserNotInCourse(id, false);
	}

	@Override
	public void addUserCourse(TakeCourse takeCourse) {
		takeCourse.setFinished(0);
		takeCourse.setCreateAt(new Date());
		takeCourse.setUpdateAt(new Date());
		takeCourseDAO.addUserToSubject(takeCourse);
	}

	@Override
	public void removeUserCourse(Integer user_id, Integer course_id) {
		takeCourseDAO.removeUserFromCourse(user_id, course_id);
	}


}
