package seppe.alpaerts.notedroid.model;

import android.os.Build;
import android.renderscript.Sampler;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.time.LocalDate;
import java.util.ArrayList;

public class NoteViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Note>> notes;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public MutableLiveData<ArrayList<Note>> getNotes() {
        if(notes == null){
            notes = new MutableLiveData<>();
            loadNotes();
        }
        return notes;
    }

    public void addNoteToList(Note n) {
        notes.getValue().add(n);

    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void loadNotes() {
        ArrayList<Note> newNotes = new ArrayList<>();

        newNotes.add(new Note("Dit is een Notitie", "Dit is de inhoud van de notitie"));
        newNotes.add(new Note("Dit is een Notitie 2", "Dit is de inhoud van de notitie 2"));
        newNotes.add(new Note("Dit is een Notitie 3", "Dit is de inhoud van de notitie 3"));
        newNotes.add(new Note("Dit is een Notitie 4", "Dit is de inhoud van de notitie 4"));

        notes.setValue(newNotes);
    }
}
