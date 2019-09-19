package jumoke.test;

import java.util.Date;

public interface IIssue {
    Date getTestedDate();
    double getMH();
    String getComments();
    String getTestPlanID();
    String getRefID();
    String getUID();
    String getClassification();
    String getStatus();
    String getState();
    String getTester();
    String getURL();
    String getResponsible();

    void setClassification(String classification);
    void setStatus(String status);
    void setTestedDate(Date dt);
    void setComments(String comments);
    void setState(String state);
    void setMH(double MH);
    void setResponsible(String user);
}
