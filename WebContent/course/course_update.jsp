<%@ taglib prefix="s" uri="/struts-tags"%>

<h3>Edit Course</h3>
<br>

<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingOne">
      <h5 class="panel-title">
        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
          Edit Course Detail
        </a>
      </h5>
    </div>
    <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
      <div class="panel-body"> 
		<s:form action="/courses/update">		
			<input type="hidden" name="course.id" value="<s:property value="course.id"/>">
			<div class="form-group">	
				<input type="text" name="course.name"
					value="<s:property value="course.name"/>" id="addCourse_Course_name"
					placeholder="Name" class="form-control">
			</div>
			<div class="form-group">
				<textarea name="course.detail" placeholder="Course detail"
					class="form-control"><s:property value="course.detail" /></textarea>
			</div>
			<div class="form-group">
				<input type="submit" id="addCourse_0" value="Save" class="btn btn-default">
			</div>
		</s:form>
	   </div>
	 </div>
	</div>
	<div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingTwo">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          Edit Subject in Course
        </a>
      </h4>
    </div>
    <div id="collapseTwo" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingTwo">
      <div class="panel-body">
      	<div class="subject-in-course col-md-6">
      		<div class="panel panel-default">
  			<div class="panel-heading">
    			<h3 class="panel-title">Subject in Course</h3>
  			</div>
 			<div class="panel-body">
    		<s:if test="subjectInCourse.size()>0">
				<br>
				<s:iterator value="subjectInCourse">
				<div class="subject-info col-md-4">
					<a href="<s:url value="/subjects/detail"/><s:property value="id"/>">
					<s:property value="name"/></a><br>
					<s:form action="/courses/remove_subject"><br>
					<input type="hidden" name="subjectCourse.subject_id" value="<s:property value="id"/>">
					<input type="hidden" name="subjectCourse.course_id" value="<s:property value="course.id"/>">
					<input type="submit" value="Remove" class="btn btn-danger">
					</s:form>
				</div>
				</s:iterator>
			</s:if>
			<s:else>
			<br>
			<div class="alert alert-info" role="alert">
			  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			  <span class="sr-only">Error:</span>
		  		No subject in <s:property value="course.name"/>! :D
			</div>
			</s:else>
  			</div>
			</div>
      	</div>
      	<div class="subject-not-in-course col-md-6">
      	<div class="panel panel-default">
  			<div class="panel-heading">
    			<h3 class="panel-title">Subject NOT IN Course</h3>
  			</div>
 			<div class="panel-body">
    			<s:if test="subjectNotInCourse.size()>0">
				<br>
				<s:iterator value="subjectNotInCourse">
					<div class="subject-info col-md-4">
					<a href="<s:url value="/subjects/detail"/><s:property value="id"/>">
					<s:property value="name"/></a><br><br>
					<s:form action="/courses/add_subject">
					<input type="hidden" name="subjectCourse.subject_id" value="<s:property value="id"/>">
					<input type="hidden" name="subjectCourse.course_id" value="<s:property value="course.id"/>">
					<input type="submit" value="Add" class="btn btn-success">
					</s:form>
				</div>	
				</s:iterator>
			</s:if>
			<s:else>
			<br>
			<div class="alert alert-info" role="alert">
			  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			  <span class="sr-only">Error:</span>
		  		This Course hasn't subject! :D
			</div>
			</s:else>
  			</div>
		</div>
      	</div>
      </div>
    </div>
</div>