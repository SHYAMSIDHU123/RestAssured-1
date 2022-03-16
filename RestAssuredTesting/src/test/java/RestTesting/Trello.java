package RestTesting;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Trello {
	public static String baseurl ="https://api.trello.com";
	public static String id;
	@Test (priority=0)
	public void createBoard()
	{
		RestAssured.baseURI = baseurl;
		Response response = given().queryParam("name","Sidhu Moolya board")
		.queryParam("key","aaa53c75077f6e490fb81497850c7e31")
		.queryParam("token","6ecdb211ca60fd5e4822922380b5ef252d5a14d7c5ff139de277a1d2238e8ab4")
		.header("Content-Type","application/json")
		
		.when()
		.post("/1/boards/")
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
		String jsonresponse = response.asString();
		JsonPath js = new JsonPath(jsonresponse);
		
		id=js.get("id");
		
	}
	@Test (priority=1)
	public void getBoard()
	{
		RestAssured.baseURI = baseurl;
		Response response = given().queryParam("name","Sidhu Moolya board")
		.queryParam("key","aaa53c75077f6e490fb81497850c7e31")
		.queryParam("token","6ecdb211ca60fd5e4822922380b5ef252d5a14d7c5ff139de277a1d2238e8ab4")
		.header("Content-Type","application/json")
		
		.when()
		.get("/1/boards/"+id)
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
		
		String jsonresponse = response.asString();
		System.out.println(jsonresponse);
		
	
		
	}
	@Test (priority=2)
	public void deleteBoard()
	{
		RestAssured.baseURI = baseurl;
		Response response = given().queryParam("name","Sidhu Moolya board")
		.queryParam("key","aaa53c75077f6e490fb81497850c7e31")
		.queryParam("token","6ecdb211ca60fd5e4822922380b5ef252d5a14d7c5ff139de277a1d2238e8ab4")
		.header("Content-Type","application/json")
		
		.when()
		.delete("/1/boards/"+id)
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
		
		String jsonresponse = response.asString();
		System.out.println(jsonresponse);
		
	
		
	}


}
