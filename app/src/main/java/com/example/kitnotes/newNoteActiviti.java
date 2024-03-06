package com.example.kitnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


import com.example.kitnotes.Models.Notes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class newNoteActiviti extends AppCompatActivity {
    EditText TextNote, edittitle;
    ImageButton save, exit;
    Spinner spin;

    Notes notes;

    boolean isOldNote = false;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note_activiti);

        TextNote = findViewById(R.id.textNote);
        edittitle = findViewById(R.id.editTitle);
        save = findViewById(R.id.btnSave);
        exit = findViewById(R.id.btnExit);




        notes = new Notes();
        try{
            notes = (Notes) getIntent().getSerializableExtra("old_notes");
            edittitle.setText(notes.getTitle());
            TextNote.setText(notes.getNotes());
            isOldNote = true;

        }catch (Exception e){
            e.printStackTrace();
        }


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edittitle.getText().toString();
                String description = TextNote.getText().toString();

                if(description.isEmpty()){
                    Toast.makeText(newNoteActiviti.this, "Добавте текст заметки",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat format = new SimpleDateFormat("h:mm a");
                Date date = new Date();

                if(!isOldNote){
                    notes = new Notes();

                }

                notes.setTitle(title);
                notes.setNotes(description);
                notes.setDate(format.format(date));

                Intent intent = new Intent();
                intent.putExtra("notes", notes);
                setResult(Activity.RESULT_OK, intent);



                finish();

            }
        });














    }






}