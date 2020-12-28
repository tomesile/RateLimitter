package main.samples.com;

import main.samples.com.interfaces.*;

import java.util.concurrent.ConcurrentHashMap;

public class RateLimiter implements IRateLimiter {
    RateRule rateRule=null;
    IAlg iAlg = null;
    IModel iModle=null;
    Iparser iparser=null;
    IRuleConfig ruleConfig=null;

   RateLimiter()
   {
       rateRule=new RateRule();


   }
   private ConcurrentHashMap<String,Integer> limiteCount=new ConcurrentHashMap<String,Integer>();

   public Boolean toLimite(IAlg alg,IModel model,Iparser iparser,String limiteName)
    {
        if(iparser==null) iparser=new JsonParser();
        if(alg==null)  alg=new FixedWindowAlg();
        if(model==null) model=new SingleModel();
        if (limiteName==null) return false;
        if(limiteCount.get(limiteName)==null) return false;
        if(limiteCount.get(limiteName)<rateRule.getLimiteNumber()) return false;

        limiteNow(alg,model,iparser,limiteName);
        return true;
    }
    private void limiteNow(IAlg alg,IModel model,Iparser iparser,String limiteName)
    {
        System.out.println("limite now !");
        System.out.println("count:"+limiteCount.get(limiteName));
    }

    public void putElement(String name,Integer value)
    {
        limiteCount.put(name,value);

    }

    public RateRule getRateRule() {
        return rateRule;
    }

    public IRuleConfig getRuleConfig()
    {
        if(ruleConfig==null) return new RuleJsonConfig("ruleConfig.conf");
        return ruleConfig;
    }
    public void setRuleConfig(IRuleConfig config)
    {
        if (config==null) ruleConfig=new RuleJsonConfig("ruleConfig.conf");
        ruleConfig=config;
    }
    public static void main(String[] args)
    {
        RateLimiter rateLimiter=new RateLimiter();
        rateLimiter.putElement("name",1000);
        rateLimiter.setRuleConfig(new RuleJsonConfig("jsonfileDir.conf"));
       // rateLimiter.getRuleConfig().setAlg(new FixedWindowAlg());

        rateLimiter.getRuleConfig( ).readNow();
        rateLimiter.getRuleConfig().getAlg().doAlg();
        rateLimiter.toLimite(null,null,null,"name");

    }


}




