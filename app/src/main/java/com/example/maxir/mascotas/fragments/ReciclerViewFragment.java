package com.example.maxir.mascotas.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maxir.mascotas.R;
import com.example.maxir.mascotas.adapters.MascotasAdapter;
import com.example.maxir.mascotas.adapters.ViewPagerAdapter;
import com.example.maxir.mascotas.pojo.Mascota;

import java.util.ArrayList;


public class ReciclerViewFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter viewAdapter;
    ArrayList<Mascota> mascotas;


    public ReciclerViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReciclerViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ReciclerViewFragment newInstance(String param1, String param2) {
        ReciclerViewFragment fragment = new ReciclerViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recicler_view, container, false);
        recyclerView = view.findViewById(R.id.main_recycler_view);
        recyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        // set DataSet mascotas
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Gato", 5, R.drawable.gato));
        mascotas.add(new Mascota("Perro", 7, R.drawable.perro));
        mascotas.add(new Mascota("Flamingo", 10, R.drawable.flamingo));
        mascotas.add(new Mascota("Hamster", 7,R.drawable.hamster));
        mascotas.add(new Mascota("Mono", 2, R.drawable.mono));
        viewAdapter = new MascotasAdapter(mascotas);
        recyclerView.setAdapter(viewAdapter);
        return view;

    }

}
