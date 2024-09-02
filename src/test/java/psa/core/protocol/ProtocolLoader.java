package psa.core.protocol;

import io.gatling.javaapi.core.ProtocolBuilder;

public interface ProtocolLoader {
    ProtocolBuilder getProtocol(String targetUrl);
}
