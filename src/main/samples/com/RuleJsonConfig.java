package main.samples.com;

import main.samples.com.interfaces.IAlg;
import main.samples.com.interfaces.IRuleConfig;

public class RuleJsonConfig implements IRuleConfig {
    private String configDir;
    private  String  commonConfig="config.conf";
    private RuleConfig ruleConfig;


    RuleJsonConfig(){ ruleConfig=new RuleConfig();}
    RuleJsonConfig(String configDirIn){

        configDir=configDirIn;
        ruleConfig=new RuleConfig();
    }
    public String getConfigDir()
    {

        return configDir;
    }
    public void setConfigDir(String strConfigDir)
    {
        if(strConfigDir==null) configDir=commonConfig;
        configDir=strConfigDir;
    }

    public void readNow()
    {
        readConfigFromFile();
    }

     public void readConfigFromFile()
    {
        System.out.println("read config from "+configDir);
        ruleConfig.setAlg(new FixedWindowAlg());
    }

    public RateRule configToRule(RuleConfig config)
    {

        return null;
    }
    public IAlg getAlg()
    {
       // if(ruleConfig.getAlg()==null) return new FixedWindowAlg();
        return ruleConfig.getAlg();
    }
    public void setAlg(IAlg algIn)
    {
        ruleConfig.setAlg(algIn);
    }
    //properties
    public RuleConfig getRuleConfig()
    {
        return ruleConfig;
    }
    public void setRuleConfig(RuleConfig ruleConfigIn)
    {
        ruleConfig=ruleConfigIn;
    }
}
