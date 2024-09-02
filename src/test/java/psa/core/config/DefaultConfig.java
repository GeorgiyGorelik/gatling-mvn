package psa.core.config;

public class DefaultConfig {
    public String baseUrl;
    public int vUsers ;
    public int minPause;
    public int maxPause ;
    public long rampDuration ;
    public long constantDuration;
    public long testDuration;

    public DefaultConfig() {
        this.baseUrl = System.getProperty("baseUrl", "https://stagev2.palmettostatearmory.com");
        this.vUsers = Integer.getInteger("vUsers", 1);
        this.minPause = Integer.getInteger("minPause", 3);
        this.maxPause = Integer.getInteger("maxPause", 5);
        this.rampDuration = Long.getLong("rampUp", 10);
        this.constantDuration = Long.getLong("constantLoad", 30);
        this.testDuration = rampDuration + constantDuration;
    }
}
