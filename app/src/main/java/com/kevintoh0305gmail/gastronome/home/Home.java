package com.kevintoh0305gmail.gastronome.home;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.kevintoh0305gmail.gastronome.R;
import com.kevintoh0305gmail.gastronome.SharedGlobals;
import com.kevintoh0305gmail.gastronome.log.LogFragment;

public class Home extends AppCompatActivity {
    static SharedGlobals globals;
    FirebaseDatabase firebaseDatabase;
    FirebaseUser user;
    TextView text;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //firebaseDatabase = FirebaseDatabase.getInstance();
        //firebaseDatabase.setPersistenceEnabled(true);
        //user = FirebaseAuth.getInstance().getCurrentUser();
        //text = findViewById(R.id.tvHomePlaceHolder);
        bottomNavigationView = findViewById(R.id.bottom_nav_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        //The home fragment is the default fragment shown when the activity is first loaded.
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LogFragment()).commit();
        //Retrieving user information from Firebase
        //DatabaseReference reference = firebaseDatabase.getReference("Users/"+user.getUid());
        //reference.addValueEventListener(new ValueEventListener() {
        //   @Override
        //    public void onDataChange(DataSnapshot dataSnapshot) {
        //        globals.setCurrentUser(dataSnapshot.getValue(User.class));
        //    }

        //   @Override
        //   public void onCancelled(DatabaseError databaseError) {
        //        Log.d("onCancelled error","Retrieval of user data failed");
        //    }
        //});
    }

    //Handles the transition of fragments when a navigation item is selected from the bottom navigation bar.
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch(menuItem.getItemId()){
                        case R.id.nav_today:
                            selectedFragment = new LogFragment();
                            break;
                        case R.id.nav_feed:
                            selectedFragment = new FeedFragment();
                            break;
                        case R.id.nav_add:
                            selectedFragment = new AddCustomRecipeFragment();
                            break;
                        case R.id.nav_profile:
                            selectedFragment = new ProfileFragment();
                            break;
                        case R.id.nav_progress:
                            selectedFragment = new StatisticsFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };
}
