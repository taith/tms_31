<%@ taglib prefix="s" uri="/struts-tags"%>

<h3>Add new subject</h3>
<br>
<s:form action="/subjects/create" >
	<div class="form-group">
		<input type="text" name="subject.name" value="" id="addSubject_subject_name" placeholder="Subject Name" class="form-control">
	</div>
	<div class="form-group">
		<textarea name="subject.detail" cols="50" rows="5" id="addSubject_subject_detail" placeholder="Subject detail" class="form-control"></textarea>
	</div>
	<div class="form-group">
		<input type="submit" id="addCourse_0" value="Add" class="btn btn-default">
	</div>
</s:form>