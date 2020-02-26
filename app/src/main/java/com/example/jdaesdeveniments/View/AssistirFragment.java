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
import com.example.jdaesdeveniments.ViewModel.AssistirViewModel;
import com.example.jdaesdeveniments.ViewModel.DetallEsdevenimentViewModel;

public class AssistirFragment extends Fragment {

    private AssistirViewModel assistirViewModel;

    private Button button;
    private Button button2;

    public static AssistirFragment newInstance() {
        return new AssistirFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        assistirViewModel =
                ViewModelProviders.of(this).get(AssistirViewModel.class);
        final View ui_layout = inflater.inflate(R.layout.assistir_fragment, container, false);
        final TextView textView = ui_layout.findViewById(R.id.nav_gallery);

        button = ui_layout.findViewById(R.id.button);
        button2 = ui_layout.findViewById(R.id.button2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return ui_layout;
    }

}
