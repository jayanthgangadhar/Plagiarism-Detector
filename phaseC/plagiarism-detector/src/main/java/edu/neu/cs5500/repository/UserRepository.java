package edu.neu.cs5500.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.neu.cs5500.domainObjects.User;

public interface UserRepository extends MongoRepository<User, String>{

	public User findByFirstName(String firstName);
	public User findByEmailAddress(String email);
	public User findByEmailAddressAndPassword(String email, String password);
	public User findById(String id);
}
