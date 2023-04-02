package almosafer.almosafer;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;



 public class almosafer { 
	 static POST_DATA data = new POST_DATA();
	 static GET_DATA data1 = new GET_DATA();
	 ExtentHtmlReporter htmlReporter;
		ExtentReports extent;
		ExtentTest test;
		String URL="https://www.almosafer.com";
	    
	 @BeforeTest
	 void setup() {
		
		 htmlReporter = new ExtentHtmlReporter("almosaferreport.html");
		 extent = new ExtentReports();
		 extent.attachReporter(htmlReporter);
	 }
	@Test
	void GET() {
		
		test = extent.createTest("Get API", "Start Get API ");
        Response response = RestAssured.given()
        		.header("token",data1.gettokene())
        		.param("placeId", data1.getplaceId())
        		.param("pageSize", data1.getpagesize())
        		
        		.get(URL+data1.getUri()); 
		
        int statusCode = response.getStatusCode();
        test.log(Status.INFO, "This step to log the status code ="+statusCode);
       try { assertEquals(statusCode, 200); 
       
       } catch (AssertionError e) {
    	  test.fail("Status code is not 200");
    	  
          
          throw new RuntimeException("Assertion failed, stopping execution.");
          }
         test.pass("the Status code is passed 200");  
		
	
 }
	@Test
	 void post() throws JsonProcessingException {
test = extent.createTest("Post API", "Start Post API test");
	
		
		Response response = RestAssured.given()
			.header("content-type",data.getContentType())
			.header("token", data.gettokene())
			.body(data.getbodyinfo())
            .post(URL+data.getUri());
       int statusCode = response.getStatusCode();
       test.log(Status.INFO, " Log the result of status code ="+statusCode);
       
      try { assertEquals(statusCode, 200);
      
      } catch (AssertionError e) {
    	  test.fail("Status code is not 200");
    	  
          
          throw new RuntimeException("Assertion failed, stopping execution.");
          }
        
      test.pass("Status code is  200");


		
}
	@AfterTest
	void aftertest() {
		 // calling flush writes everything to the log file
        extent.flush();
		
	}

}

