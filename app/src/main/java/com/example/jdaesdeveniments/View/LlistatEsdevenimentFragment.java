package com.example.jdaesdeveniments.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jdaesdeveniments.Model.Esdeveniment;
import com.example.jdaesdeveniments.R;
import com.example.jdaesdeveniments.ViewModel.LlistatEsdevenimentViewModel;

import java.util.ArrayList;
import java.util.List;

public class LlistatEsdevenimentFragment extends Fragment {

    private LlistatEsdevenimentViewModel llistatEsdevenimentViewModel;

    private RecyclerView recyclerView;
    private PostgresAdapter miAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public static LlistatEsdevenimentFragment newInstance() {
        return new LlistatEsdevenimentFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View ui_layout = inflater.inflate(R.layout.fragment_llistat_esdeveniment, container, false);

        llistatEsdevenimentViewModel = ViewModelProviders.of(this).get(LlistatEsdevenimentViewModel.class);

        recyclerView = ui_layout.findViewById(R.id.recyclerRoom);

        llistatEsdevenimentViewModel.getListEsdeveniment().observe(getViewLifecycleOwner(), new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> strings) {
                miAdapter = new PostgresAdapter(strings);
                recyclerView.setAdapter(miAdapter);
            }
        });

        // use a linear layout manager. Con el LinearLayout le indico al recycler que se pinte en linea. Existen otras formas
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        return ui_layout;
    }

    // Antes que la clase Adapter, creo la clase Holder
    public class IncidentViewHolder extends RecyclerView.ViewHolder{
        TextView nombre;
        TextView fecha;
        TextView lugar;


        public IncidentViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = (TextView)itemView.findViewById(R.id.tv_nombre);
            fecha = (TextView)itemView.findViewById(R.id.tv_fecha);
            lugar = (TextView)itemView.findViewById(R.id.tv_lugar);
        }
    }

    public class PostgresAdapter extends RecyclerView.Adapter<IncidentViewHolder>{

        private List<Esdeveniment> list_esdeveniment;

        public PostgresAdapter(ArrayList<String> incidentsList) { // Creo un constructor
            this.list_esdeveniment = list_esdeveniment;
        }

        @NonNull
        @Override
        public IncidentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new IncidentViewHolder(getLayoutInflater().inflate(R.layout.holder_postgres, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull IncidentViewHolder holder, int position) {
            holder.nombre.setText(list_esdeveniment.get(position).getNombre());
            holder.fecha.setText((CharSequence) list_esdeveniment.get(position).getFecha());
            holder.lugar.setText(list_esdeveniment.get(position).getLugar());

        }

        @Override
        public int getItemCount() { return list_esdeveniment.size(); }
    }
}