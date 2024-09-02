package psa.tests.examples_web;

import psa.core.protocol.impl.DefaultHttpProtocol;
import psa.core.load.impl.ClosedLoadModel;
import psa.tests.examples_web.configuration.ExtendedConfig;
import io.gatling.javaapi.core.*;
import psa.tests.examples_web.scenario.BasicNavigation;

public class WebSimulation extends Simulation {
    public static ExtendedConfig config = new ExtendedConfig();
    ProtocolBuilder httpProtocol = new DefaultHttpProtocol().getProtocol(config.baseUrl);
    PopulationBuilder loadModel = new ClosedLoadModel(BasicNavigation.userScenario, config).buildLoadModel();

    {
        setUp(loadModel)
                .protocols(httpProtocol)
                .maxDuration(config.testDuration);
    }
}