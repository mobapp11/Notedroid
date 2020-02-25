package seppe.alpaerts.notedroid.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import seppe.alpaerts.notedroid.R;
import seppe.alpaerts.notedroid.model.Note;
import seppe.alpaerts.notedroid.model.NoteViewModel;
import seppe.alpaerts.notedroid.util.NoteAdapter;

public class ListFragment extends Fragment {

    private SearchView.OnQueryTextListener searchListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            adapter.getFilter().filter(newText);
            return false;
        }
    };

    private FloatingActionButton addBtn;
    private NoteAdapter adapter;
    private View.OnClickListener addListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Navigation.findNavController(v).navigate(R.id.add_to_list);
        }
    };


    public ListFragment() {

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        addBtn = rootView.findViewById(R.id.btn_add);
        addBtn.setOnClickListener(addListener);

        RecyclerView rvNotes = rootView.findViewById(R.id.rv_notes);

        setHasOptionsMenu(true);
        rvNotes.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        adapter = new NoteAdapter();
        rvNotes.setAdapter(adapter);


        NoteViewModel model = new ViewModelProvider(getActivity()).get(NoteViewModel.class);
        model.getNotes().observe(getViewLifecycleOwner(), new Observer<ArrayList<Note>>() {

            @Override
            public void onChanged(ArrayList<Note> jokes) {
                adapter.addItems(jokes);
            }
        });

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.mi_search).getActionView();
        searchView.setOnQueryTextListener(searchListener);
        super.onCreateOptionsMenu(menu, inflater);
    }
}