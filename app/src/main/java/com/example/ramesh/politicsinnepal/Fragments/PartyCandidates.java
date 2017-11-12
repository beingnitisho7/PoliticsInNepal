package com.example.ramesh.politicsinnepal.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ramesh.politicsinnepal.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PartyCandidates.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PartyCandidates#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PartyCandidates extends Fragment {
    FragmentManager fragmentmanager;
    FragmentTransaction fragmenttransaction;


    Spinner sStates, sDistricts,sAreas;

    String provience,district,area;
    String election_value,candidate_value;
    int stateCount,districtCount;


    Button Submit;
    //District List

    String[] district_State0;
    String[] district_State1;
    String[] district_state2;
    String[] district_state3;
    String[] district_state4;
    String[] district_state5;
    String[] district_state6;
    String[] district_state7;


    ArrayAdapter<String> Ditems_0;
    ArrayAdapter<String> Ditems_1;
    ArrayAdapter<String> Ditems_2;
    ArrayAdapter<String> Ditems_3;
    ArrayAdapter<String> Ditems_4;
    ArrayAdapter<String> Ditems_5;
    ArrayAdapter<String> Ditems_6;
    ArrayAdapter<String> Ditems_7;

 //Area list
    String[] P0district0_Area;
    String[] P1district1_Area;
    String[] P2district1_Area;
    String[] P3district1_Area;
    String[] P1district2_Area;
    String[] P2district2_Area;
    String[] P3district2_Area;
    String[] P1district3_Area;
    String[] P2district3_Area;
    String[] P3district3_Area;

    ArrayAdapter<String> Aitems_0;
    ArrayAdapter<String> Aitems_1;
    ArrayAdapter<String> Aitems_2;
    ArrayAdapter<String> Aitems_3;
    ArrayAdapter<String> Aitems_4;
    ArrayAdapter<String> Aitems_5;
    ArrayAdapter<String> Aitems_6;
    ArrayAdapter<String> Aitems_7;
    ArrayAdapter<String> Aitems_8;
    ArrayAdapter<String> Aitems_9;


    TextView txt_dist, txt_area;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PartyCandidates() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PartyCandidates.
     */
    // TODO: Rename and change types and number of parameters
    public static PartyCandidates newInstance(String param1, String param2) {
        PartyCandidates fragment = new PartyCandidates();
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

        election_value = getArguments().getString("from_election");
        candidate_value = getArguments().getString("from_candidate");


       // Toast.makeText(getActivity(), election_value + " " +candidate_value, Toast.LENGTH_LONG).show();

        getActivity().setTitle(election_value + " " +candidate_value);
        this.setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_party_candidates, container, false);


        txt_area = v.findViewById(R.id.area_text);
        txt_dist =  v.findViewById(R.id.dist_text);
        Submit = v.findViewById(R.id.btnSubmit);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), election_value+":"+candidate_value+":"+provience+":"+district+":"+area, Toast.LENGTH_LONG).show();
                CandidateDetails candidateDetails = new CandidateDetails();
                fragmentmanager = getActivity().getSupportFragmentManager();
                fragmenttransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmenttransaction.replace(R.id.containerView, candidateDetails);
                fragmenttransaction.commit();

                Bundle args = new Bundle();
                args.putString("election_type", election_value);
                args.putString("candidate_type", candidate_value);
                args.putString("provience", provience);
                args.putString("district", district);
                args.putString("area", area);
                candidateDetails.setArguments(args);

            }
        });

        sDistricts = v.findViewById(R.id.spinnerDistrict);

        sStates =  v.findViewById(R.id.spinnerStates);
        sAreas =  v.findViewById(R.id.spinnerArea);


//For Districts
        district_State0 = getResources().getStringArray(R.array.empty);
        district_State1 = getResources().getStringArray(R.array.state1_districts);
        district_state2 = getResources().getStringArray(R.array.state2_districts);
        district_state3 = getResources().getStringArray(R.array.state3_districts);
        district_state4 = getResources().getStringArray(R.array.state4_districts);
        district_state5 = getResources().getStringArray(R.array.state5_districts);
        district_state6 = getResources().getStringArray(R.array.state6_districts);
        district_state7 = getResources().getStringArray(R.array.state7_districts);


        Ditems_0 = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, district_State1);

        Ditems_1 = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, district_State1);


        Ditems_2 = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, district_state2);

        Ditems_3 = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, district_state3);

        Ditems_4 = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, district_state4);

        Ditems_5 = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, district_state5);

        Ditems_6 = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, district_state6);

        Ditems_7 = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, district_state7);


        // For Areas
        P0district0_Area = getResources().getStringArray(R.array.empty);
        P1district1_Area = getResources().getStringArray(R.array.State1District1_area);
        P2district1_Area = getResources().getStringArray(R.array.State2District1_area);
        P3district1_Area = getResources().getStringArray(R.array.State3District1_area);
        P1district2_Area=getResources().getStringArray(R.array.State4District1_area);
        P2district2_Area=getResources().getStringArray(R.array.State5District1_area);
        P3district2_Area=getResources().getStringArray(R.array.State6District1_area);
        P1district3_Area=getResources().getStringArray(R.array.State7District1_area);
        P2district3_Area=getResources().getStringArray(R.array.State8District1_area);
        P3district3_Area=getResources().getStringArray(R.array.State9District1_area);


        Aitems_0 = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item,P0district0_Area);

        Aitems_1 = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, P1district1_Area);

        Aitems_2 = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, P2district1_Area);

        Aitems_3 = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, P3district1_Area);
        Aitems_4 = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item,   P1district2_Area);
        Aitems_5 = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, P2district2_Area);
        Aitems_6 = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, P3district2_Area);
        Aitems_7 = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, P1district3_Area);

        Aitems_8 = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, P2district3_Area);
        Aitems_9 = new ArrayAdapter<>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, P3district3_Area);


        sStates.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {



            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {


                provience = parent.getItemAtPosition(pos).toString();
                stateCount = pos;


               if (stateCount == 0) {
                    txt_dist.setVisibility(View.INVISIBLE);
                    sDistricts.setVisibility(View.INVISIBLE);
                    sDistricts.setAdapter(Ditems_0);
                }

                if (stateCount > 0) {

                    makevisibleDistrict();

                }

                if (stateCount == 1) {

                    statesOnclick();
                    sDistricts.setAdapter(Ditems_1);

                }

                if (stateCount == 2) {

                    sDistricts.setAdapter(Ditems_2);

                }

                if (stateCount == 3) {

                    sDistricts.setAdapter(Ditems_3);

                }
                if (stateCount == 4) {

                    sDistricts.setAdapter(Ditems_4);

                }
                if (stateCount == 5) {

                    sDistricts.setAdapter(Ditems_5);

                }
                if (stateCount == 6) {
                    sDistricts.setAdapter(Ditems_6);

                }
                if (stateCount == 7) {

                    sDistricts.setAdapter(Ditems_7);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if (sDistricts.getVisibility() == View.VISIBLE){

            sAreas.setVisibility(View.VISIBLE);
            statesOnclick();

            if(sAreas.getVisibility() == View.VISIBLE){
                sAreas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        area = parent.getItemAtPosition(pos).toString();
                        Toast.makeText(getActivity(),area,Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

            }
        }


        return v;
    }

    public void makevisibleDistrict() {
        txt_dist.setVisibility(View.VISIBLE);
        sDistricts.setVisibility(View.VISIBLE);
    }

    public void statesOnclick(){

        sDistricts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                district = parent.getItemAtPosition(pos).toString();
                districtCount = pos;

                if (districtCount == 0) {
                    txt_area.setVisibility(View.INVISIBLE);
                    sAreas.setVisibility(View.INVISIBLE);
                    sAreas.setAdapter(Aitems_0);
                }

                if (districtCount > 0) {
                    makevisibleArea();
                }

                if (stateCount == 1 && districtCount == 1) {

                    sAreas.setAdapter(Aitems_1);

                }

                if (stateCount == 1 && districtCount == 2) {

                    sAreas.setAdapter(Aitems_2);
                }

                if (stateCount == 1 && districtCount == 3) {

                    sAreas.setAdapter(Aitems_3);
                }
                if (stateCount == 2 && districtCount == 1) {

                    sAreas.setAdapter(Aitems_4);
                }
                if (stateCount == 2 && districtCount == 2) {

                    sAreas.setAdapter(Aitems_5);
                }
                if (stateCount == 2 && districtCount == 3) {

                    sAreas.setAdapter(Aitems_6);
                }
                if (stateCount == 3 && districtCount == 1) {

                    sAreas.setAdapter(Aitems_7);
                }
                if (stateCount == 3 && districtCount == 2) {

                    sAreas.setAdapter(Aitems_8);
                }
                if (stateCount == 3 && districtCount == 3) {

                    sAreas.setAdapter(Aitems_9);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void makevisibleArea() {
        txt_area.setVisibility(View.VISIBLE);
        sAreas.setVisibility(View.VISIBLE);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.secondary_page, menu);
        super.onCreateOptionsMenu(menu, inflater);

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
