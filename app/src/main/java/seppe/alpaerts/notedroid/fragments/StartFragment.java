package seppe.alpaerts.notedroid.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import seppe.alpaerts.notedroid.R;

public class StartFragment extends Fragment {
    private Button navBtn;

    private View.OnClickListener startClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        Navigation.findNavController(v).navigate(R.id.start_to_list);

        }
    };

    public StartFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_start, container, false);
        navBtn = rootview.findViewById(R.id.btn_start);
        navBtn.setOnClickListener(startClickListener);

        return rootview;
    }


}
