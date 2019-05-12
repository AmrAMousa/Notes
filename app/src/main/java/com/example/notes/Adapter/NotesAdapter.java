package com.example.notes.Adapter;


import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.notes.NotesDB.NotesContract;
import com.example.notes.R;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    Context context;
    Cursor cursor;


    public NotesAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;
    }

    @NonNull
    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.note_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.ViewHolder viewHolder, int i) {
        if (!cursor.moveToPosition(i)) {
            return;
        }
        String noteContent = cursor.getString(cursor.getColumnIndex(NotesContract.NotesEntry.COLUMN_NOTES));
        long id = cursor.getLong(cursor.getColumnIndex(NotesContract.NotesEntry._ID));
        viewHolder.noteText.setText(noteContent);
        viewHolder.itemView.setTag(id);

    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }


    public void swapCursor(Cursor newCursor) {
        if (cursor != null) {
            cursor.close();
        }

        cursor = newCursor;

        if (newCursor != null) {
            notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView noteText;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            noteText = itemView.findViewById(R.id.note_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder=new AlertDialog.Builder(context);
                    builder.setTitle("Note")
                            .setMessage(noteText.getText().toString())
                            .show();
                }
            });
        }
    }
}
