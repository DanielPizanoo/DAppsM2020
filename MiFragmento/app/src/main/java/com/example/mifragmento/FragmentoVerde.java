package com.example.mifragmento;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentoVerde#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoVerde extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Button btn;
    private View vista;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentoVerde() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentoVerde.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentoVerde newInstance(String param1, String param2) {
        FragmentoVerde fragment = new FragmentoVerde();
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

        vista = inflater.inflate(R.layout.fragment_fragmento_verde, container, false);
        //Ligar el boton
        btn = (Button) vista.findViewById(R.id.btnEjemplo);

        //Creamos el listener
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Oprimiste el boton", Toast.LENGTH_SHORT).show();
            }
        });

        // Inflate the layout for this fragment
        return vista;
    }
}
