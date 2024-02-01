package Api.endpoints;

import static io.restassured.RestAssured.given;

import Api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndPoints.java
//created to perform CRUD operations-->create,read,update,delete requests the user API

public class UserEndPoints {

	public static Response CreateUser(User payload)
	{
		Response response=given()
		 .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
		 .body(payload)
		.when()
		 .post(Routes.post_url);
		
		return response;
		
	}
	
	public static Response readUser(String userName)
	{
		Response response=given()
		      .pathParam("username", userName)//path parameter
		.when()
		 .get(Routes.get_url);
		
		return response;
		
	}
	
	public static Response updateUser(String userName, User payload)
	{
		Response response=given()
		 .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
		 .pathParam("username", userName)
		 .body(payload)
		.when()
		 .put(Routes.update_url);
		
		return response;
		
	}
	

	public static Response deleteUser(String userName)
	{
		Response response=given()
		      .pathParam("username", userName)//path parameter
		.when()
		 .delete(Routes.delete_url);
		
		return response;
		
	}
	
}
