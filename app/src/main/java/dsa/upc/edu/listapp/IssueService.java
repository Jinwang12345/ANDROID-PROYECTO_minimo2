package dsa.upc.edu.listapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IssueService {
    @POST("issue")
    Call<Void> reportIssue(@Body Issue issue);

    @GET("issue")
    Call<List<Issue>> getIssues();
}
