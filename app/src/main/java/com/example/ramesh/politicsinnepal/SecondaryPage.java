package com.example.ramesh.politicsinnepal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ramesh.politicsinnepal.Fragments.CandidateDetails;
import com.example.ramesh.politicsinnepal.Fragments.CitizenPolls;
import com.example.ramesh.politicsinnepal.Fragments.EducationContents;
import com.example.ramesh.politicsinnepal.Fragments.ElectionEducation;
import com.example.ramesh.politicsinnepal.Fragments.PartyCandidateType;
import com.example.ramesh.politicsinnepal.Fragments.PartyCandidates;
import com.example.ramesh.politicsinnepal.Fragments.PartyElectionType;
import com.example.ramesh.politicsinnepal.Fragments.PartyInformation;
import com.example.ramesh.politicsinnepal.Fragments.Search;


public class SecondaryPage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, CandidateDetails.OnFragmentInteractionListener,EducationContents.OnFragmentInteractionListener, PartyCandidateType.OnFragmentInteractionListener, PartyElectionType.OnFragmentInteractionListener, Search.OnFragmentInteractionListener, ElectionEducation.OnFragmentInteractionListener, CitizenPolls.OnFragmentInteractionListener, PartyCandidates.OnFragmentInteractionListener, PartyInformation.OnFragmentInteractionListener {

    int pos;

    FragmentManager fragmentmanager;
    FragmentTransaction fragmenttransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary_page);


        Intent intent = getIntent();

        pos = intent.getIntExtra("pos", 0);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        if (pos == 0) {

            partyCandidates();
        }

        if (pos == 1) {

            partyInformation();
        }

        if (pos == 2) {

            electionEducation();
        }

        if (pos == 3) {

            citizenPolls();
        }


    }

    @Override
    public void onBackPressed() {
        this.getFragmentManager().popBackStack();


        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
            return;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);


        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //  getMenuInflater().inflate(R.menu.secondary_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            Search search = new Search();
            fragmentmanager = getSupportFragmentManager();
            fragmenttransaction = getSupportFragmentManager().beginTransaction();
            fragmenttransaction.replace(R.id.containerView, search);
            fragmenttransaction.commit();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.homePage) {
            Intent secondPage;
            secondPage = new Intent(SecondaryPage.this, HomePage.class);
            startActivity(secondPage);

            // Handle the camera action
        } else if (id == R.id.partyCandidates) {
            partyCandidates();


        } else if (id == R.id.partyInfo) {
            partyInformation();

        } else if (id == R.id.electionEdu) {
            electionEducation();

        } else if (id == R.id.citizensPoll) {
            citizenPolls();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void partyCandidates() {
        PartyElectionType partyElectionType = new PartyElectionType();

        fragmentmanager = getSupportFragmentManager();
        fragmenttransaction = getSupportFragmentManager().beginTransaction();
        fragmenttransaction.replace(R.id.containerView, partyElectionType);
        fragmenttransaction.commit();

    }

    public void electionEducation() {
        ElectionEducation electionEducation = new ElectionEducation();
        fragmentmanager = getSupportFragmentManager();
        fragmenttransaction = getSupportFragmentManager().beginTransaction();
        fragmenttransaction.replace(R.id.containerView, electionEducation);
        fragmenttransaction.commit();


    }

    public void partyInformation() {
        PartyInformation partyInformation = new PartyInformation();
        fragmentmanager = getSupportFragmentManager();
        fragmenttransaction = getSupportFragmentManager().beginTransaction();
        fragmenttransaction.replace(R.id.containerView, partyInformation);
        fragmenttransaction.commit();


    }

    public void citizenPolls() {
        CitizenPolls citizenPolls = new CitizenPolls();
        fragmentmanager = getSupportFragmentManager();
        fragmenttransaction = getSupportFragmentManager().beginTransaction();
        fragmenttransaction.replace(R.id.containerView, citizenPolls);
        fragmenttransaction.commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
