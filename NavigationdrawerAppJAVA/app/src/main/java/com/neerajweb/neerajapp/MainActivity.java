package com.neerajweb.neerajapp;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.view.GestureDetector;

import com.neerajweb.neerajapp.model.CardModel;
import com.neerajweb.neerajapp.model.RecycleViewNavigation;
import com.neerajweb.neerajapp.view.CardContainer;
import com.neerajweb.neerajapp.view.SimpleCardStackAdapter;


public class MainActivity extends AppCompatActivity {

    private CardContainer mCardContainer;
    private RecycleViewNavigation mRecycleViewNavigation;

    //First We Declare Titles And Icons For Our Navigation Drawer List View
    //This Icons And Titles Are holded in an Array as you can see
    /*
    String TITLES[] = {"Home","Events","Mail","Shop","Travel"};
    int ICONS[] = {R.drawable.ic_home
            ,R.drawable.ic_event
            ,R.drawable.ic_email
            ,R.drawable.ic_shop
            ,R.drawable.ic_travel};
    */

    String TITLES[] = {"Home","Lakshaya Community GuideLines"
            ,"General Information","Maintenance","Leisure Facilities"
            ,"Laundry Facilities","Safety and Security","Common Areas"
            ,"Parking","Homeowner Association","Residents Photo Album"
            ,"Utilities","Lakshaya Events","Important Phone Numbers"
            ,"Maps","Post and comments","Renters"
            ,"Rules & Regulations","Reviews & Testimonials","Contact Us","About Us"
    };
    int ICONS[] = {R.drawable.ic_home
            ,R.drawable.ic_lakshayacommunityguidelines
            ,R.drawable.ic_generalinformation
            ,R.drawable.ic_maintenance
            ,R.drawable.ic_leisurefacilities
            ,R.drawable.ic_laundry
            ,R.drawable.ic_safetyandsecurity
            ,R.drawable.ic_commonareas
            ,R.drawable.ic_parking
            ,R.drawable.ic_homeownerassociation
            ,R.drawable.ic_residentsphotoalbum
            ,R.drawable.ic_utilities
            ,R.drawable.ic_lakshayaevents
            ,R.drawable.ic_importantphonenumbers
            ,R.drawable.ic_maps
            ,R.drawable.ic_postandcomments
            ,R.drawable.ic_renters
            ,R.drawable.ic_rulesandregulations
            ,R.drawable.ic_reviewsandtestimonials
            ,R.drawable.ic_contactus
            ,R.drawable.ic_aboutus
    };

    //Similarly we Create a String Resource for the name and email in the header view
    //And we also create a int resource for profile picture in the header view

    String NAME = "Neeraj Goswami";
    String EMAIL = "Neeraj.login@gmail.com";
    int PROFILE = R.drawable.neeraj;

    private Toolbar toolbar;                              // Declaring the Toolbar Object

    RecyclerView mRecyclerView;                           // Declaring RecyclerView
    RecyclerView.Adapter mAdapter;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager
    DrawerLayout Drawer;                                  // Declaring DrawerLayout

    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            Card Implementation Start from here
        */
        mCardContainer = (CardContainer) findViewById(R.id.layoutview);
        Resources r = getResources();

        SimpleCardStackAdapter adapter = new SimpleCardStackAdapter(this);

        adapter.add(new CardModel("Neeraj Goswami", "F3 New Delhi", r.getDrawable(R.drawable.picture1)));
        adapter.add(new CardModel("Neeraj Goswami", "F2 New Delhi", r.getDrawable(R.drawable.picture2)));
        adapter.add(new CardModel("Pradeep", "Description goes here", r.getDrawable(R.drawable.picture3)));
        adapter.add(new CardModel("Ankush", "Description goes here", r.getDrawable(R.drawable.picture1)));
        adapter.add(new CardModel("Kunal Dhawan", "Description goes here", r.getDrawable(R.drawable.picture2)));
        adapter.add(new CardModel("Neeraj Goswami", "F3 New Delhi", r.getDrawable(R.drawable.picture3)));
        adapter.add(new CardModel("Neeraj Goswami", "F3 New Delhi", r.getDrawable(R.drawable.picture1)));
        adapter.add(new CardModel("Neeraj Goswami", "F2 New Delhi", r.getDrawable(R.drawable.picture2)));
        adapter.add(new CardModel("Pradeep", "Description goes here", r.getDrawable(R.drawable.picture3)));
        adapter.add(new CardModel("Ankush", "Description goes here", r.getDrawable(R.drawable.picture1)));
        adapter.add(new CardModel("Title5", "Description goes here", r.getDrawable(R.drawable.picture2)));
        adapter.add(new CardModel("Title6", "Description goes here", r.getDrawable(R.drawable.picture3)));
        adapter.add(new CardModel("Title1", "Description goes here", r.getDrawable(R.drawable.neeraj)));
        adapter.add(new CardModel("Neeraj Goswami", "F2 New Delhi", r.getDrawable(R.drawable.picture2)));
        adapter.add(new CardModel("Pradeep", "Description goes here", r.getDrawable(R.drawable.picture3)));
        adapter.add(new CardModel("Title4", "Description goes here", r.getDrawable(R.drawable.picture1)));
        adapter.add(new CardModel("Title5", "Description goes here", r.getDrawable(R.drawable.picture2)));
        adapter.add(new CardModel("Title6", "Description goes here", r.getDrawable(R.drawable.picture3)));
        adapter.add(new CardModel("Title1", "Description goes here", r.getDrawable(R.drawable.neeraj)));
        adapter.add(new CardModel("Neeraj Goswami", "F2 New Delhi", r.getDrawable(R.drawable.picture2)));
        adapter.add(new CardModel("Pradeep", "Description goes here", r.getDrawable(R.drawable.picture3)));
        adapter.add(new CardModel("Title4", "Description goes here", r.getDrawable(R.drawable.picture1)));
        adapter.add(new CardModel("Title5", "Description goes here", r.getDrawable(R.drawable.picture2)));
        adapter.add(new CardModel("Title6", "Description goes here", r.getDrawable(R.drawable.picture3)));
        adapter.add(new CardModel("Neeraj Goswami", "F3 New Delhi", r.getDrawable(R.drawable.picture1)));
        adapter.add(new CardModel("Neeraj Goswami", "F2 New Delhi", r.getDrawable(R.drawable.picture2)));
        adapter.add(new CardModel("Title3", "Description goes here", r.getDrawable(R.drawable.picture3)));
        adapter.add(new CardModel("Title4", "Description goes here", r.getDrawable(R.drawable.picture1)));
        adapter.add(new CardModel("Title5", "Description goes here", r.getDrawable(R.drawable.neeraj)));


        CardModel cardModel = new CardModel("Title1", "Description goes here", r.getDrawable(R.drawable.picture1));
        cardModel.setOnClickListener(new CardModel.OnClickListener() {
            @Override
            public void OnClickListener() {
                Log.i("Swipeable Cards", "I am pressing the card");
            }
        });

        cardModel.setOnCardDismissedListener(new CardModel.OnCardDismissedListener() {
            @Override
            public void onLike() {
                Log.i("Swipeable Cards","I like the card");
            }

            @Override
            public void onDislike() {
                Log.i("Swipeable Cards","I dislike the card");
            }
        });

        adapter.add(cardModel);
        mCardContainer.setAdapter(adapter);

        /*
            Card Implementation End here
        */

        /* Assinging the toolbar object ot the view and setting the the Action bar to our toolbar*/
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView); // Assigning the RecyclerView Object to the xml View

        mRecyclerView.setHasFixedSize(true);
                                 // Letting the system know that the list objects are of fixed size
        mRecycleViewNavigation = new RecycleViewNavigation();
        mAdapter = new MyAdapter(mRecycleViewNavigation,TITLES,ICONS,NAME,EMAIL,PROFILE);      // Creating the Adapter of MyAdapter class(which we are going to see in a bit)
        mRecyclerView.setAdapter(mAdapter);                             // Setting the adapter to RecyclerView

        mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager

        mRecyclerView.setLayoutManager(mLayoutManager);                 // Setting the layout Manager

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, mRecyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Drawer.closeDrawer(mRecyclerView);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));



        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);        // Drawer object Assigned to the view

        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                setTitle(mRecycleViewNavigation.getTitle());
                // Code here will execute once drawer is closed
            }
        }; // Drawer Toggle Object Made
        Drawer.setDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle
        mDrawerToggle.syncState();               // Finally we set the drawer toggle sync State
    }



    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
