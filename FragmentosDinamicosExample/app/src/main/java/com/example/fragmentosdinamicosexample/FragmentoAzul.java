package com.example.fragmentosdinamicosexample;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentoAzul#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoAzul extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText lbl1, lbl2;
    private Button btnMul;
    private View vista;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentoAzul() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentoAzul.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentoAzul newInstance(String param1, String param2) {
        FragmentoAzul fragment = new FragmentoAzul();
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
        vista = inflater.inflate(R.layout.fragment_fragmento_azul, container, false);

        lbl1 = (EditText) vista.findViewById(R.id.mul1);
        lbl2 = (EditText) vista.findViewById(R.id.mul2);
        btnMul = (Button) vista.findViewById(R.id.btnMulti);

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numero1 = Integer.parseInt(lbl1.getText().toString());
                int numero2 = Integer.parseInt(lbl2.getText().toString());
                int multi = numero1 * numero2;

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Resultado");
                builder.setMessage("El resultado de la multiplicación es: "+ multi);
                builder.setPositiveButton("Aceptar", null);
                builder.create();
                builder.show();
            }
        });

        // Inflate the layout for this fragment
        return vista;
    }
}
