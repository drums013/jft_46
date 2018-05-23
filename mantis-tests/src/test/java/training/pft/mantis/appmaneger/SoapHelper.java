package training.pft.mantis.appmaneger;

import biz.futureware.mantis.rpc.soap.client.*;
import training.pft.mantis.model.Issue;
import training.pft.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SoapHelper {

  private ApplicationManager app;

  public SoapHelper(ApplicationManager app){
    this.app = app;
  }

  public Set<Project> getProject() throws MalformedURLException, ServiceException, RemoteException {
    MantisConnectPortType mc = getMantisConnect();
    ProjectData[] projects = mc.mc_projects_get_user_accessible(
            app.getProperty("web.userLogin"),
            app.getProperty("web.userPassword"));
    return Arrays.asList(projects).stream()
            .map((p) -> new Project().withId(p.getId().intValue()).withtName(p.getName())).collect(Collectors.toSet());
  }

  private MantisConnectPortType getMantisConnect() throws ServiceException, MalformedURLException {
    return new MantisConnectLocator()
              .getMantisConnectPort(new URL(app.getProperty("web.apiMantisUrl")));
  }

  public Issue addIssue(Issue issue) throws MalformedURLException, ServiceException, RemoteException {
    MantisConnectPortType mc = getMantisConnect();
    String[] categories = mc.mc_project_get_categories(
            app.getProperty("web.userLogin"),
            app.getProperty("web.userPassword"),
            BigInteger.valueOf(issue.getProject().getId()));
    IssueData issueData = new IssueData();
    issueData.setSummary(issue.getSummary());
    issueData.setDescription(issue.getDescription());
    issueData.setProject(new ObjectRef(BigInteger.valueOf(issue.getProject().getId()), issue.getProject().getName()));
    issueData.setCategory(categories[0]);
    BigInteger issueId = mc.mc_issue_add(
            app.getProperty("web.userLogin"),
            app.getProperty("web.userPassword"),
            issueData);
    IssueData createdIssueData = mc.mc_issue_get(
            app.getProperty("web.userLogin"),
            app.getProperty("web.userPassword"),
            issueId);
    return new Issue()
            .withId(createdIssueData.getId().intValue())
            .withSummary(createdIssueData.getSummary())
            .withDescription(createdIssueData.getDescription())
            .withProject(new Project().withId(createdIssueData.getProject().getId().intValue())
                                      .withtName(createdIssueData.getProject().getName()));
  }

  public String getIssueStatus(int issueId) throws MalformedURLException, ServiceException, RemoteException {
    MantisConnectPortType mc = getMantisConnect();
    return mc.mc_issue_get(
            app.getProperty("web.userLogin"),
            app.getProperty("web.userPassword"),
            BigInteger.valueOf(issueId)).getStatus().getName();
  }
}
