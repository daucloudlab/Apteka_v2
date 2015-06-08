package kz.abcsoft.apteka;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import kz.abcsoft.apteka.model.Apteka;
import kz.abcsoft.apteka.model.Medikament;
import kz.abcsoft.apteka.testdata.AptekaTestList;
import kz.abcsoft.apteka.testdata.MedikamentTestList;

/**
 * Created by daulet on 6/8/15.
 */
public class MedikamentDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medikament_detail);
        Toolbar toolbar = (Toolbar)findViewById(R.id.activity_medikament_detail_toolbar) ;
//        toolbar.setNavigationIcon(R.drawable.previous_24);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        String pid= getIntent().getStringExtra("pid") ;
        int pidInteger = Integer.parseInt(pid) ;
        String mid = getIntent().getStringExtra("mid") ;
        int midInteger = Integer.parseInt(mid) ;

        Medikament concreteMedikament = MedikamentTestList.getMedikament(midInteger) ;

        TextView aptekaName = (TextView)findViewById(R.id.medikament_apteka_name) ;
        TextView medikamentName = (TextView)findViewById(R.id.medikament_title_in_med_detail_activity) ;
        TextView medikamentDescription = (TextView)findViewById(R.id.medikament_description_in_med_detail_activity);
        TextView medikamentPrice = (TextView)findViewById(R.id.medikament_price) ;

        Apteka apteka = AptekaTestList.getApteka(pidInteger) ;
        aptekaName.setText("Название аптеки: " + apteka.getTitle()) ;

        medikamentName.setText("Название медикамента: " + concreteMedikament.getTitle());
        medikamentDescription.setText("Характеристика медикамента: " + concreteMedikament.getDescription());
        medikamentPrice.setText( "Цена медикамента: " + Double.valueOf(concreteMedikament.getPrice()).toString() + " тг.");

    }
}
