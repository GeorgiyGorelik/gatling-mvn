package psa.tests.examples_web.scenario;

import io.gatling.javaapi.core.Choice;
import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.FeederBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import psa.tests.examples_web.transactions.UserActions;

import static psa.tests.examples_web.WebSimulation.config;
import static psa.tests.examples_web.requests.AuthRequests.*;
import static io.gatling.javaapi.core.CoreDsl.*;

public class BasicNavigation {
    static FeederBuilder<String> userFeeder = csv("epam/examples_web/users.csv").random();
    public static ScenarioBuilder userScenario = scenario("User_ECommerce_Scenario")
            .feed(userFeeder)
            .exec(session -> session.set("password", config.password))
            .pause(config.minPause, config.maxPause)
            .exec(login).exitHereIfFailed()
            .during(config.testDuration).on(
                    CoreDsl.exec(UserActions.purchaseFlow)
                            .randomSwitch().on(
                                    new Choice.WithWeight(50.0, UserActions.get),
                                    new Choice.WithWeight(50.0, UserActions.manipulate)
                            ))
            .exec(userLogout);
}
