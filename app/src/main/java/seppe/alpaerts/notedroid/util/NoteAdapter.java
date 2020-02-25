package seppe.alpaerts.notedroid.util;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

import seppe.alpaerts.notedroid.R;
import seppe.alpaerts.notedroid.model.Note;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> implements Filterable {

    class NoteViewHolder extends RecyclerView.ViewHolder {

        final TextView tvTitle;
        final Button btnDetail;
        final TextView tvDate;

        final View.OnClickListener detailListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int positition = getAdapterPosition();
                Bundle data = new Bundle();
                data.putSerializable("passedNote", items.get(positition));
                Navigation.findNavController(v).navigate(R.id.showDetail, data);
            }
        };


        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title_card);
            btnDetail = itemView.findViewById(R.id.btn_detail);
            btnDetail.setOnClickListener(detailListener);
            tvDate = itemView.findViewById(R.id.tv_date);


        }
    }


    private ArrayList<Note> items;
    private ArrayList<Note> OGitems;

    public NoteAdapter() {
        this.items = new ArrayList<>();
        this.OGitems = new ArrayList<>();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View card = layoutInflater.inflate(R.layout.note_card, parent, false);
        return new NoteViewHolder(card);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note currentNote = items.get(position);

        holder.tvTitle.setText(currentNote.getTitel());
        holder.tvDate.setText(currentNote.getLaatstewijzigingen().toString());


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItems(ArrayList<Note> notes) {
        items.clear();
        items.addAll(notes);
        OGitems.clear();
        OGitems.addAll(notes);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String input = charSequence.toString();
                if (input.isEmpty()) {
                    items = OGitems;
                } else {
                    ArrayList<Note> tempList = new ArrayList<>();

                    for (Note element : items) {
                        if (element.getTitel().contains(charSequence)) {
                            tempList.add(element);
                        }
                    }
                    items = tempList;
                }
                return null;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                notifyDataSetChanged();
            }
        };
    }
}
