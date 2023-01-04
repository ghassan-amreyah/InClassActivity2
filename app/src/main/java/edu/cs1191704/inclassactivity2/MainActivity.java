package edu.cs1191704.inclassactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.gson.Gson;


public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    public static final String DATA = "bookInfo";
    private EditText bookTitle, authorName, pageNum;
    private Button saveBtn, addBtn;
    private Switch availableSwitch;
    private static Book[] books = new Book[100];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        //References
        setupReferences();

    }

    private void setupReferences()
    {
        bookTitle = findViewById(R.id.bookTitle);
        authorName = findViewById(R.id.authorName);
        pageNum = findViewById(R.id.pageNum);
        availableSwitch = findViewById(R.id.availableSwitch);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }

    public void addData(View view)
    {


        String title = bookTitle.getText().toString();
        String author = authorName.getText().toString();
        int pages = Integer.parseInt(pageNum.getText().toString());
        boolean select = availableSwitch.isChecked();

        for(int i = 0 ; i < books.length ; i++)
        {
            books[i] = new Book(title,author,pages,select);
        }

        Toast.makeText(MainActivity.this, "Data has been Added", Toast.LENGTH_SHORT).show();
    }

    public void saveData(View view)
    {
        Gson gson = new Gson();
        String str = gson.toJson(books);
        editor.putString(DATA ,str);
        editor.commit();

        Toast.makeText(MainActivity.this, "Data has been Saved", Toast.LENGTH_SHORT).show();

    }

//    public void saveSetup()
//    {
//        saveDataBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//                Book[] books = new Book[2];
//                books[0] = new Book("Android", "Ahmad");
//                books[1] = new Book("Software", "Ali");
//
//                Gson gson = new Gson();
//                String str = gson.toJson(books);
//                editor.putString(DATA ,str);
//                editor.commit();
//
//                Toast.makeText(MainActivity.this, "Data has been saved", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//    }
//
//
//    public void LoadSetup()
//    {
//        loadDataBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//                Gson gson = new Gson();
//                String str = prefs.getString(DATA, "");
//                Book[] books = gson.fromJson(str, Book[].class);
//
//                Toast.makeText(MainActivity.this, "Number of books: " + books.length , Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//    }
}