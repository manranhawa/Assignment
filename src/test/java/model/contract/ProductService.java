package model.contract;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

// Note: the generic type parameters P and C are used to represent the types of the product and category, respectively
public class ProductService{
	public Logger logger=LogManager.getLogger(this.getClass());

	/*
	 * Get all products of TestMart
	 * API endpoint to get data: https://dummyjson.com/products
	 */
	@Test
	public void getallproduct() {
		logger.debug("getting response");
		given()
		.when()
		.get("https://dummyjson.com/products")
       .then()
       .log().all();
	}

	

	/*
	 * Get a single product
	 * API endpoint to get data: https://dummyjson.com/products/{productId}
	 */
	@Test
	public void getsingleproduct() {
		logger.debug("getting response");
		given()
		.pathParam("productId", 1)
		
		.when()
		.get("https://dummyjson.com/products/{productId}")
       .then()
       .log().body();
	}
	
	@Test
	// Get all products of TestMart using parameters
	  // API endpoint to get data: https://dummyjson.com/products?limit={limit}&skip={skip}&select={comma separated fields of product}
	public void getproduct()
	{
		logger.debug("getting response");
		given()
		.queryParam("limit", 5)
		.queryParam("skip", 2)
		
		
		.when()
		.get("https://dummyjson.com/products")
       .then()
       .log().body();	
		logger.info("printing body");
	}

	
	
	//doing below one in a different way to show my knowledge
	
	
	
	@Test
	public void getproductbystring() {
		logger.debug("getting response");
		// Search for products in TestMart
		  // API endpoint to get data: https://dummyjson.com/products/search?q={query}
		RestAssured.baseURI = "https://dummyjson.com/products";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.queryParam("title","iphone 9").get();

		// Retrieve the body of the Response
		ResponseBody body = response.getBody();

		// By using the ResponseBody.asString() method, we can convert the  body
		// into the string representation.
		logger.info("printing body");
		System.out.println("Response Body is: " + body.asString());	
	}
	/*
	 * Get all products categories in TestMart
	 * API endpoint to get data: https://dummyjson.com/products/categories
	 */
	@Test
	public void getallproductcategory() {
		logger.debug("getting response");
		RestAssured.baseURI = "https://dummyjson.com/products/categories";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();

		// Retrieve the body of the Response
		ResponseBody body = response.getBody();

		// By using the ResponseBody.asString() method, we can convert the  body
		// into the string representation.
		logger.info("printing body");
		System.out.println("Response Body is: " + body.asString());
	}

	/*
	 * Get all products of a category
	 * API endpoint to get data: https://dummyjson.com/products/category/{categoryName}
	 */
	@Test
	public void getproductbycategory() {
		logger.debug("getting response");
		RestAssured.baseURI = "https://dummyjson.com/products";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.queryParam("category","smartphones").get();

		// Retrieve the body of the Response
		ResponseBody body = response.getBody();

		// By using the ResponseBody.asString() method, we can convert the  body
		// into the string representation.
		logger.info("printing body");
		System.out.println("Response Body is: " + body.asString());
}
}
