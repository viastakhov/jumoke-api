package jumoke.test;

import java.util.List;


public interface ITestPlanCollection {
    List<ITestPlan> getTestPlans();
    List<ITestPlan> getTestPlans(List<ITestPlan> testPlans, String state);
    String getURL();
}
