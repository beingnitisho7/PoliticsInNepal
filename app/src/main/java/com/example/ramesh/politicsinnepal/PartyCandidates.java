package com.example.ramesh.politicsinnepal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PartyCandidates.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PartyCandidates#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PartyCandidates extends Fragment {

    Spinner sStates, sDistricts;
    String[] district_State0;
    String[] district_State1;
    String[] district_state2;
    String[] district_state3;
    String[] district_state4;
    String[] district_state5;
    String[] district_state6;
    String[] district_state7;

    ArrayAdapter<String> items_0;
    ArrayAdapter<String> items_1;
    ArrayAdapter<String> items_2;
    ArrayAdapter<String> items_3;
    ArrayAdapter<String> items_4;
    ArrayAdapter<String> items_5;
    ArrayAdapter<String> items_6;
    ArrayAdapter<String> items_7;

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

        String election_value = getArguments().getString("from_election");
        String candidate_value = getArguments().getString("from_candidate");


       // Toast.makeText(getActivity(), election_value + " " +candidate_value, Toast.LENGTH_LONG).show();

        getActivity().setTitle(election_value + " " +candidate_value);
        this.setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_party_candidates, container, false);



        district_State0 = getResources().getStringArray(R.array.empty);
        district_State1 = getResources().getStringArray(R.array.state1_districts);
        district_state2 = getResources().getStringArray(R.array.state2_districts);
        district_state3 = getResources().getStringArray(R.array.state3_districts);
        district_state4 = getResources().getStringArray(R.array.state4_districts);
        district_state5 = getResources().getStringArray(R.array.state5_districts);
        district_state6 = getResources().getStringArray(R.array.state6_districts);
        district_state7 = getResources().getStringArray(R.array.state7_districts);


        txt_area = (TextView) v.findViewById(R.id.area_text);
        txt_dist = (TextView) v.findViewById(R.id.dist_text);

        sDistricts = (Spinner) v.findViewById(R.id.spinnerDistrict);

        sStates = (Spinner) v.findViewById(R.id.spinnerStates);

        items_0 = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, district_State1);

        items_1 = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, district_State1);


        items_2 = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, district_state2);

        items_3 = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, district_state3);

        items_4 = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, district_state4);

        items_5 = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, district_state5);

        items_6 = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, district_state6);

        items_7 = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_spinner_dropdown_item, district_state7);


        sStates.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            String result;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {


                result = parent.getItemAtPosition(pos).toString();
                int count = pos;


//                Toast.makeText(getActivity(), String.valueOf(count), Toast.LENGTH_LONG).show();
                if (count == 0) {
                    txt_dist.setVisibility(View.INVISIBLE);
                    sDistricts.setVisibility(View.INVISIBLE);
                    sDistricts.setAdapter(items_0);
                }

                if (count == 1 || count == 2 || count == 3 || count == 4 || count == 5 || count == 6 || count == 7) {
                    makevisible();
                }

                if (count == 1) {

                    sDistricts.setAdapter(items_1);
                }

                if (count == 2) {

                    sDistricts.setAdapter(items_2);
                }

                if (count == 3) {

                    sDistricts.setAdapter(items_3);
                }
                if (count == 4) {

                    sDistricts.setAdapter(items_4);
                }
                if (count == 5) {

                    sDistricts.setAdapter(items_5);
                }
                if (count == 6) {
                    sDistricts.setAdapter(items_6);
                }
                if (count == 7) {

                    sDistricts.setAdapter(items_7);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return v;
    }

    public void makevisible() {
        txt_dist.setVisibility(View.VISIBLE);
        sDistricts.setVisibility(View.VISIBLE);
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
