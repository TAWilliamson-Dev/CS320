import java.util.HashMap;

public class TaskService {

	private HashMap<String, Task> taskService;
	
	public TaskService() {
		this.taskService = new HashMap<String, Task>(10);
	}
	
	public void addTask(String taskId, String taskName, String taskDescription) {
		if(!taskService.containsKey(taskId)) {
			Task task = new Task(taskId, taskName, taskDescription);
			
			if(task.getTaskId()== taskId) {
				taskService.put(taskId, task);
			}
			else {
				//Ensure invalid task is prepped for gc
				task = null;
			}
		}
	}
	
	public void deleteTask(String taskId) {
		if(taskService.containsKey(taskId)) {
			taskService.remove(taskId);
		}
	}
	
	public Task getTask(String taskId) {
		if(taskService.containsKey(taskId)) {
			return taskService.get(taskId); 
		}
		return null;
	}
	
	public void updateTaskName(String taskId, String taskName) {
		if(taskService.containsKey(taskId)) {
			taskService.get(taskId).updateTaskName(taskName);
		}
	}
	
	public void updateTaskDescription(String taskId, String taskDescription) {
		if(taskService.containsKey(taskId)) {
			taskService.get(taskId).updateTaskDescription(taskDescription);
		}
	}	
}
