package com.example.lab5_ph34899;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.tooolbar);
        DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.navitionView);

        //set toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //set navi
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(MainActivity.this,drawerLayout, toolbar, R.string.open, R.string.close );
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                if (item.getItemId()==R.id.dauTrang){
                    fragment=new dauTrang();
                }else {
                    fragment=new setting();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fm_layout, fragment).commit();
                drawerLayout.close();
                return true;
            }
        });
    }


}