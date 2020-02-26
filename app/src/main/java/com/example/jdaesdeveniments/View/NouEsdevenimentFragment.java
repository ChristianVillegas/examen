package com.example.jdaesdeveniments.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.jdaesdeveniments.R;
import com.example.jdaesdeveniments.ViewModel.NouEsdevenimentViewModel;

public class NouEsdevenimentFragment extends Fragment {

    private NouEsdevenimentViewModel nouEsdevenimentViewModel;

    private EditText nombreDetailEditText;
    private EditText organizadorEditText;
    private EditText salaEditText;
    private EditText precioEditText;
    private EditText aforoEditText;
    private EditText descripcionEditText;
    private EditText fechaDetailEditText;
    private EditText lugarDetailEditText;
    private Button cancelarButton;
    private Button confirmarButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        nouEsdevenimentViewModel =
                ViewModelProviders.of(this).get(NouEsdevenimentViewModel.class);
        final View ui_layout = inflater.inflate(R.layout.fragment_nou_esdeveniment, container, false);
        final TextView textView = ui_layout.findViewById(R.id.nav_slideshow);

        nombreDetailEditText = ui_layout.findViewById(R.id.nombreDetailEditText);
        organizadorEditText = ui_layout.findViewById(R.id.organizadorEditText);
        salaEditText = ui_layout.findViewById(R.id.salaEditText);
        precioEditText = ui_layout.findViewById(R.id.precioEditText);
        aforoEditText = ui_layout.findViewById(R.id.aforoEditText);
        descripcionEditText = ui_layout.findViewById(R.id.descripcionEditText);
        fechaDetailEditText = ui_layout.findViewById(R.id.fechaDetailEditText);
        lugarDetailEditText = ui_layout.findViewById(R.id.lugarDetailEditText);
        cancelarButton = ui_layout.findViewById(R.id.cancelarButton);
        confirmarButton = ui_layout.findViewById(R.id.confirmarButton);


        confirmarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nouEsdevenimentViewModel.addEsdeveniment(nombreDetailEditText.getText().toString(), fechaDetailEditText.getText().toString(),
                        lugarDetailEditText.getText().toString(), organizadorEditText.getText().toString(), salaEditText.getText().toString(),
                        descripcionEditText.getText().toString(), precioEditText.getText().toString(), aforoEditText.getText().toString());
            }
        });

        cancelarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return ui_layout;
    }
}