package kz.abcsoft.apteka;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import kz.abcsoft.apteka.adapter.MedikamentListAdapter;
import kz.abcsoft.apteka.model.Apteka;
import kz.abcsoft.apteka.model.Medikament;
import kz.abcsoft.apteka.testdata.AptekaTestList;
import kz.abcsoft.apteka.testdata.MedikamentTestList;

/**
 * Created by daulet on 6/8/15.
 */
public class MainFragment extends Fragment {

    private EditText medikamentSearch ;
    private List<Medikament> listMedikaments ;
    private List<Apteka> listApteks ;
    private MedikamentListAdapter adapter ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false) ;

        listApteks = AptekaTestList.getListApteks() ;
        listMedikaments = MedikamentTestList.getAllMedikaments();

        adapter  = new MedikamentListAdapter(getActivity(), listMedikaments, listApteks) ;
        ListView listView = (ListView)view.findViewById(R.id.medikaments_list) ;
        listView.setAdapter(adapter);

        medikamentSearch = (EditText)view.findViewById(R.id.input_medikament_search) ;
        medikamentSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String stringAID = ((TextView)view.findViewById(R.id.apteka_id)).getText().toString() ;
                String stringMID = ((TextView)view.findViewById(R.id.medikament_id)).getText().toString() ;
                Intent medikamentDetailIntent = new Intent(getActivity(), MedikamentDetailActivity.class) ;
                medikamentDetailIntent.putExtra("pid", stringAID) ;
                medikamentDetailIntent.putExtra("mid", stringMID) ;
                startActivity(medikamentDetailIntent);
            }
        });


        return view ;
    }
}
