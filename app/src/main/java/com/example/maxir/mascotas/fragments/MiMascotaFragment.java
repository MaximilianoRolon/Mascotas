package com.example.maxir.mascotas.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maxir.mascotas.R;
import com.example.maxir.mascotas.adapters.MiMascotaAdapter;
import com.example.maxir.mascotas.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MiMascotaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MiMascotaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MiMascotaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Mascota> mascotas;
    MiMascotaAdapter viewAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    final int COLUMNS_NUMBER = 3;

    public MiMascotaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MiMascotaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MiMascotaFragment newInstance(String param1, String param2) {
        MiMascotaFragment fragment = new MiMascotaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_mi_mascota, container, false);
        recyclerView = view.findViewById(R.id.mi_mascota_recycler_view);
        recyclerView.setHasFixedSize(false);
        // set DataSet mascotas
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(6,"Flamingo", 3, R.drawable.flamingo));
        mascotas.add(new Mascota(7,"Flamingo", 4, R.drawable.flamingo));
        mascotas.add(new Mascota(8,"Flamingo", 1, R.drawable.flamingo));
        mascotas.add(new Mascota(9,"Flamingo", 10, R.drawable.flamingo));
        mascotas.add(new Mascota(10,"Flamingo", 9, R.drawable.flamingo));
        mascotas.add(new Mascota(11,"Flamingo", 8, R.drawable.flamingo));
        mascotas.add(new Mascota(12,"Flamingo", 1, R.drawable.flamingo));
        mascotas.add(new Mascota(13,"Flamingo", 8, R.drawable.flamingo));
        mascotas.add(new Mascota(14,"Flamingo", 3, R.drawable.flamingo));
        layoutManager = new GridLayoutManager(getContext(), COLUMNS_NUMBER);
        recyclerView.setLayoutManager(layoutManager);
        viewAdapter = new MiMascotaAdapter(mascotas);
        recyclerView.setAdapter(viewAdapter);
        return view;
    }

}
