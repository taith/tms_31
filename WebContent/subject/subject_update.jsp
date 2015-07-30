<%@ taglib prefix="s" uri="/struts-tags"%>

<h3>Edit Subject</h3>
<br>

<s:form action="/subjects/update" >
	<input type="hidden" name="subject.id" value="<s:property value="subject.id"/>" id="update_Subject_id">
	<div class="form-group">
		<input type="text" name="subject.name" value="<s:property value="subject.name"/>" id="addSubject_Subject_name" placeholder="Subject name" class="form-control">
	</div>
	<div class="form-group">
		<textarea name="subject.detail" cols="50" rows="5" id="addSubject_Subject_detail" placeholder="Subject detail" class="form-control"></textarea>
	</div>
	<div class="form-group">
		<input type="submit" id="addCourse_0" value="Update" class="btn btn-default">
	</div>
</s:form>