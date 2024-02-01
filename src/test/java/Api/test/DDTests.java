package Api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Api.endpoints.UserEndPoints;
import Api.payload.User;
import Api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostUser(String userID,String UserName,String FirstName,String LastName,String Email,String Password,String Phone)
	{
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(UserName);
		userPayload.setFirstName(FirstName);
		userPayload.setLastName(LastName);
		userPayload.setEmail(Email);
		userPayload.setPassword(Password);
		userPayload.setPhone(Phone);
		
		Response response=UserEndPoints.CreateUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String UserName)
	{
		Response response= UserEndPoints.deleteUser(UserName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
