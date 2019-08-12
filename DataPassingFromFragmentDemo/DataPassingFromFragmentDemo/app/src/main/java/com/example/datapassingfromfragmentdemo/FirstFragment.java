package com.example.datapassingfromfragmentdemo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    public interface OnCountChangeListener {
        void onCountChange(int count);
    }

    private int mCounter = 0;
    private OnCountChangeListener mListener;

    private static final String TAG = "CountChangeListener";


    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind( this,view );
        mListener = (OnCountChangeListener) getActivity();

    /*    Button btnIncrement = view.findViewById(R.id.btn_increment);
        Button btnDecrement = view.findViewById(R.id.btn_decrement);
        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCounter += 1;
                mListener.onCountChange(mCounter);
            }
        });
        btnDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCounter  -= 1;
                mListener.onCountChange(mCounter);
            }
        });*/
        return view;
    }

    @OnClick(R.id.btn_increment)
    public void increment(){
        mCounter += 1;
        mListener.onCountChange(mCounter);
    }
    @OnClick(R.id.btn_decrement)
    public void decrement(){
        mCounter  -= 1;
        mListener.onCountChange(mCounter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
