package model.contract;
import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class UserService {
	public Logger logger=LogManager.getLogger(this.getClass());

	/*
	 * Get all users of TestMart
	 * API endpoint to get data: https://dummyjson.com/users
	 */
	
	//@Test
	public void getalluser() {
		logger.debug("getting response");
		given()
		.when()
		.get("https://dummyjson.com/users")
       .then()
       .log().all();
	}

	/*
	 * Get a single user
	 * API endpoint to get data: https://dummyjson.com/users/{userId}
	 */
	//@Test
	public void getsingleuser() {
		logger.debug("getting response");
		given()
		.pathParam("userIds", 1)
		
		.when()
		.get("https://dummyjson.com/user/{userIds}")
       .then()
       .log().body();
	}

	/*
	 * Search users
	 * API endpoint to get data: https://dummyjson.com/users/search?q={query}
	 */
	@Test
	public void getuser() {
		logger.debug("getting response");

		given()
		.queryParam("username", "atuny0")
		
		.when()
		.get("https://dummyjson.com/user/search")
       .then()
       .log().body(); // no user present that is why returning nothing
	}
}
