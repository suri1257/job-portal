package com.intellect.jobportal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;


@Configuration
@EnableMongoRepositories(basePackages = "com.intellect.jobportal.repository")
public class MongoConfig extends AbstractMongoConfiguration{
	private static final String DB_NAME = "jobportal_db";
/*	@Override
	public MongoClient mongo {
	 System.out.println("2. call mongoClient method=========");
		return new MongoClient("127.0.0.1", 27017);
	}
*/
	@Override
	protected String getDatabaseName() {
		System.out.println("1. call getDatabaseName method=========");
		return DB_NAME;
	}

	@Override
	public Mongo mongo() throws Exception {
		// TODO Auto-generated method stub
		return new Mongo("127.0.0.1", 27017);
	}
	

}
