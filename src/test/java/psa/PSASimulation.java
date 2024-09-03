package psa;

import io.gatling.javaapi.core.PopulationBuilder;
import io.gatling.javaapi.core.ProtocolBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;
import psa.core.config.DefaultConfig;
import psa.core.load.impl.ClosedLoadModel;
import psa.core.load.impl.OpenLoadModel;
import psa.core.load.impl.SingleIterationLoadModel;
import psa.core.protocol.impl.DefaultHttpProtocol;

import static psa.ApiRequests.*;
import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;

public class PSASimulation extends Simulation {

    public static DefaultConfig config = new DefaultConfig();
    ProtocolBuilder httpProtocol = new DefaultHttpProtocol().getProtocol(config.baseUrl);

    ScenarioBuilder testScenario = scenario("PSA API Tests")
            .exec(HomePage)
            .exec(Search);

    PopulationBuilder loadModel = new OpenLoadModel(testScenario, config).buildLoadModel();

    {
        setUp(loadModel).protocols(httpProtocol);
    }
}