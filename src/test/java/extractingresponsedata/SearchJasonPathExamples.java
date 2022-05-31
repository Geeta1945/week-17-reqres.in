package extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SearchJasonPathExamples {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt(){

        RestAssured.baseURI ="https://reqres.in";
        RestAssured.basePath="/api";
        response =given()
                .when()
                .get("/users")
                .then().statusCode(200);
    }

    //1.page = 2
    @Test
    public void test1(){
        int pg= response.extract().path("page");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The page no is : "+pg);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test2(){

        int per_page = response.extract().path("per_page");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The pages per page is : "+per_page);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test3(){
        int id = response.extract().path("data[0].id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The id of first data is : "+id);
        System.out.println("------------------End of Test---------------------------");

    }
    @Test
    public void test4(){
        String name= response.extract().path("data[3].first_name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of fourth data is : "+name);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test5(){
        List<Integer> Ids = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The list of data is : "+Ids.size());
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test6(){
        String avatar= response.extract().path("data[5].avatar");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The avatar of sixth data is : "+avatar);
        System.out.println("------------------End of Test---------------------------");

    }
    @Test
    public void test7(){
        String url = response.extract().path("support.url");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The url for support is : "+ url);
        System.out.println("------------------End of Test---------------------------");

    }
    @Test
    public void test8(){
        String text= response.extract().path("support.text");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The text of support is : "+text);
        System.out.println("------------------End of Test---------------------------");
    }

    }
