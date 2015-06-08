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

import kz.abcsoft.apteka.adapter.AptekaListAdapter;
import kz.abcsoft.apteka.model.Apteka;
import kz.abcsoft.apteka.testdata.AptekaTestList;

public class AptekaListFragment extends Fragment {
    EditText aptekaSearch ;

    List<Apteka> listApteks ;
    AptekaListAdapter adapter ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_apteka_list, container, false) ;

        // Аптекалардың тізімін аламыз
        listApteks = AptekaTestList.getListApteks() ;

        adapter = new AptekaListAdapter(getActivity(), listApteks ) ;
        ListView listView = (ListView)view.findViewById(R.id.apteks_list) ;
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                String pid = ((TextView) view.findViewById(R.id.pid)).getText().toString();
//                Intent intent = new Intent(getApplicationContext(), AptekaDetailActivity.class);
//                intent.putExtra("pid", pid);
//                startActivity(intent);
//                finish();
            }
        });

        aptekaSearch = (EditText)view.findViewById(R.id.inputAptekSearch) ;
        aptekaSearch.addTextChangedListener(new TextWatcher() {
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


        return view ;
    }
}
