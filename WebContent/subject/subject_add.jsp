<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="formtemp">
	<h3>Add new subject</h3>
	<s:form action="/subjects/create">
		<div class="form-group">
			<input type="text" name="subject.name" value=""
				id="addSubject_subject_name" placeholder="Subject Name"
				class="form-control">
		</div>
		<div class="form-group">
			<textarea name="subject.detail" cols="50" rows="5"
				id="addSubject_subject_detail" placeholder="Subject detail"
				class="form-control"></textarea>
		</div>

		<h4>Tasks</h4>
		<div id="tasks">
			<a id="addtask">Add task</a>
			<div style="display: none;">
				<div class="task-item">
					<div class="form-group">
						<input type="text" name="subject.listTaskName" placeholder="Task name"
							class="form-control">
					</div>
					<div class="form-group">
						<textarea name="subject.listTaskDetail" cols="50" rows="3"
							placeholder="Task detail" class="form-control"></textarea>
					</div>
				</div>
			</div>
		</div>


		<div class="form-group">
			<input type="submit" value="Add Subject" class="btn btn-default">
		</div>

	</s:form>
</div>