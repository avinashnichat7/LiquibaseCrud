package com.crud.serviceImpelementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.User;
import com.crud.exception.UserNotFoundException;
import com.crud.repository.UserRepository;
import com.crud.service.UserService;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long Id) {
		// TODO Auto-generated method stub
		return userRepository.findById(Id).orElseThrow(() -> new UserNotFoundException("User is not found " + Id));
	}

	@Override
	public User updateUser(Long id, User user) {
		// TODO Auto-generated method stub

		User existingUser = userRepository.findById(id).orElse(null);
		if (existingUser == null) {
			throw new UserNotFoundException("user with the " + id + " doesn't exist");
		} else {
			existingUser.setName(user.getName());
			existingUser.setPincode(user.getPincode());
			existingUser.setSalary(user.getSalary());

			return userRepository.save(existingUser);
		}

	}

	@Override
	public void deleteUser(Long id) {

		User existingUser=userRepository.findById(id).orElse(null);
		if(existingUser==null) {
			throw new 
			UserNotFoundException("user is not found with "+ id + " doesn't exist");
		}else {
			
			 userRepository.delete(existingUser);
		}

	}

}
