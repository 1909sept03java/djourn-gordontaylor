package Factory;

public class GetFactoryPlan {
	public GetFactoryPlan()
	{
		
	}
	  public abstractPlan getPlan(String planType){  
          if(planType == null){  
           return null;  
          }  
        if(planType.equalsIgnoreCase("DOMESTICPLAN")) {  
               return new DomesticPlan();  
             }   
         else if(planType.equalsIgnoreCase("COMMERICALPLAN")){  
              return new CommericalPlan();  
          }   
        else if(planType.equalsIgnoreCase("INDUSTRIALPLAN")) {  
              return new IndustrialPlan();  
        }  
    return null;  
 }  
}
