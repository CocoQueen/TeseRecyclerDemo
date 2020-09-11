package com.example.teserecyclerdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "==========";
    private RecyclerView recyclerView;
    private EditText editText;
    private AlertDialog.Builder builder;
    private TestAdapter testAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        editText = findViewById(R.id.ed);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    List<Integer> list = new ArrayList<>();
//    List<Integer> list2 = new ArrayList<>();

    boolean isAdd;


    public void btnAdd(View view) {
        isAdd = false;
        String content = editText.getText().toString().trim();
        try {
            int parseInt = Integer.parseInt(content);

            if (list.size() > 0 && null != testAdapter) {
                for (int i = 0; i < list.size(); i++) {
//                    list2.clear();
                    if (parseInt == list.get(i)) {
                        isAdd = true;
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        final int finalI = i;
                        builder.setTitle("是否要删除" + parseInt + "这个值？").setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                list.remove(finalI);
                                testAdapter.notifyItemRemoved(finalI);
                                dialogInterface.dismiss();
                            }
                        }).setNegativeButton("否", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        builder.create().show();

                        Log.e(TAG, "onCreate: 有" + parseInt);
                    }
                }
            }
            if (!isAdd) {
                list.add(parseInt);
            }

            testAdapter = new TestAdapter(list);
            recyclerView.setAdapter(testAdapter);


        } catch (NumberFormatException e) {
            Log.e(TAG, "btnAdd: " + e.getMessage());
        }

    }
}
