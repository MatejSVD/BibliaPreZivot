package com.example.m.navigationdrawler22_6;

import android.app.ListActivity;
import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;




// toto mozem zmazat

import android.os.Bundle;

import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;






import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

// kostru som prebral z: https://www.youtube.com/watch?v=nwRxjJefcaI

public class MainActivity extends AppCompatActivity{


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FragmentManager FM;
    FragmentTransaction FT;



    // takto som opravil rotovanie obrazu
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }


    // toto skriva navigation bar

    //  @Override
    // public void onWindowFocusChanged(boolean hasFocus) {
    //   super.onWindowFocusChanged(hasFocus);
    //    View decorView = getWindow().getDecorView();
    //   if (hasFocus) {
    //       decorView.setSystemUiVisibility(
    //              View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    //                     | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    //                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    //                     | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
    //                    | View.SYSTEM_UI_FLAG_FULLSCREEN
    //                     | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    //  }


    // }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        //doplnil som 23_11_2017


  //      final TextView input = (TextView) findViewById(R.id.input);
//        input.setTextSize(28);




      //  final TextView textScale = (TextView)findViewById(R.id.textsize);


















//toto potrebujem k options menu
        //      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        //      setSupportActionBar(toolbar);

        //     FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //     fab.setOnClickListener(new View.OnClickListener() {
        //        @Override
        //         public void onClick(View view) {
        //          Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //                    .setAction("Action", null).show();
        //     }
        //    });


        // po tade


        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.stuff);

        FM = getSupportFragmentManager();
        FT = FM.beginTransaction();

        // funkcia, ktora urci, ktory fragmet sa ma otvorit ako prvy
        FT.replace(R.id.containerView, new TabFragment()).commit();


        //


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();

                if (item.getItemId() == R.id.nav_item_sent) {
                    FragmentTransaction fragmentTransaction = FM.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new SentFragment()).commit();
                }

                // funkcia ktora otvori taby s modlitbou
                if (item.getItemId() == R.id.nav_item_draft) {
                    FragmentTransaction fragmentTransaction = FM.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new TabFragmentModlitba()).commit();
                }
                // funkcia ktora otvara hlavne taby
                if (item.getItemId() == R.id.nav_item_inbox)

                {
                    FragmentTransaction fragmentTransaction = FM.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();

                }

                //    if (item.getItemId()==R.id.group_settings_id)
                // {
                //       FragmentTransaction fragmentTransaction=FM.beginTransaction();
                //   fragmentTransaction.replace(R.id.containerView,new Nastavenia()).commit();

                // }

                return false;
            }
        });


        // toto som zistil stade: https://www.youtube.com/watch?v=EZ-sNN7UWFU

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);


        android.support.v7.widget.Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
         R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(toggle);

      toggle.syncState();



    }



    // inicializuje menu - s nastaveniami

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      //   Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    //@Override
   // public void onCreateContextMenu (Context menu, View view, ContextMenu.ContextMenuInfo menuInfo)
   // {
    //    if (view.getId() == this.getListView().getId())
     //   {
     //       menu.setHeaderTitle("Menu");
      //      menu.add(Menu.NONE)
     //   }
   // }




   // funkcia, co ma spravit check button menu





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        TextView textView= (TextView) findViewById(R.id.text);

        switch (id) {
            case R.id.menu_1:
                if (item.isChecked())
                    item.setChecked(false);
                else item.setChecked(true);
                textView.setTextSize(20);




                return super.onOptionsItemSelected(item);
            case R.id.menu_2:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                textView.setTextSize(25);
                return super.onOptionsItemSelected(item);


            case R.id.menu_3:
                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                textView.setTextSize(30);
                return super.onOptionsItemSelected(item);

        }
    return super.onOptionsItemSelected(item);
   //     return true;
    }
}
















