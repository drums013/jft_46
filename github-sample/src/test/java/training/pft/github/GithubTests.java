package training.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

  @Test
  public void testCommits() throws IOException {
    Github github = new RtGithub("9520aa48d745f94ed907d9c008022d13227ee019");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("drums013", "jft_46")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }
}
