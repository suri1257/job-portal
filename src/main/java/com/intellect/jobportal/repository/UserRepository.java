package com.intellect.jobportal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.intellect.jobportal.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}
