<%@ taglib prefix="s" uri="/struts-tags"%>

<h3>Add new user</h3>
<br>
<s:form action="/users/create" >
	<div class="form-group">
		<input type="text" name="user.name" required value="" placeholder="Name" class="form-control">
	</div>
	<div class="form-group">
		<input type="text" name="user.email" required value="" placeholder="Email" class="form-control">
	</div>
	<div class="form-group">
		Is suppervisor?  <input type="checkbox" name="user.strSupervisor"  style="margin-left:5px;">				
	</div>
	<div class="form-group">
		<input type="password" name="user.password" required value="" placeholder="Password" class="form-control">
	</div>
	<div class="form-group">
		<input type="password" name="user.confirmPass" required value="" placeholder="Confirm password" class="form-control">
	</div>
	<div class="panel panel-primary">
		  <div class="panel-heading">Choose User Learn Courses</div>
		  <div class="panel-body">
		  <s:iterator value="courseList">
	    	<div class="subject-info-add col-md-2">
				<s:property value="name" /><br>
				<input type="checkbox" name="user.userCourses.id" value="<s:property value="id" />" id="addUserCourse"/>
			</div>
		  </s:iterator>
		  </div>
	</div>
	<div class="form-group">
		<input type="submit" value="Add" class="btn btn-default">
	</div>
</s:form>