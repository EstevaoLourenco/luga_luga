package com.senai.lugaluga.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.senai.lugaluga.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SolicitacaoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SolicitacaoFragment extends Fragment {

    public SolicitacaoFragment() {
        // Required empty public constructor
    }

    public static SolicitacaoFragment newInstance(String param1, String param2) {
        SolicitacaoFragment fragment = new SolicitacaoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_solicitacao, container, false);

        return view;
    }
}