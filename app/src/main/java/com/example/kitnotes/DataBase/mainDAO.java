package com.example.kitnotes.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import static androidx.room.OnConflictStrategy.REPLACE;
import com.example.kitnotes.Models.Notes;

import java.util.List;


@Dao
public interface mainDAO {
    //Метод для вставки данных
    @Insert(onConflict = REPLACE)
    void insert (Notes notes);

    //Метод для получения данных
    //Получеаем все данные из таблицы notes с сортировкой по id

    @Query("SELECT * FROM notes ORDER BY id DESC")
    List<Notes> getAll();

    //Метод для обновления данных
    @Query("UPDATE notes SET title = :title, notes = :notes WHERE ID = :ID ")
    void update(int ID, String title, String notes);

    //Метод для удаления данных
    @Delete
    void delete(Notes notes);





}
