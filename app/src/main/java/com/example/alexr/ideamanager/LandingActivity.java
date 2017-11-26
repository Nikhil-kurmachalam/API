package com.example.alexr.ideamanager;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.alexr.ideamanager.services.MessageService;
import com.example.alexr.ideamanager.services.ServiceBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        new GetMessagesTask().execute();
    }

    public void GetStarted(View view){
        Intent intent = new Intent(this, IdeaListActivity.class);
        startActivity(intent);
    }

    public class GetMessagesTask extends AsyncTask<Void, Void, Boolean> {

        private String message = "";

        @Override
        protected Boolean doInBackground(Void... params) {
            MessageService taskService = ServiceBuilder.buildService(MessageService.class);
            Call<String> call = taskService.getMessages();
            try {
                message = call.execute().body();
            } catch (Exception e) {
                // Todo
            }

            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            ((TextView) findViewById(R.id.message)).setText(message);
        }

        @Override
        protected void onCancelled() {
            // Todo
        }
    }
}
