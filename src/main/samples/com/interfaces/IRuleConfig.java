package main.samples.com.interfaces;

import main.samples.com.RateRule;
import main.samples.com.RuleConfig;

public interface IRuleConfig {

    void readNow();
    RateRule configToRule(RuleConfig config);
    IAlg getAlg();
    void setAlg(IAlg algIn);

}
