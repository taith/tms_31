<%@ taglib prefix="s" uri="/struts-tags"%>

<h2>Course <s:property value="course.name"/><br></h2>
ID: <s:property value="course.id"/><br>
Name: <s:property value="course.name"/><br>
Detail: <s:property value="course.detail" /><br>
<form></form>
<a href="<s:url value="/courses/delete%{course.id}"/>">Delete</a>
<a href="<s:url value="/courses/edit%{course.id}"/>">Edit</a>