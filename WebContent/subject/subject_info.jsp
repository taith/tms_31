<%@ taglib prefix="s" uri="/struts-tags"%>
<h2>
	Subject
	<s:property value="subject.name" />
	<br>
</h2>

<s:if test="#session.currentUser.suppervisor == 1">
<a href="<s:url value="/subjects/delete%{subject.id}" />">Delete</a>
<a href="<s:url value="/subjects/edit%{subject.id}"/>">Edit</a>
</s:if>
ID:
<s:property value="subject.id" />
<br>
Name:
<s:property value="subject.name" />
<br>
Detail:
<s:property value="subject.detail" />
<br>
<h3>Tasks:</h3>
<s:iterator value="subject.tasks">
	<a href="#">
		<button type="button" class="btn btn-info">
			<s:property value="name" />
		</button>
		<input type="checkbox"  />
	</a>
</s:iterator>
<br><br>