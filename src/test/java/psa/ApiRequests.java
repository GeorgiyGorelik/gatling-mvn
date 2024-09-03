package psa;

import io.gatling.javaapi.http.HttpRequestActionBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

//***************************************
// Describe http requests here
//***************************************
//
public class ApiRequests {

    public static HttpRequestActionBuilder HomePage = http("GET_homepage")
            .get("/")
            .check(substring("<!doctype html>"))
            .check(status().is(200));

    public static HttpRequestActionBuilder Search = http("GET_search")
            .get("/catalogsearch/result/?q=9mm+hollow")
            .check(substring("9mm hollow"))
            .check(status().is(200));
}
