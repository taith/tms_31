<%@ taglib prefix="s" uri="/struts-tags"%>

<h3>Add new course</h3>
<br>
<s:form action="create" >
	<div class="form-group">
		<input type="text" name="course.name" value="" id="addCourse_course_name" placeholder="Name" class="form-control">
	</div>
	<div class="form-group">
		<textarea name="course.detail" cols="50" rows="5" id="addCourse_course_detail" placeholder="Course detail" class="form-control"></textarea>
	</div>
	<div class="form-group">
		<input type="submit" id="addCourse_0" value="Add" class="btn btn-default">
	</div>
</s:form>