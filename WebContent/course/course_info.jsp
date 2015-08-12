<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="course col-md-8">
	<h2>Course <s:property value="course.name"/><br></h2>
	ID: <s:property value="course.id"/><br>
	Name: <s:property value="course.name"/><br>
	Detail: <s:property value="course.detail" /><br>
	<s:if test="#session.currentUser.suppervisor == 1">
		<a href="<s:url value="/courses/delete%{course.id}"/>">Delete</a>
		<a href="<s:url value="/courses/edit%{course.id}"/>">Edit</a>
	</s:if>
	<br><br>
	<h3>Subject in course:<br></h3>	
	<s:if test="course.getSubjectCourses().size()>0">
		<br>
		<s:iterator value="course.subjectCourses">
			<a href="<s:url value="/subjects/detail"/><s:property value="subjects.id"/>">
				<button type="button" class="btn btn-info"><s:property value="subjects.name"/></button></a>
					
		</s:iterator>
	</s:if>
	<s:else>
		<br><br>
		<div class="alert alert-info" role="alert">
		  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
		  <span class="sr-only">Error:</span>
	  		This Course hasn't subject! :D
		</div>
	</s:else>
</div>
<div class="user-course-info col-md-4">
	<div class="user-in-course col-md-12">
		<div class="panel panel-info">
			<div class="panel-heading">Course members</div>
			<div class="panel-body">
			<s:if test="course.getTakeCourses().size()>0">
			  	<s:iterator value="course.takeCourses">
			  		<div class="col-md-7">
		    			<a href="<s:url value="/users/detail"/><s:property value="users.id"/>"><s:property value="users.name"/></a>
		    		</div>
		    		<s:if test="#session.currentUser.suppervisor == 1">
		    		<div class="col-md-5" >
		    			<s:form action="/courses/remove_user">
						<input type="hidden" name="takeCourse.user_id" value="<s:property value="users.id"/>">
						<input type="hidden" name="takeCourse.course_id" value="<s:property value="course.id"/>">
						<input type="submit" value="Remove" class="btn btn-danger">
						</s:form>
		    		</div>
		    		</s:if>
		    		<br>
			  	</s:iterator>
			</s:if>
			<s:else>
				No member in <s:property value="course.name"/>
			</s:else>
		  	</div>
		</div>
	</div>
	<s:if test="#session.currentUser.suppervisor == 1">
	<div class="user-not-in-course col-md-12">
		<div class="panel panel-info">
			<div class="panel-heading">Members NOT IN Course</div>
			<div class="panel-body">
			<s:if test="userNotInCourseList.size()>0">
			  	<s:iterator value="userNotInCourseList">
		    		<div class="col-md-7">
		    			<a href="<s:url value="/users/detail"/><s:property value="id"/>"><s:property value="name"/></a>
		    		</div>
		    		<div class="col-md-5">
		    		<s:form action="/courses/add_user">
					<input type="hidden" name="takeCourse.user_id" value="<s:property value="id"/>">
					<input type="hidden" name="takeCourse.course_id" value="<s:property value="course.id"/>">
					<input type="submit" value="Add" class="btn btn-success">
					</s:form>
					</div>
		    		<br>
			  	</s:iterator>
			</s:if>
			<s:else>
				All member in course <s:property value="course.name"/>
			</s:else>
		  	</div>
		</div>
	</div>
	</s:if>
</div>
