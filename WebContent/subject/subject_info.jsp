<%@ taglib prefix="s" uri="/struts-tags"%>

<h2>Subject <s:property value="subject.name"/><br></h2>
ID: <s:property value="subject.id"/><br>
Name: <s:property value="subject.name"/><br>
Detail: <s:property value="subject.detail" /><br>
<form></form>
<a href="<s:url value="/subjects/delete%{subject.id}"/>">Delete</a>
<a href="<s:url value="/subjects/edit%{subject.id}"/>">Edit</a>