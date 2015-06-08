package kz.abcsoft.apteka;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by daulet on 6/5/15.
 */
public class OutputAddressesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_addresses);

        setTitle("Адреса и телефоны");

        TextView tvOutputAddresses = (TextView)findViewById(R.id.outputAddresses) ;
        String addresses = getIntent().getStringExtra("addresses") ;
        tvOutputAddresses.setText(addresses);
    }
}
