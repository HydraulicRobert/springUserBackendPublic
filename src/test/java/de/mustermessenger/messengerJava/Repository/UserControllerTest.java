package de.mustermessenger.messengerJava.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import de.mustermessenger.messengerJava.Model.UserResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	@Mock
	private UserRepository testUserRepository;
	
	@BeforeEach
	public void setUp()
	{
		//given
		testUserRepository = mock(UserRepository.class, RETURNS_SMART_NULLS);
	}
	
	@Test
	public void testAddUser()
	{
		testUserRepository.addUser("Test", "test");
	}
	@Test
	public void testGetEmptyUserList()
	{
		
		//when
		List<UserResponse> userList = new ArrayList<>();
		when(testUserRepository.getUsers()).thenReturn(userList);
		//then
		assertEquals(testUserRepository.getUsers(), userList);
	}
	@Test
	public void testGetUserById()
	{
		Optional<UserResponse> User = Optional.ofNullable(new UserResponse("Test","test","2"));
		when(testUserRepository.getUserById(any(String.class))).thenReturn(User);
		assertEquals(User,testUserRepository.getUserById("2"));
	}
	@Test
	public void testDeleteUser()
	{
		when(testUserRepository.getUserById("2")).thenReturn(null);
		testUserRepository.deleteUser("2");
		assertEquals(testUserRepository.getUserById("2"), null);
	}
}
