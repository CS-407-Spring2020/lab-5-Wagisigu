package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5",MODE_PRIVATE);
        String username = sharedPreferences.getString("username","");
        if (!username.contentEquals("")) {
            send(username);
        }
        else {
            setContentView(R.layout.activity_main);
        }
    }

    public void onLoginButtonClicked (View v) {
        String username = ((EditText)findViewById(R.id.username_editText)).getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5",MODE_PRIVATE);
        sharedPreferences.edit().putString("username",username).apply();
        send(username);
    }

    private void send (String u) {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("username",u);
        startActivity(intent);
    }
}
