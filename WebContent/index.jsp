<%@ taglib prefix="s" uri="/struts-tags"%>
<a href="<s:url value="/user/findUserById"/>1">Show</a>
<a href="<s:url value="#"/>">Find by name</a>
<a href="<s:url value="/courses/"/>">Show all course</a>
<br><br>
<s:if test="#session.currentUser != null">	
	<a href="<s:url value="/logout"/>">Logout</a>
</s:if>
<s:else>	
	<a href="<s:url value="/login"/>">Please login!</a>
</s:else>