package de.mustermessenger.messengerJava.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.mustermessenger.messengerJava.Model.UserResponse;
import de.mustermessenger.messengerJava.Repository.UserRepository;

@RestController
public class UserController {
	private UserRepository userRepository;
	public UserController(UserRepository userRepository)
	{
		this.userRepository = userRepository; 
	}
	@GetMapping("/Users")
	public List<UserResponse> getUsers()
	{
		return userRepository.getUsers();
	}
	@GetMapping("/Users/{id}")
	public Optional<UserResponse> getUserById(@PathVariable("id")String id)
	{
		return userRepository.getUserById(id);
	}
	@PostMapping("Users/{vorName}&{name}")
	public boolean addUser(@PathVariable("vorName") String vorName, @PathVariable("name") String name)
	{
		return userRepository.addUser(vorName, name);
	}
	@DeleteMapping("/Users/{id}")
	public boolean deleteUser(@PathVariable("id") String id)
	{
		return userRepository.deleteUser(id);
	}
}
