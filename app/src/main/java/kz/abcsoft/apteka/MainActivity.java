package kz.abcsoft.apteka;

import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import kz.abcsoft.apteka.map.MapsActivity;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar ;
    FragmentManager fm = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.main_toolbar) ;
        toolbar.setTitle(R.string.main_toolbar_title);
        initNavigationDrawer();

        fm.beginTransaction().add(R.id.main_activity_container, new MainFragment()).commit() ;
    }


//    private void initToolbar(){
//        toolbar = (Toolbar)findViewById(R.id.main_toolbar) ;
//        toolbar.setTitle(R.string.main_toolbar_title);

//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                int id = item.getItemId() ;
//                if(id == R.id.to_apteks_list) {
//                    Intent to_apteks_list_intent = new Intent(MainActivity.this, AptekaListActivity.class);
//                    startActivity(to_apteks_list_intent);
//                    finish() ;
//                    return true ;
//                }
//                return false;
//            }
//        });

//        toolbar.inflateMenu(R.menu.toolbar_menu) ;

//    }

    private void initNavigationDrawer(){

        AccountHeader accountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.material_background)
                .build() ;

        Drawer drawerResult = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(accountHeader)
                .withDisplayBelowToolbar(true)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(
                        new PrimaryDrawerItem()
                                .withName(R.string.nav_menu_item_apteki)
                                .withIdentifier(1)
                                .withIcon(R.drawable.ic_clinic_room_24),

                        new DividerDrawerItem(),

                        new PrimaryDrawerItem()
                                .withName(R.string.nav_menu_item_near_apteki)
                                .withIdentifier(2)
                                .withIcon(R.drawable.ic_room_black_24dp),

                        new DividerDrawerItem(),

                        new PrimaryDrawerItem()
                                .withName(R.string.nav_menu_item_search_medikament)
                                .withIdentifier(3)
                                .withIcon(R.drawable.ic_pill_24)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {

                        switch (iDrawerItem.getIdentifier()) {
                            case 1:
                                fm.beginTransaction().replace(R.id.main_activity_container, new AptekaListFragment())
                                        .commit();
                                toolbar.setTitle(R.string.search_apteks_title);
                                return false;
                            case 2:
                                Intent intent2 = new Intent(MainActivity.this, MapsActivity.class) ;
                                startActivity(intent2);

                                return false;
                            case 3:
                                fm.beginTransaction().replace(R.id.main_activity_container, new MainFragment())
                                        .commit();
                                toolbar.setTitle(R.string.main_toolbar_title);
                                return false;
                        }
                        return false;
                    }
                })
                .build() ;
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
