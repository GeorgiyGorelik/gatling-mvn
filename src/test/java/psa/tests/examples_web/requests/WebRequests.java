package psa.tests.examples_web.requests;

import io.gatling.javaapi.http.HttpRequestActionBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.core.CoreDsl.jsonPath;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class WebRequests {

    public static HttpRequestActionBuilder searchProduct = http("POST_search_product")
            .post("/search")
            .queryParam("product", "1")
            .check(status().is(200))
            .check(regex("token=\"(.+?)\"").find().saveAs("token"));
    public static HttpRequestActionBuilder retrieveData = http("GET_data")
            .get("/data")
            .header("Authorization", "Bearer #{authToken}")
            .check(css("title").is("Expected Page Title"))
            .check(css("#main-content").exists())
            .check(status().is(200));
    public static HttpRequestActionBuilder manipulateData = http("PUT_data")
            .put("/data")
            .header("Authorization", "Bearer #{authToken}")
            .body(StringBody("{ \"dataId\": \"#{dataId}\", \"newData\": \"#{newData}\" }")).asJson()
            .check(jsonPath("$.result").is("success"))
            .check(status().is(200));
}
