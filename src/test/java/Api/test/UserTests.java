package Api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


import Api.endpoints.UserEndPoints;
import Api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User userPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setupData()
	{
		faker = new Faker();
		userPayload=new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPhone(faker.phoneNumber().phoneNumber());
		
		//logs
		logger=LogManager.getLogger(this.getClass());
		
		
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		logger.info("********Creating user*******");
		Response response=UserEndPoints.CreateUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("********User is created*******");
	}
	
	
	@Test(priority=2)
	public void testGetUserByName()
	{
		
		logger.info("********Reading user Info*******");
		Response response=UserEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("********user info is displayed*******");
		
		
	}
	
	@Test(priority=3)
	public void testUpdateByName()
	
	{
		logger.info("********updating user*******");
		//update data using payload
		userPayload.setLastName(faker.name().lastName());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		
		Response response=UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().all();//rest assured assertion for validation
		
		Assert.assertEquals(response.getStatusCode(), 200);//testng assertion for validation
		
		logger.info("********user is updated *******");
		
		//checking data after update
		Response responseAfterupdate=UserEndPoints.readUser(this.userPayload.getUsername());
		Assert.assertEquals(responseAfterupdate.getStatusCode(), 200);
		
	}
	
	
	@Test(priority=4)
	public void testDeleteUserByName()
	{
		logger.info("********Deleting user*******");
		Response response=UserEndPoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("********user deleted*******");
	}

}
