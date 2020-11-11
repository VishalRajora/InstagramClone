package com.example.instagramclone;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.instagramclone.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView camra , send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        toolbar=findViewById ( R.id.instaToolBar );
        setSupportActionBar ( toolbar );
        camra = toolbar.findViewById ( R.id.camra_toolbar );
        send=toolbar.findViewById ( R.id.send_toolbar );

        camra.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText ( MainActivity.this , "Camera Click" , Toast.LENGTH_SHORT ).show ();
            }
        } );


        BottomNavigationView navView = findViewById ( R.id.nav_view );
        NavController navController = Navigation.findNavController ( this , R.id.nav_host_fragment );

        navView.setOnNavigationItemSelectedListener ( new BottomNavigationView.OnNavigationItemSelectedListener () {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId () == R.id.navigation_home )
                {
                    HomeFragment homeFragment =  new HomeFragment ();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager ().beginTransaction (); //fragment chlaane k liy
                    fragmentTransaction.replace ( R.id.nav_host_fragment , homeFragment ); // kha hme replace krwana h apne fragment ko wha k id plus kiska replace krwana h wha k id
                    fragmentTransaction.commit ();
                }
                else  if(item.getItemId () == R.id.navigation_search )
                {
                    Toast.makeText ( MainActivity.this , "Search functionality coming soon" , Toast.LENGTH_SHORT ).show ();
                }
                else  if(item.getItemId () == R.id.navigation_Addd )
                {
                    Toast.makeText ( MainActivity.this , "Add functionality coming soon" , Toast.LENGTH_SHORT ).show ();
                }
                else  if(item.getItemId () == R.id.navigation_notifications )
                {
                    Toast.makeText ( MainActivity.this , "Notification functionality coming soon" , Toast.LENGTH_SHORT ).show ();
                }
                else  if(item.getItemId () == R.id.navigation_user )
                {
                    Toast.makeText ( MainActivity.this , "user functionality coming soon" , Toast.LENGTH_SHORT ).show ();
                }
                return true;
            }
        } );

    }

}