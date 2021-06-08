package com.entertech.edevn.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.entertech.edevn.Activity.FreeLiveClassActivity;
import com.entertech.edevn.R;


public class LiveClassFragment extends Fragment {

    private View view;
    private CardView liveClassDetailsId;
    public LiveClassFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_live_class, container, false);
         liveClassDetailsId = view.findViewById(R.id.live_class_details_Id);

         liveClassDetailsId.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(getContext(), FreeLiveClassActivity.class);
                 startActivity(intent);
             }
         });

         return view;
    }
}