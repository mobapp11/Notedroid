package seppe.alpaerts.notedroid.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.zip.Inflater;

import seppe.alpaerts.notedroid.R;
import seppe.alpaerts.notedroid.model.Note;

public class DetailFragment extends Fragment {

    public DetailFragment(){

    }


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView titleTV = rootview.findViewById(R.id.tv_title_detail);
        TextView inhoudTV = rootview.findViewById(R.id.tv_inhoud_detail);
        TextView dateTV = rootview.findViewById(R.id.tv_date_detail);
        TextView laatstewijzigingenTV = rootview.findViewById(R.id.tv_laatstewijzigingen_detail);

        Bundle data= getArguments();
        if (data != null) {
            if (data.containsKey("passedNote")){
                Note note = (Note) data.getSerializable("passedNote");
                titleTV.setText(note.getTitel());
                inhoudTV.setText(note.getInhoud());
                dateTV.setText(note.getAanmaakdatum().toString());
                laatstewijzigingenTV.setText(note.getLaatstewijzigingen().toString());
            }
        }
        return rootview;
    }
}



