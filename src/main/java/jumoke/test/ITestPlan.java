package jumoke.test;

import java.util.Date;
import java.util.List;


public interface ITestPlan {
    Date getStartDate();
    Date getEndDate();
    String getState();
    String getSoftwareID();
    String getURL();
    String getID();

    void setStartDate(Date dt);
    void setEndDate(Date dt);
    void setState(String state);

    List<ITestCase> getTestCases();
    List<IIssue> getIssues();
}
