package jumoke.test;

import java.util.Date;
import java.util.List;

public interface ITestCase {
	boolean getDebugMode();
	Date getStartDate(); 
	Date getEndDate(); 
	String getComments();
	String getTestPlanID();
	String getID();
	String getUID();
	String getSeverity();
	String getPriority();
	String getStatus();
	String getTester();
	String getURL();
	int getExceutedIterations();
	int getMaxIterations();
	
	void setStartDate(Date dt); 
	void setEndDate(Date dt);
	void setComments(String comments);
	void setExceutedIterations();
	void setStatus(String status);
	
	IEnvironment getEnvironment();
	ITestParameters getTestParameters();
	List<ITestCase> dependsOn();
	
}
