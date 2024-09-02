package psa.tests.examples_web.transactions;

import io.gatling.javaapi.core.ChainBuilder;

import static psa.tests.examples_web.requests.WebRequests.*;
import static psa.tests.examples_web.WebSimulation.config;
import static io.gatling.javaapi.core.CoreDsl.exec;


public class UserActions {
    public static ChainBuilder purchaseFlow = exec(session -> session.set("password", config.password))
            .pause(config.minPause, config.maxPause)
            .exec(searchProduct)
            .pause(config.minPause, config.maxPause);

    public static ChainBuilder get = exec(retrieveData)
            .pause(config.minPause, config.maxPause);

    public static ChainBuilder manipulate = exec(manipulateData)
            .pause(config.minPause, config.maxPause);
}
