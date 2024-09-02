package psa.core.protocol.impl;

import psa.core.protocol.ProtocolLoader;
import io.gatling.javaapi.core.ProtocolBuilder;

import static io.gatling.javaapi.http.HttpDsl.http;

public class DefaultHttpProtocol implements ProtocolLoader {
    @Override
    public ProtocolBuilder getProtocol(String targetUrl) {
        return http
                .baseUrl(targetUrl)
                .shareConnections()
                .acceptHeader("*/*")
                .acceptEncodingHeader("gzip, deflate, br")
                .connectionHeader("keep-alive")
                .userAgentHeader("Gatling/PerformanceTest")
                .disableFollowRedirect()
                .disableCaching();
    }
}
