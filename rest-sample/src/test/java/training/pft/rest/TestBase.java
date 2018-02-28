package training.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.SkipException;

import java.io.IOException;
import java.util.Set;


public class TestBase {

  private Executor getExecutor() {
    return Executor.newInstance().auth("28accbe43ea112d9feb328d2c00b3eed", "");
  }

  public boolean isIssueOpen(int issueId) throws IOException {
    String status = getIssueStatus(issueId);
    if (status.equals("Resolved") || status.equals("Closed")) {
      return false;
    } else {
      return true;
    }
  }

  private String getIssueStatus(int issueId) throws IOException {
    String json =  getExecutor().execute(Request.
            Get(String.format("http://demo.bugify.com/api/issues/%s.json", issueId)))
            .returnContent().toString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    Set<Issue> issue= new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
    return issue.iterator().next().getStatus();
  }

  public void skipIfNotFixed (int issueId) throws IOException {
    if (isIssueOpen(issueId) == true) {
      System.out.println("Ignored because issue with id " + issueId + " not solved yet");
      throw new SkipException ("Ignored because issue  " + issueId);
    }
  }

}
