package Api.endpoints;

import static io.restassured.RestAssured.given;

import javax.mail.Store;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class StoreEndPoints {
	
	public static Response Createstore(Store Payload)
	{
		Response responses=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(Payload)
			.when()
			.post(Routes.posts_url);
		
		return responses;
	}
	
	public static Response readsStore(String orderName)
	{
		Response responses=given()
				.pathParam("ordername", orderName)
				.when()
				.get(Routes.gets_url);
		
		return responses;
	}
	
	public static Response updatesStore(String orderName,Store payload)
	{
		Response responses=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("orderName", orderName)
				.body(payload)
			.when()
			.put(Routes.updates_url);
		
		return responses;
	}
	
	public static Response deletesStore(String orderName)
	{
		Response responses=given()
				.pathParam("orderName", orderName)
				.when()
				.delete(Routes.deletes_url);
		
		return responses;
	}

	public static Response Createstore(Api.payload.Store storePayload) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	}




