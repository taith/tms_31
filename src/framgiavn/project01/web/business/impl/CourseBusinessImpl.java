package framgiavn.project01.web.business.impl;

import framgiavn.project01.web.model.Course;
import framgiavn.project01.web.model.SubjectCourse;
import framgiavn.project01.web.dao.CourseDAO;

import java.util.List;

import framgiavn.project01.web.business.CourseBusiness;

public class CourseBusinessImpl implements CourseBusiness {

	private CourseDAO courseDAO;
	
	
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
		
	}

}
