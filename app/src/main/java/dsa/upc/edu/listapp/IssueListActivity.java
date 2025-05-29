    package dsa.upc.edu.listapp;

    import android.os.Bundle;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import java.util.List;

    import dsa.upc.edu.listapp.auth.ApiClient;
    import retrofit2.Call;
    import retrofit2.Callback;
    import retrofit2.Response;
    import retrofit2.Retrofit;
    import retrofit2.converter.gson.GsonConverterFactory;

    public class IssueListActivity extends AppCompatActivity {

        private RecyclerView recyclerView;
        private IssueAdapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_issue_list);

            recyclerView = findViewById(R.id.recyclerViewIssues);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            IssueService service = ApiClient.getClient(this).create(IssueService.class);

            service.getIssues().enqueue(new Callback<List<Issue>>() {
                @Override
                public void onResponse(Call<List<Issue>> call, Response<List<Issue>> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        adapter = new IssueAdapter(response.body());
                        recyclerView.setAdapter(adapter);
                    } else {
                        Toast.makeText(IssueListActivity.this, "No se pudo cargar la lista", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<List<Issue>> call, Throwable t) {
                    Toast.makeText(IssueListActivity.this, "Error de red", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
