package dsa.upc.edu.listapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import dsa.upc.edu.listapp.auth.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportIssueActivity extends AppCompatActivity {

    private EditText editTextDate, editTextTitle, editTextMessage, editTextSender;
    private IssueService issueService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_issue);

        editTextDate = findViewById(R.id.editTextDate);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextMessage = findViewById(R.id.editTextMessage);
        editTextSender = findViewById(R.id.editTextSender);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);

        // Establecer fecha actual automáticamente
        String fechaActual = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        editTextDate.setText(fechaActual);

        // Cliente Retrofit con token
        issueService = ApiClient.getClient(this).create(IssueService.class);

        buttonSubmit.setOnClickListener(v -> sendIssue());
    }

    private void sendIssue() {
        String date = editTextDate.getText().toString();
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();
        String sender = editTextSender.getText().toString();

        Issue issue = new Issue(date, title, message, sender);
        Call<Void> call = issueService.reportIssue(issue);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(ReportIssueActivity.this, "Denuncia enviada", Toast.LENGTH_SHORT).show();
                    finish(); // Cierra la actividad y vuelve
                } else {
                    Toast.makeText(ReportIssueActivity.this, "Error al enviar denuncia", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(ReportIssueActivity.this, "Error de red: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
