<%@ taglib prefix="s" uri="/struts-tags"%>

<h4>All Users</h4>
<br>

<s:if test="#session.currentUser.suppervisor == 1">
	<a href="<s:url value="/users/new"/>"><button type="button"
			class="btn btn-primary">Add User</button> </a>
</s:if>

<br>

<br>

<s:iterator value="userList">
	<div class="panel panel-info">
		<div class="panel-heading">
			<a href="<s:url value="/users/detail"/><s:property value="id"/>"><s:property
					value="name" /></a>
					<s:if test="#session.currentUser.suppervisor == 1">
					<a href="<s:url value="/users/edit%{id}"/>">Edit</a>
					<a href="<s:url value="/users/delete%{id}"/>">Delete</a>
					</s:if>
		</div>
		
		
	</div>
</s:iterator>
