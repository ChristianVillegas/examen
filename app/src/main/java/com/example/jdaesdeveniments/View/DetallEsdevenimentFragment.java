package com.example.jdaesdeveniments.View;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.jdaesdeveniments.R;
import com.example.jdaesdeveniments.ViewModel.DetallEsdevenimentViewModel;
import com.example.jdaesdeveniments.ViewModel.NouEsdevenimentViewModel;

public class DetallEsdevenimentFragment extends Fragment {

    private DetallEsdevenimentViewModel detallEsdevenimentViewModel;

    private Button mensajesImageButton;
    private Button asistentesImageButton;
    private Button editImageButton;

    public static DetallEsdevenimentFragment newInstance() {
        return new DetallEsdevenimentFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        detallEsdevenimentViewModel =
                ViewModelProviders.of(this).get(DetallEsdevenimentViewModel.class);
        final View ui_layout = inflater.inflate(R.layout.detall_esdeveniment_fragment, container, false);
        final TextView textView = ui_layout.findViewById(R.id.nav_gallery);

        mensajesImageButton = ui_layout.findViewById(R.id.mensajesImageButton);
        asistentesImageButton = ui_layout.findViewById(R.id.asistentesImageButton);
        editImageButton = ui_layout.findViewById(R.id.editImageButton);


        mensajesImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        asistentesImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // getActivity().getSupportFragmentManager().beginTransaction().replace(
              //          R.id.MainActivity, new AssistirFragment()).commit();
            }
        });

        editImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return ui_layout;
    }

}
