package Api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;


import Api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndPoints.java
//created to perform CRUD operations-->create,read,update,delete requests the user API

public class UserEndPoints2 {
	
	//method created for getting URL'S from properties file
	
	static ResourceBundle getURL()//this will bring data from properties file
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");//load properties file
		return routes;
	}

	public static Response CreateUser(User payload)
	{
		String post_url=getURL().getString("post_url");//this line will return post url
		Response response=given()
		 .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
		 .body(payload)
		.when()
		 .post(post_url);
		
		return response;
		
	}
	
	public static Response readUser(String userName)
	{
		String get_url=getURL().getString("get_url");
		Response response=given()
		      .pathParam("username", userName)//path parameter
		.when()
		 .get(get_url);
		
		return response;
		
	}
	
	public static Response updateUser(String userName, User payload)
	{
		String update_url=getURL().getString("update_url");
		Response response=given()
		 .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
		 .pathParam("username", userName)
		 .body(payload)
		.when()
		 .put(update_url);
		
		return response;
		
	}
	

	public static Response deleteUser(String userName)
	{
		String delete_url=getURL().getString("delete_url");
		Response response=given()
		      .pathParam("username", userName)//path parameter
		.when()
		 .delete(delete_url);
		
		return response;
		
	}
	
}
