/*
 *  Course:     CS320 Software Test, Automation QA
 *  Assignment: Module 4 Milestone
 *  Instructor: Angelo Luo
 *  Student:    Travis Williamson
 *  Date: 		3/29/25
 *  
 *  The task object shall have a required unique task ID String that cannot be longer than 10 characters. The task ID shall not be null and shall not be updatable.
 *	The task object shall have a required name String field that cannot be longer than 20 characters. The name field shall not be null.
 *	The task object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.
 * 
 */
public class Task {

	private String taskId, taskName, taskDescription;
	
		public Task(String taskId, String taskName, String taskDescription) {
			//Values are only assigned if all are valid, otherwise this task is invalid and should not be usable / add-able to the task service
			if(validateTaskId(taskId) && validateTaskName(taskName) && validateTaskDescription(taskDescription)) {
				this.taskId = taskId;
				this.taskName = taskName;
				this.taskDescription = taskDescription;
			}
		}
		
		//accessors
		public String getTaskId() {
			return this.taskId;
		}
		
		public String getTaskName() {
			return this.taskName;
		}
		
		public String getTaskDescription() {
			return this.taskDescription;
		}
		
		//mutators, ensure that the updated name / description are valid prior to allowing the change.
		public void updateTaskName(String taskName) {
			if(validateTaskName(taskName)) {
				this.taskName = taskName;
			}
		}
		
		public void updateTaskDescription(String taskDescription) {
			if(validateTaskDescription(taskDescription)) {
				this.taskDescription = taskDescription;
			}
		}
		
		//Ensure that the description meets the requirements, it cannot be null or more than 50 characters.
		private boolean validateTaskDescription(String taskDescription) {
			if(taskDescription == null || taskDescription.length() > 50) {
				return false;
			}
			return true;
		}

		//Ensure that the name meets the requirements, it cannot be null or more than 20 characters.
		private boolean validateTaskName(String taskName) {
			if(taskName == null || taskName.length() > 20) {
				return false;
			}
			return true;
		}

		//Ensure that the task ID meets requirements, it cannot be null or more than 10 characters.
		private boolean validateTaskId(String taskId) {
			if(taskId == null || taskId.length() > 10) {
				return false;
			}
			return true;
		}
}
