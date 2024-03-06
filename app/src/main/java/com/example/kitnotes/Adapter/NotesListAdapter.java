package com.example.kitnotes.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitnotes.Models.Notes;
import com.example.kitnotes.NotesClickListener;
import com.example.kitnotes.R;

import java.util.List;

public class NotesListAdapter extends RecyclerView.Adapter<NotesViewHolder>{

    Context context;
    List<Notes> list;

    NotesClickListener listener;

    public NotesListAdapter(Context context, List<Notes> list, NotesClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.notes_list, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {

        holder.textViewTitle.setText(list.get(position).getTitle());
        holder.textViewTitle.setSelected(true);

        holder.TextView_notes.setText(list.get(position).getNotes());

        holder.TextView_date.setText(list.get(position).getDate());
        holder.TextView_date.setSelected(true);

        if(list.get(position).isPinned()){
            holder.imageViewPin.setImageResource(R.drawable.pin);
        }else{
            holder.imageViewPin.setImageResource(0);
        }

        holder.notes_conteiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(list.get(holder.getAdapterPosition()));

            }
        });






    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
class NotesViewHolder extends RecyclerView.ViewHolder {

    //Объявляем объекты из notes_list
    CardView notes_conteiner;
    TextView textViewTitle, TextView_notes, TextView_date;
    ImageView imageViewPin;


    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);
        notes_conteiner = itemView.findViewById(R.id.notes_conteiner);
        textViewTitle = itemView.findViewById(R.id.textViewTitle);
        TextView_notes = itemView.findViewById(R.id.TextView_notes);
        TextView_date = itemView.findViewById(R.id.TextView_date);
        imageViewPin = itemView.findViewById(R.id.imageViewPin);





    }
}
