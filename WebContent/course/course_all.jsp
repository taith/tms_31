<%@ taglib prefix="s" uri="/struts-tags"%>

<h4>Framgia Training Course</h4>
<br>
<s:if test="#session.currentUser.suppervisor == 1">
	<a href="<s:url value="/courses/new"/>"><button type="button" class="btn btn-primary">Add Course</button></a>
	<br>
<br>

<s:if test="courseList.size()>0">
	<s:iterator value="courseList" status="courseStatus">
		<div class="panel panel-info">
		  <div class="panel-heading"><a href="<s:url value="/courses/detail"/><s:property value="id"/>"><s:property value="name" /></a></div>
		  <div class="panel-body">Detail :
		    <s:property value="detail" />
		  </div>
		</div>
	</s:iterator>
</s:if>
<s:else>
	<div class="alert alert-danger" role="alert">
	  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
	  <span class="sr-only">Error:</span>
  		Nothing in DB :(
	</div>
</s:else>
</s:if>
<s:else>
	<s:if test="user.getTakeCourses().size()>0">
		<s:iterator value="user.takeCourses">
		<div class="panel panel-info">
		  <div class="panel-heading"><a href="<s:url value="/courses/detail"/><s:property value="courseUser.id"/>"><s:property value="courseUser.name" /></a></div>
		  <div class="panel-body">Detail :
		    <s:property value="courseUser.detail" />
		  </div>
		</div>
	</s:iterator>
	</s:if>
	<s:else>
	<div class="alert alert-danger" role="alert">
	  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
	  <span class="sr-only">Error:</span>
  		Nothing course to learn :D
	</div>
	</s:else>
</s:else>

