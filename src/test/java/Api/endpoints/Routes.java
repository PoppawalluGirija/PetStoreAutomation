package Api.endpoints;

public class Routes {
	
	public static String base_url="https://petstore.swagger.io/v2";//if we put static we can access just by class name no need of creating object
	//user Module
	
	public static String post_url=base_url+"/user";//create new user
	public static String get_url=base_url+"/user/{username}";//gives the path of particular candidate
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	//Store Module
	  //here u will create store module url's
	public static String posts_url=base_url+"/store";//create new user
	public static String gets_url=base_url+"/store/{ordername}";//gives the path of particular candidate
	public static String updates_url=base_url+"/store/{ordername}";
	public static String deletes_url=base_url+"/store/{ordername}";
	
	
	//Pet module
	   
	    //here u will create pet module url's
	
	
}
