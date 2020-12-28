package main.samples.com;

import main.samples.com.interfaces.IAlg;

public class RuleConfig {

    private IAlg alg;
    RuleConfig()
    {

    }
    public IAlg getAlg()
    {
        System.out.println("wo got the alg type!");
        return alg;
    }
    public void setAlg(IAlg algIn)
    {
        alg=algIn;
    }
}
