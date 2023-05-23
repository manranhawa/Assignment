package app;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.junit.Test;
import com.fasterxml.jackson.core.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; 


// Note: Convert this class to concrete class and add implementation (missing body) to all methods. You will remove the word
// `abstract` everywhere. This class is only kept `abstract` for the sake of interview exercise.
public  class AbstractTestMartAppFeatures {
	public Logger logger=LogManager.getLogger(this.getClass());

	/**
	 * Prints the titles of all products that have a rating less than or equal to the provided criteria.
	 * @param rating The rating threshold.
	 */
	@Test
	public  void getProductTitlesByWorseRating() {
		
		double Worserating=4.66;
		logger.debug("getting response");
		Response res = given()
	.contentType(ContentType.JSON)
	
	
	.when()
	
	.get("https://dummyjson.com/products");
		System.out.println(res.getStatusCode());
		
	
	JSONObject jo = new JSONObject(res.toString());
	
	for(int i = 0; i<jo.getJSONArray("products").length();i++)
	{
		double rating= (double) jo.getJSONArray("products").getJSONObject(i).get("rating");
		
		if(rating<=Worserating)
		{
			String title =jo.getJSONArray("products").getJSONObject(i).get("title").toString();
			System.out.println("title");
		}
		
	}
	
	
	
		
	}


	/**
	 * Returns the cart with the highest total value.
	 * @return 
	 * @returns The cart with the highest total value.
	 */
	
@Test
public  void getCartWithHighestTotal() {
	
	
	int HighestTotal=0;
	
Response res =given()
.contentType(ContentType.JSON)


.when()
.get("https://dummyjson.com/carts");
	System.out.println(res.getStatusCode());
	

JSONObject jo = new JSONObject(res.toString());

for(int i = 0; i<jo.getJSONArray("carts").length();i++)
{
	int totalprice= (int) jo.getJSONArray("carts").getJSONObject(i).get("discountedPrice");
	
	if(totalprice>HighestTotal)
	{
		totalprice=HighestTotal;
	}
	
}
System.out.println(HighestTotal);



	
}


	/**
	 * Returns the cart with the lowest total value.
	 * @returns The cart with the lowest total value.
	 */
@Test
	public  void getCartWithLowestTotal()
{
int LowestTotal=0;
	
	Response res = given()
.contentType(ContentType.JSON)


.when()
.get("https://dummyjson.com/carts");
	System.out.println(res.getStatusCode());
	

JSONObject jo = new JSONObject(res.toString());

for(int i = 0; i<jo.getJSONArray("products").length();i++)
{
	int totalprice= (int) jo.getJSONArray("products").getJSONObject(i).get("discountedPrice");
	
	if(totalprice<LowestTotal)
	{
		totalprice=LowestTotal;
	}
	
}
System.out.println(LowestTotal);



	
}



	/**
	 * Enriches the product information in a user's cart by adding product images.
	 * The current product information in a cart has limited fields.
	 * This method adds the `images` field for each product in a given user's cart.
	 * Note: This method only applies to the first element from the `carts[]` JSON response.
	 * @param userId The ID of the user whose cart's product information will be enriched.
	 * @return 
	 * @returns A list of products with enriched information in the user's cart.
	 */
@Test
	public  void addProductImagesToUserCart()
	{
	
		given()
		.pathParam("userIds", 1)
		
		.when()
		.get("https://dummyjson.com/user/{userIds}")
       .then()
       .log().body();
	}
	}
	
