package com.example.gabrieljava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private TextView mainTextView;
    Button mainButton;
    EditText mainEditText;
    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();
    Button ok_btn, cnc_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Верхний текст
        mainTextView = findViewById(R.id.main_textview1);
        mainTextView.setText("Set in Java!");
        //Кнопка
        mainButton = findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);
        //Поле ввода
        mainEditText = findViewById(R.id.main_edittext);
        //Список
        mainListView = findViewById(R.id.main_listview);
        mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mNameList);
        mainListView.setAdapter(mArrayAdapter);
        //Интерактивный список
        mainListView.setOnItemClickListener(this);
        //Кнопки OK и cancel
        ok_btn = findViewById(R.id.ok_btn);
        cnc_btn = findViewById(R.id.cnc_btn);
        View.OnClickListener oclBtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(ok_btn)) {
                    mainTextView.setText("Нажата кнопка OK");
                    Toast.makeText(getApplicationContext(), "Нажата кнопка OK", Toast.LENGTH_LONG).show();
                }
                if(v.equals(cnc_btn)) {
                    mainTextView.setText("Нажата кнопка Cancel");
                    Toast.makeText(getApplicationContext(), "Нажата кнопка Cancel", Toast.LENGTH_LONG).show();
                }
            }
        };
        ok_btn.setOnClickListener(oclBtn);
        cnc_btn.setOnClickListener(oclBtn);
    }

    //Вывод текста с именем по нажатию кнопки, добавление имени в список
    public void onClick(View v) {
        mainTextView.setText(mainEditText.getText().toString() + " is learning Android development!");
        mNameList.add(mainEditText.getText().toString());
        mArrayAdapter.notifyDataSetChanged();
    }

    //Отображение элемента списка в верхнем текстовом поле по нажатию
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("omg android", position + ": " + mNameList.get(position));
        mainTextView.setText(mNameList.get(position).toString() + " is learning Android development!");
    }
}