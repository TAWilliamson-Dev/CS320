import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskTest {

	//Test task successfully created
	@Test
	void testTaskCreated() {
		Task task1 = new Task("123", "Deploy your MCV", "WIP");
		
		assertEquals("123",task1.getTaskId());
		assertEquals("Deploy your MCV", task1.getTaskName());
		assertEquals("WIP", task1.getTaskDescription());
	}
	
	//Test task unsuccessfully created if taskId is null
	@Test
	void testTaskIdNull() {
		Task task2 = new Task(null,"123","ABC");
		
		assertNull(task2.getTaskName());
		assertNull(task2.getTaskDescription());
	}
	
	//Test task unsuccessfully created if taskId is too long
	@Test
	void testTaskIdTooLong() {
		Task task2 = new Task("12345678901","ABC","123");
		
		assertNull(task2.getTaskId());
	}
	
	//Test task unsuccessfully created if taskName is null
	@Test
	void testTaskNameNull() {
		Task task3 = new Task("123",null,"ABC");
		
		assertNull(task3.getTaskId());
	}
	
	//Test task unsuccessfully created if taskName is too long
	@Test
	void testTaskNameTooLong() {
		Task task4 = new Task("123", "ABCDEFGHIJKLMNOPQRSTUVWXYZ","ABC");
		
		assertNull(task4.getTaskId());
	}
	
	//Test task unsuccessfully created if taskDescription is null
	@Test
	void testTaskDescriptionNull() {
		Task task5 = new Task("123", "ABC", null);
		
		assertNull(task5.getTaskId());
	}
	
	//Test task unsuccessfully created if taskDescription is too long, i.e. 51 characters or more
	@Test
	void testTaskDescriptionTooLong() {
		Task task6 = new Task("123", "ABC", "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ");
		
		assertNull(task6.getTaskId());
	}

}
