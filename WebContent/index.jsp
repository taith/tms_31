<%@ taglib prefix="s" uri="/struts-tags"%>
<h3>Welcome to hoe page</h3>
<br><br>
<s:if test="#session.currentUser != null">	
	<a href="<s:url value="/courses/"/>">Show all course</a><br>
	<a href="<s:url value="/logout"/>">Logout</a>
</s:if>
<s:else>	
	<a href="<s:url value="/login"/>">Please login!</a>
</s:else>