<%@ taglib prefix="s" uri="/struts-tags"%>

<h3>Edit Course</h3>
<br>

<s:form action="/courses/update" >
	<input type="hidden" name="course.id" value="<s:property value="course.id"/>" id="update_Course_id">
	<div class="form-group">
		<input type="text" name="course.name" value="<s:property value="course.name"/>" id="addCourse_Course_name" placeholder="Name" class="form-control">
	</div>
	<div class="form-group">
		<textarea name="course.detail" cols="50" rows="5" id="addCourse_Course_detail" placeholder="Course detail" class="form-control"></textarea>
	</div>
	<div class="form-group">
		<input type="submit" id="addCourse_0" value="Update" class="btn btn-default">
	</div>
</s:form>