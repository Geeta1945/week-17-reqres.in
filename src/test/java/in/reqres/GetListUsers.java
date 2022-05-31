package in.reqres;

import io.restassured.response.Response;
import model.Reqres_Pojo;
import org.junit.Test;
import testbase.TestBase;

import static io.restassured.RestAssured.given;

public class GetListUsers extends TestBase {

@Test
    public void getAllUsers(){
    Response response =given()
            .when()
            .get("/users");
    response.then().statusCode(200);
    response.prettyPrint();

}

@Test
    public void getSingleUser(){

    Response response =given()
            .pathParam("id",1)
            .when()
            .get("/users/{id}");
    response.then().statusCode(200);
    response.prettyPrint();
}

@Test
//id -733,332
    public void createUser(){
    Reqres_Pojo reqres_pojo =new Reqres_Pojo();
    reqres_pojo.setName("Jinnat");
    reqres_pojo.setJob("Aman");
    Response response = given()
            .header("Content-Type", "application/json")
            .body(reqres_pojo)
            .when()
            .post("/users");
    response.then().statusCode(201);
    response.prettyPrint();
}

@Test
    public void patchUser(){
    Reqres_Pojo reqres_pojo =new Reqres_Pojo();
    reqres_pojo.setName("My Name changed");
    Response response= given()
            .header("Content-Type", "application/json")
            .pathParam("id",733)
            .when()
            .patch("/user/{id}");
    response.then().statusCode(200);
    response.prettyPrint();
}
@Test
    public void deleteUser(){
    Reqres_Pojo reqres_pojo =new Reqres_Pojo();
    Response response = given()
            .pathParam("id",332)
            .header("Content-Type", "application/json")
            .body(reqres_pojo)
            .delete("/users/{id}");
    response.then().statusCode(204);
    response.prettyPrint();
}
}
