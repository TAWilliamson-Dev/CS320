import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskServiceTest {

	protected TaskService service = new TaskService();
	
	//Test that a task is correctly created
	@Test
	void testAddUniqueID() {
		service.addTask("ABC", "123", "0451");
		
		assertEquals("123",service.getTask("ABC").getTaskName());
	}
	
	//Test that colliding entries are prohibited and IDs remain unique
	@Test
	void testAddNonUniqueID() {
		service.addTask("ABC", "123", "0451");
		service.addTask("ABC", "456", "411");
		
		assertEquals("123",service.getTask("ABC").getTaskName());
	}
	
	//Test that the task is not created / added to the task service if the task is invalid
	@Test
	void testAddInvalidTask() {
		service.addTask("12345678900", "123", "123");
		
		assertNull(service.getTask("12345678900"));
		
	}
	
	//Test that the task is correctly deleted from the task service
	@Test
	void testDeleteUniqueID() {
		service.addTask("ABC", "123", "0451");
		
		assertEquals("123",service.getTask("ABC").getTaskName());
		
		service.deleteTask("ABC");
		
		assertNull(service.getTask("ABC"));
	}
	
	//Test that a task is added correctly to a previously deleted ID
	@Test
	void testAddUserPostDeleteUniqueID() {
		service.addTask("ABC", "123", "0451");
		
		assertEquals("123",service.getTask("ABC").getTaskName());
		
		service.deleteTask("ABC");
		
		assertNull(service.getTask("ABC"));
		
		service.addTask("ABC", "456", "UNATCO HQ");
		
		assertEquals("456",service.getTask("ABC").getTaskName());
	}
	
	//Test to ensure that the name is updated if the new name meets the requirements, not null and 20 characters or less
	@Test
	void testUpdateNameGood() {
		service.addTask("ABC", "JC", "Denton");
		
		assertEquals("JC",service.getTask("ABC").getTaskName());
		
		service.updateTaskName("ABC", "Paul");
		
		assertEquals("Paul",service.getTask("ABC").getTaskName());
	}
	
	//Test to ensure that the name is not updated if the new name is null
	@Test
	void testUpdateNameNull() {
		service.addTask("ABC", "JC", "Denton");
		
		assertEquals("JC",service.getTask("ABC").getTaskName());
		
		service.updateTaskName("ABC", null);
		
		assertEquals("JC",service.getTask("ABC").getTaskName());		
	}
	
	//Test to ensure that the name is not updated if the new name is too long
	@Test 
	void testUpdateNameTooLong() {
		service.addTask("ABC", "JC", "Denton");
		
		assertEquals("JC",service.getTask("ABC").getTaskName());
		
		service.updateTaskName("ABC", "JC, Paul, and Alex Denton walk into a bar. The bartender debates meta politics with them. No joke, I swear.");
		
		assertEquals("JC",service.getTask("ABC").getTaskName());	
	}
	
	//Test to ensure that the description is updated if it is valid
	@Test
	void testUpdateDescriptionGood() {
		service.addTask("ABC", "JC", "Denton");
		
		assertEquals("Denton",service.getTask("ABC").getTaskDescription());
		
		service.updateTaskDescription("ABC", "JC, Paul, and Alex Denton walk into a bar.");
		
		assertEquals("JC, Paul, and Alex Denton walk into a bar.",service.getTask("ABC").getTaskDescription());	
	}
	
	//Test to ensure the description is not updated if the new description is null
	@Test
	void testUpdateDescriptionNull() {
		service.addTask("ABC", "JC", "Denton");
		
		assertEquals("Denton",service.getTask("ABC").getTaskDescription());
		
		service.updateTaskDescription("ABC", null);
		
		assertEquals("Denton",service.getTask("ABC").getTaskDescription());	
	}
	
	//Test that the description is not updated if the new description is longer than 50 characters
	@Test
	void testUpdateDescriptionTooLong() {
		service.addTask("ABC", "JC", "Denton");
		
		assertEquals("Denton",service.getTask("ABC").getTaskDescription());
		
		service.updateTaskDescription("ABC", "JC, Paul, and Alex Denton walk into a bar. The bartender debates meta politics with them. No joke, I swear.");
		
		assertEquals("Denton",service.getTask("ABC").getTaskDescription());			
	}

}
