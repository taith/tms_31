<%@ taglib prefix="s" uri="/struts-tags"%>

<h4>Framgia Training Subjects</h4>
<br>

<s:if test="#session.currentUser.suppervisor == 1">
	<a href="<s:url value="/subjects/new"/>"><button type="button"
			class="btn btn-primary">Add Subject</button></a>
</s:if>
<br>
<br>

<s:iterator value="subjectList">
	<div class="panel panel-info">
		<div class="panel-heading">
			<a href="<s:url value="/subjects/detail"/><s:property value="id"/>"><s:property
					value="name" /></a>
		</div>
		<div class="panel-body">
			Detail :
			<s:property value="detail" />
		</div>
	</div>
</s:iterator>