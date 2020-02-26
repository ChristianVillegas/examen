package com.example.jdaesdeveniments.View;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jdaesdeveniments.Model.Assistent;
import com.example.jdaesdeveniments.R;
import com.example.jdaesdeveniments.ViewModel.LlistaAssistentsViewModel;
import com.example.jdaesdeveniments.ViewModel.LlistatEsdevenimentViewModel;

import java.util.List;

public class LlistaAssistentsFragment extends Fragment {

    private LlistaAssistentsViewModel llistaAssistentsViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public static LlistaAssistentsFragment newInstance() {
        return new LlistaAssistentsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View ui_layout = inflater.inflate(R.layout.llista_assistents_fragment, container, false);

        llistaAssistentsViewModel = ViewModelProviders.of(this).get(LlistaAssistentsViewModel.class);

        recyclerView =ui_layout.findViewById(R.id.recyclerRoom);
        mAdapter = new Adapter(LlistatEsdevenimentViewModel.getLista_assistents());

        recyclerView.setAdapter(mAdapter);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        return ui_layout;
    }


    public class RoomHolder extends RecyclerView.ViewHolder{
        TextView nombre;
        TextView mail;

        public RoomHolder(@NonNull View itemView) {
            super(itemView);

            nombre = (TextView)itemView.findViewById(R.id.tv_nombre);
            mail = (TextView)itemView.findViewById(R.id.tv_mail);

        }
    }

    public class Adapter extends RecyclerView.Adapter<RoomHolder>{

        private List<Assistent> lista_assistents;


        public Adapter(List<Assistent> lista_assistents){

            this.lista_assistents = lista_assistents;

        }


        @NonNull
        @Override
        public RoomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new RoomHolder(getLayoutInflater().inflate(R.layout.holder_postgres, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull RoomHolder holder, int position) {
            holder.nombre.setText(lista_assistents.get(position).getNombre());
            holder.mail.setText(lista_assistents.get(position).getMail());
        }

        @Override
        public int getItemCount() {
            return lista_assistents.size();
        }
    }

}
