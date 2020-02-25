package seppe.alpaerts.notedroid.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import java.time.LocalDate;

import seppe.alpaerts.notedroid.R;
import seppe.alpaerts.notedroid.model.Note;
import seppe.alpaerts.notedroid.model.NoteViewModel;

public class NewNoteFragment extends Fragment {


    private EditText titleET;
    private EditText inhoudET;
    private Button savebtn;

    private View.OnClickListener saveListener = new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onClick(View v) {
            Note n= new Note(titleET.getText().toString(), inhoudET.getText().toString());

            NoteViewModel model = new ViewModelProvider(getActivity()).get(NoteViewModel.class);
            model.addNoteToList(n);
            Navigation.findNavController(v).navigate(R.id.saveNewNote);
        }
    };
    public NewNoteFragment () {

    }


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_new_note, container, false);
         titleET = rootView.findViewById(R.id.et_title);
         inhoudET = rootView.findViewById(R.id.et_inhoud);
         savebtn = rootView.findViewById(R.id.btn_save);
         savebtn.setOnClickListener(saveListener);



        return rootView;
    }
}
