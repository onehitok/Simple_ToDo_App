package sg.edu.rp.c346.id20041194.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner AddorDelete;
    EditText etTask;
    Button btnAdd;
    Button btnRemove;
    Button btnClear;
    ListView lvTask;


    ArrayList<String> alTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alTasks = new ArrayList<String>();

        AddorDelete = findViewById(R.id.spinner);
        etTask = findViewById(R.id.editTask);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnRemove = findViewById(R.id.buttonRemoveItem);
        btnClear = findViewById(R.id.buttonClearItem);
        lvTask = findViewById(R.id.listViewTask);

        AddorDelete.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        etTask.setHint("Type in a new task here");
                        btnRemove.setEnabled(false);
                        break;
                    case 1:
                        etTask.setHint("Type in the index of the task to be removed");
                        btnRemove.setEnabled(true);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        

        ArrayAdapter adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, alTasks);

        lvTask.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String task = etTask.getText().toString();
              alTasks.add(task);
              adapter.notifyDataSetChanged();
          }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pos = Integer.parseInt(etTask.getText().toString());
                alTasks.remove(pos);
                adapter.notifyDataSetChanged();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alTasks.clear();
                adapter.notifyDataSetChanged();
            }
        });

















    }
}