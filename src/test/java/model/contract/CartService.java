package model.contract;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// Note: the generic type parameter T is used to represent the type of the cart.
 
@SuppressWarnings("unused")
public  class CartService{
	public Logger logger=LogManager.getLogger(this.getClass());
	/* Get all carts of TestMart
	 * API endpoint to get data: https://dummyjson.com/carts
	 */
	//@Test
	public void getallcarts() {
		logger.debug("getting response");
				given()
				.when()
				.get("https://dummyjson.com/carts")
		       .then()
		       .log().all();
	}
	/*
	 * Get a single cart
	 * API endpoint to get data: https://dummyjson.com/carts/{cartId}
	 */
	@Test
	public void getonecart() {
	
		
		logger.debug("getting response");
			given()
			.pathParam("cartId", 1)
			
			.when()
			.get("https://dummyjson.com/carts/{cartId}")
	       .then()
	       .log().body();
}
	

		
	/*
	 * Get carts of a user
	 * API endpoint to get data: https://dummyjson.com/carts/user/{userIds}
	 */
	//List<T> getUserCarts(Integer userId);

// @Test
 public void getusercart() {
	 logger.debug("getting response");
		given()
		.pathParam("userIds", 1)
		
		.when()
		.get("https://dummyjson.com/carts/user/{userIds}")
       .then()
       .log().body();

}
}
