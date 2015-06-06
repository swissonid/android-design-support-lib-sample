package ch.swissonid.design_lib_sample.fragments;


import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import ch.swissonid.design_lib_sample.R;
import ch.swissonid.design_lib_sample.adapters.RVArrayAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StandardAppBarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StandardAppBarFragment extends BaseFragment {

    private static final int AMOUNT_OF_DATA = 50;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment StandardAppBarFragment.
     */
    public static StandardAppBarFragment newInstance() {
        return new StandardAppBarFragment();
    }

    public StandardAppBarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setList();
    }

    private void setList() {
        RecyclerView recyclerView = ButterKnife.findById(getActivity(),R.id.simpleList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        RVArrayAdapter arrayAdapter = new RVArrayAdapter(getData());
        recyclerView.setAdapter(arrayAdapter);
    }

    @NonNull
    private String[] getData() {
        String[] data = new String[AMOUNT_OF_DATA];
        for(int i=0;i<AMOUNT_OF_DATA;++i){
            data[i]=(getString(R.string.sample_data,(i+1)));
        }
        return data;
    }

    @Override
    protected int getTitle() {
        return R.string.standard_app_bar_menu_title;
    }

    @Override
    public boolean hasCustomToolbar() {
        return true;
    }

    @Override
    protected int getLayout() {
        return R.layout.standard_app_bar_fragment;
    }
}
