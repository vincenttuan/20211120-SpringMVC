package springmvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import springmvc.entity.User;

@Service
public class UserService {
	private static List<User> users = new ArrayList<>();
	
	public boolean create(User user) {
		Optional<User> optUser = getByName(user.getName());
		if(!optUser.isPresent()) { 
			users.add(user);
		}
		return !optUser.isPresent();
	}
	
	public List<User> read() {
		return users;
	}
	
	public Optional<User> getByName(String name) {
		Optional<User> optUser = users.stream().filter(u -> u.equals(name)).findFirst();
		return optUser;
	}
	
	public boolean updateAgeByName(String name, Integer newAge) {
		Optional<User> optUser = getByName(name);
		if(optUser.isPresent()) {
			User user = optUser.get();
			user.setAge(newAge);
		}
		return optUser.isPresent();
	}
	
	public boolean deleteByName(String name) {
		Optional<User> optUser = getByName(name);
		if(optUser.isPresent()) {
			User user = optUser.get();
			users.remove(user);
		}
		return optUser.isPresent();
	}
}
