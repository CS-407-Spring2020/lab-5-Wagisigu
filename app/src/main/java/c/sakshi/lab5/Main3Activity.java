package c.sakshi.lab5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main3Activity extends AppCompatActivity {

    int noteid = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        EditText content_editText = (EditText) findViewById(R.id.content_editText);
        Intent intent = getIntent();
        noteid = intent.getIntExtra("noteid",-1);

        if (noteid != -1) {
            Note note = Main2Activity.notes.get(noteid);
            String noteContent = note.getContent();
            content_editText.setText(noteContent);
        }
    }

    public void onSaveButtonClicked (View v) {
        String content = ((EditText)findViewById(R.id.content_editText)).getText().toString();
        Context context = getApplicationContext();
        SQLiteDatabase sqLiteDatabase = context.openOrCreateDatabase("notes",Context.MODE_PRIVATE,null);
        DBHelper dbHelper = new DBHelper(sqLiteDatabase);
        String username = getSharedPreferences("c.sakshi.lab5",MODE_PRIVATE).getString("username","");
        String title;
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String date = dateFormat.format(new Date());

        if (noteid == -1) {
            title = "NOTE_" + (Main2Activity.notes.size()+1);
            dbHelper.saveNotes(date,username,title,content);
        } else {
            title = "NOTE_" + (noteid+1);
            dbHelper.updateNote(date, username, title, content);
        }
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("username",username);
        startActivity(intent);
        finish();
    }
}
