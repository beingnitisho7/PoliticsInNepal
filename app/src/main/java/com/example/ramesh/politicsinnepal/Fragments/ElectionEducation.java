package com.example.ramesh.politicsinnepal.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ramesh.politicsinnepal.Adapters.EducationAdapter;
import com.example.ramesh.politicsinnepal.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ElectionEducation.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ElectionEducation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ElectionEducation extends Fragment {

    ListView educationList;

    FragmentManager fragmentmanager;
    FragmentTransaction fragmenttransaction;


    String[] educationItem ={

            "भिडियो हेर्नुहोस्",
            "तस्वीरहरु हेर्नुहोस्",
            "मतपेटिका को नमूना",
            "मतदान गर्न विधि",
            "किन मतहरू खराब हुन्छ???",
            "तपाईंको क्षेत्रका उम्मेदवारहरू चिन्नुहाेस्",
    };


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ElectionEducation() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ElectionEducation.
     */
    // TODO: Rename and change types and number of parameters
    public static ElectionEducation newInstance(String param1, String param2) {
        ElectionEducation fragment = new ElectionEducation();
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

        getActivity().setTitle("चुनाव सम्बन्धी शिक्षा");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_election_education, container, false);

        EducationAdapter educationAdapter = new EducationAdapter(this.getActivity(),educationItem);
       educationList = (ListView)v.findViewById(R.id.educationList);
        educationList.setAdapter(educationAdapter);

        educationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

//                Toast.makeText(getActivity(), String.valueOf(position), Toast.LENGTH_LONG).show();

                EducationContents educationContents = new EducationContents();
                fragmentmanager = getActivity().getSupportFragmentManager();
                fragmenttransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmenttransaction.replace(R.id.containerView, educationContents);
                fragmenttransaction.commit();

                Bundle args = new Bundle();
                args.putString("position", String.valueOf(position));
                educationContents.setArguments(args);
            }
        });

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
