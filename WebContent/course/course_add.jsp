<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="new-course-form">
	<h4>Add new course</h4>
	<br>
	<s:form action="/courses/create" >
		<div class="form-group">
			<input type="text" name="course.name" value="" id="addCourse_course_name" placeholder="Name" class="form-control">
		</div>
		<div class="form-group">
			<textarea name="course.detail" cols="50" rows="5" id="addCourse_course_detail" placeholder="Course detail" class="form-control"></textarea>
		</div>
		<div class="panel panel-info">
		  <div class="panel-heading">Choose Subject in Course</div>
		  <div class="panel-body">
		  <s:iterator value="subjectList">
	    	<div class="subject-info-add col-md-2">
				<s:property value="name" /><br>
				<input type="checkbox" name="course.listSubjectId" value="<s:property value="id" />" id="addSubjectCourse"/>
			</div>
		  </s:iterator>
		  </div>
		</div>
		<div class="panel panel-info">
		  <div class="panel-heading">Choose Course's Member</div>
		  <div class="panel-body">
		  <s:iterator value="userList">
	    	<div class="user-info-add col-md-2">
				<s:property value="name" /><br>
				<input type="checkbox" name="course.users.id" value="<s:property value="id" />" id="addUserCourse"/>
			</div>
		  </s:iterator>
		  </div>
		</div>
		<div class="form-group">
			<input type="submit" id="addCourse_0" value="Add" class="btn btn-default">
		</div>
	</s:form>
</div>