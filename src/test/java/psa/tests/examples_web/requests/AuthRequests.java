package psa.tests.examples_web.requests;

import io.gatling.javaapi.http.HttpRequestActionBuilder;

import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.core.CoreDsl.jsonPath;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class AuthRequests {
    public static HttpRequestActionBuilder login = http("POST_login")
            .post("/login")
            .body(StringBody("{ \"username\": \"#{username}\", \"password\": \"#{password}\" }")).asJson()
            .check(status().is(200))
            .check(jsonPath("$.token").saveAs("authToken"));
    public static HttpRequestActionBuilder userLogout = http("POST_Logout")
            .post("/logout")
            .header("Authorization", "Bearer #{authToken}")
            .check(status().is(200));
}
