<%@ taglib prefix="s" uri="/struts-tags"%>


<br>
<div class="formtemp">
<h3>Edit Subject</h3>
<s:form action="/subjects/update">
	<input type="hidden" name="subject.id"
		value="<s:property value="subject.id"/>" id="update_Subject_id">
	<div class="form-group">
		<input type="text" name="subject.name"
			value="<s:property value="subject.name"/>"
			id="addSubject_Subject_name" placeholder="Subject name"
			class="form-control">
	</div>
	<div class="form-group">
		<textarea name="subject.detail" cols="50" rows="2"
			id="addSubject_Subject_detail" placeholder="Subject detail"
			class="form-control"><s:property value="subject.detail"/></textarea>
	</div>
		
	<h4>Tasks</h4>	
		<div id="tasks">
			<a id="addtask">Add task</a>			
			<div style="display: none;">
				<div class="task-item">
					<input type="hidden" name="subject.listTaskID" />
					<div class="form-group">
						<input type="text" name="subject.listTaskName" placeholder="Task name"
							class="form-control">
					</div>
					<div class="form-group">
						<textarea name="subject.listTaskDetail" cols="50" rows="2"
							placeholder="Task detail" class="form-control"></textarea>
					</div>
					<input type="button" class="remove-parent" value="Remove" style="float: right;">
				</div>
			</div>			
			<s:iterator value="subject.tasks">
				<div class="task-item">
					<input type="hidden" name="subject.listTaskID" value="<s:property value="id"/>" />
					<div class="form-group">
						<input type="text" name="subject.listTaskName" value="<s:property value="name" />" class="form-control">						
					</div>
					<div class="form-group">
						<textarea name="subject.listTaskDetail"  cols="50" rows="3" class="form-control"><s:property value="detail" /></textarea>
					</div>					
						<input type="button" class="remove-parent" value="Remove" style="float: right;">											
				</div>							
			</s:iterator>			
		</div>	
	<div class="form-group">
		<input type="submit" id="addCourse_0" value="Update Subject"
			class="btn btn-default">
	</div>
</s:form>
</div>

<script type="text/javascript">
$(document).on('click', '.remove', function() {
    $(this).parent().remove();
});

</script>