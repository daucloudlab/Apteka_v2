package kz.abcsoft.apteka;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import kz.abcsoft.apteka.adapter.TabsPagerAdapter;
import kz.abcsoft.apteka.model.Apteka;
import kz.abcsoft.apteka.testdata.AptekaTestList;


public class AptekaDetailActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;

    private Toolbar toolbar ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apteka_detail) ;

        String pid = getIntent().getStringExtra("pid") ;
        int pidInteger = Integer.parseInt(pid) ;
//
//        List<Apteka> listApteks = AptekaTestList.getListApteks() ;
//
        Apteka apteka = AptekaTestList.getApteka(pidInteger) ;

        String apteName = apteka.getTitle() ;
        List<String> aptekaAddresses = apteka.getAddresses() ;
        StringBuilder sb = new StringBuilder() ;
        for(String s : aptekaAddresses)
            sb.append("\n" + s + "\n") ;
        String aptekaAddressesString = sb.toString() ;

        viewPager = (ViewPager) findViewById(R.id.pager);
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager()) ;
        viewPager.setAdapter(mAdapter);


//        Toolbar toolbar = (Toolbar)findViewById(R.id.apteka_detail_toolbar) ;
//        toolbar.inflateMenu(R.id.apteka_detail_toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setTitle("Медикаменты");
        initAptekDetailToolbar(toolbar, apteName, aptekaAddressesString);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.apteka_detail_menu, menu);
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void initAptekDetailToolbar(Toolbar toolbar, String title, final String addresses){
        toolbar = (Toolbar)findViewById(R.id.apteka_detail_toolbar) ;
        toolbar.setTitle("Медикаменты " + title);
        toolbar.setNavigationIcon(R.drawable.previous_24);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();

                switch (id) {
                    case R.id.phone:
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:+77078914322"));
                        startActivity(callIntent);
                        //finish() ;
                        return true;
                    case R.id.get_addresses:
                        Intent outputAddresses = new Intent(getApplicationContext(), OutputAddressesActivity.class) ;
                        outputAddresses.putExtra("addresses", addresses);
                        startActivity(outputAddresses);
//                        finish() ;
                        return true;

                }

                return false;
            }
        });

//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent toListApteks = new Intent(getApplicationContext(), .class);
//                startActivity(toListApteks);
//
//            }
//        });

        toolbar.inflateMenu(R.menu.apteka_detail_menu) ;

    }

}
