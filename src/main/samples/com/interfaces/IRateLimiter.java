package main.samples.com.interfaces;

import main.samples.com.RateRule;


public interface IRateLimiter {

    void setRuleConfig(IRuleConfig config);
    IRuleConfig getRuleConfig();
}
