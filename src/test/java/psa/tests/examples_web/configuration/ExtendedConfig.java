package psa.tests.examples_web.configuration;

import psa.core.config.DefaultConfig;

public class ExtendedConfig extends DefaultConfig {
    public String password;

    public ExtendedConfig() {
        super();
        this.password = System.getProperty("password", "temp");
    }
}
