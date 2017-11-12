package com.example.ramesh.politicsinnepal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EducationContents.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EducationContents#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EducationContents extends Fragment {


    Button vid1,vid2,vid3,vid4;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public EducationContents() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EducationContents.
     */
    // TODO: Rename and change types and number of parameters
    public static EducationContents newInstance(String param1, String param2) {
        EducationContents fragment = new EducationContents();
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

        getActivity().setTitle("चुनाव सम्बन्धित भिडियोहरू");

        String contentPosition = getArguments().getString("position");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_education_contents, container, false);

            vid1 = (Button)v.findViewById(R.id.video1);
            vid2 = (Button)v.findViewById(R.id.video2);
            vid3 = (Button)v.findViewById(R.id.video3);
            vid4 = (Button)v.findViewById(R.id.video4);

            vid1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // TODO Auto-generated method stub
                    String video_path = "https://www.youtube.com/watch?v=hQJzslF4ajg";
                    Uri uri = Uri.parse(video_path);
                    uri = Uri.parse("vnd.youtube:"  + uri.getQueryParameter("v"));

                    Intent intent = new Intent(Intent.ACTION_VIEW , uri);
                    startActivity(intent);
                }
            });

        vid2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                String video_path = "https://www.youtube.com/watch?v=Tm8LGxTLtQk";
                Uri uri = Uri.parse(video_path);
                uri = Uri.parse("vnd.youtube:"  + uri.getQueryParameter("v"));

                Intent intent = new Intent(Intent.ACTION_VIEW , uri);
                startActivity(intent);
            }
        });

        vid3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                String video_path = "https://www.youtube.com/watch?v=7SaM24Cjzj0";
                Uri uri = Uri.parse(video_path);
                uri = Uri.parse("vnd.youtube:"  + uri.getQueryParameter("v"));

                Intent intent = new Intent(Intent.ACTION_VIEW , uri);
                startActivity(intent);
            }
        });


        vid4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                String video_path = "https://www.youtube.com/watch?v=a2cKbQODCGU";
                Uri uri = Uri.parse(video_path);
                uri = Uri.parse("vnd.youtube:"  + uri.getQueryParameter("v"));

                Intent intent = new Intent(Intent.ACTION_VIEW , uri);
                startActivity(intent);
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
