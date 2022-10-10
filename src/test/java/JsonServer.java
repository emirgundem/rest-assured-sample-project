import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class JsonServer {
    @Test
    public void getPost() {
        baseURI = "http://localhost:3000";
        given()
                .get("/posts")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void addPost() {
        JSONObject request = new JSONObject();
        request.put("id","3");
        request.put("title","twitterPost");
        request.put("author","emir");

        baseURI = "http://localhost:3000";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toString())
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .log()
                .all();
        System.out.println("Post added Success");

    }

    @Test
    public void updatePost() {
          JSONObject request = new JSONObject();
          request.put("title","ınstagramPost");
          request.put("author","test");

          baseURI = "http://localhost:3000";
          given()
                  .header("Content-Type","application/json")
                  .contentType(ContentType.JSON)
                  .accept(ContentType.JSON)
                  .body(request.toString())
                  .when()
                  .put("/posts/2")
                  .then()
                  .statusCode(200)
                  .log()
                  .all();
        System.out.println("Post Updated");
    }

    @Test
    public void patchPost() {
        JSONObject request = new JSONObject();

        request.put("author","emirgundem");
        baseURI = "http://localhost:3000";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toString())
                .when()
                .patch("/posts/2")
                .then()
                .statusCode(200)
                .log()
                .all();

    }

    @Test
    public void deletePost() {
        baseURI = "http://localhost:3000";
        given()
                .when()
                .delete("posts/3")
                .then()
                .statusCode(200)
                .log()
                .all();
        System.out.println("Post Deleted Success");
    }
}
