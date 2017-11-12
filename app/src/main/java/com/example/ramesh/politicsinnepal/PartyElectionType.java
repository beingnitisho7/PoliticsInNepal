package com.example.ramesh.politicsinnepal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PartyElectionType.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PartyElectionType#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PartyElectionType extends Fragment {

    FragmentManager fragmentmanager;
    FragmentTransaction fragmenttransaction;


    Button central;
    Button provience;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PartyElectionType() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PartyElectionType.
     */
    // TODO: Rename and change types and number of parameters
    public static PartyElectionType newInstance(String param1, String param2) {
        PartyElectionType fragment = new PartyElectionType();
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

        getActivity().setTitle("चुनावको प्रकार छान्नुहोस्:");

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_party_election_type, container, false);
        central = (Button)v.findViewById(R.id.election_central);
        provience = (Button)v.findViewById(R.id.election_provience);

        central.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PartyCandidateType partyCandidateType = new PartyCandidateType();
                fragmentmanager = getActivity().getSupportFragmentManager();
                fragmenttransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmenttransaction.replace(R.id.containerView, partyCandidateType);
                fragmenttransaction.commit();

                Bundle args = new Bundle();
                args.putString("value", "प्रतिनिधिसभाका");
                partyCandidateType.setArguments(args);
            }
        });

        provience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PartyCandidateType partyCandidateType = new PartyCandidateType();
                fragmentmanager = getActivity().getSupportFragmentManager();
                fragmenttransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmenttransaction.replace(R.id.containerView, partyCandidateType);
                fragmenttransaction.commit();

                Bundle args = new Bundle();
                args.putString("value", "राज्यसभाका");
                partyCandidateType.setArguments(args);
            }
        });


        return v;

    }


    public void onBackPressed()
    {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        fm.popBackStack();
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