<%@ taglib prefix="s" uri="/struts-tags"%>

<h3>Edit profile</h3>
<br>
<div style="font-size:14px; color:red;">
<s:if test="#session.update_success == 'false'">
	Update profile failed!<br>	
</s:if>
</div>
<br><br>
<s:form action="/users/update" >
	<input type="hidden" name="user.id" value="<s:property value="user.id"/>">
	<div class="form-group">
		<input type="text" required name="user.name" value="<s:property value="user.name"/>" class="form-control">
	</div>
	<div class="form-group">
		<input type="text" required name="user.email" value="<s:property value="user.email"/>" placeholder="Email" class="form-control">
	</div>
	<div class="form-group">
		<input type="password" required name="user.password" placeholder="Current password" class="form-control">
	</div>
	<div class="form-group">
		<input type="password" name="user.confirm_pass"  placeholder="New password (if no input for this field for keeping the old password)" class="form-control">
	</div>		
	<div class="form-group">
		<input type="submit"  value="Save" class="btn btn-default">
		<input type="reset" onclick="javascript:window.location='../users/detail<s:property value="user.id"/>';"  value="Cancel" class="btn btn-default">
	</div>
</s:form>