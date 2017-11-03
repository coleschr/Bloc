package com.example.cole.BLOC;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Cole on 10/16/17.
 */

public class FragmentProducts extends Fragment {
    private ListView packageListView;
    private ArrayList<Package> packages;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.products_fragment, container, false);

        //wire any widgets -- must use rootView.findViewById
        packageListView = (ListView) rootView.findViewById(R.id.product_list_view);

        //get any other initial set up done
        createPackages();
        setUpArrayAdapter();

        //return the view that we inflated
        return rootView;
    }

    private void createPackages() {
        packages = new ArrayList<>();
        packages.add(new Package(getString(R.string.small_package_title), "15 Blocs, 10 Toppers", 150, 0));
        packages.add(new Package(getString(R.string.medium_package_title), "30 Blocs, 10 Squares, 15 Toppers", 350, 0));
        packages.add(new Package(getString(R.string.large_package_title), "50 Blocs, 30 Squares, 25 Toppers", 650, 0));
        packages.add(new Package(getString(R.string.mega_package_title), "150 Blocs, 50 Squares, 40 Toppers", 1200, 0));
    }

    private void setUpArrayAdapter() {
        ArrayAdapter<Package> adapter
                = new ArrayAdapter<Package>(getActivity(), //context
                R.layout.list_item_product,   //textView layout for the l
                packages); //the list to d
        //set the adapter to the listView
        packageListView.setAdapter(adapter);
        packageListView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) { //int i used to be pos (position in list)

                //Intent i = new Intent(MainActivity.this, StarDescriptionActivity.class);

                //i.putExtra(STAR, stars.get(pos));

                //startActivity(i);
            }
        });
    }
}
