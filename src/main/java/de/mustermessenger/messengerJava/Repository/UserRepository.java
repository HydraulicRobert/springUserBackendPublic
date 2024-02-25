package de.mustermessenger.messengerJava.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import de.mustermessenger.messengerJava.Model.UserResponse;

@Service
public class UserRepository {
	private List<UserResponse> Users = new ArrayList<>(Arrays.asList(new UserResponse("hans","joachim","1"),new UserResponse("Paul","Peter","2")));
	public List<UserResponse> getUsers()
	{
		return Users;
	}
	public Optional<UserResponse> getUserById(String id)
	{
		return Users.stream().filter(e->e.getId().equals(id)).findFirst();
	}
	public boolean addUser(
			String vorName,
			String name)
	{
		Users.add(new UserResponse(vorName, name, "3"));
		return true;
	}
	public boolean deleteUser(String id)
	{
		Users = Users.stream().filter(e->!e.getId().equals(id)).collect(Collectors.toList());
		return true;
	}
	
}
