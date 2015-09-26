package ch.swissonid.design_lib_sample.fragments;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;


import butterknife.Bind;
import ch.swissonid.design_lib_sample.R;
import ch.swissonid.design_lib_sample.adapters.RVArrayAdapter;
import ch.swissonid.design_lib_sample.util.AnimUtils;

public class FloatingActionButtonFragment extends BaseFragment{

    @Bind(R.id.simpleList)
    RecyclerView mRecyclerView;

    public static FloatingActionButtonFragment newInstance() {
        return new FloatingActionButtonFragment();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setList();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void setList() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        RVArrayAdapter arrayAdapter = new RVArrayAdapter(getData());
        mRecyclerView.setAdapter(arrayAdapter);
    }


    @Override
    protected int getTitle() {
        return R.string.floating_action_button;
    }

    @Override
    protected int getToolbarId() {
        return R.id.toolbar;
    }

    @Override
    public boolean hasCustomToolbar() {
        return true;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_floating_action_button;
    }


    public String[] getData() {
        return getActivity().getResources().getStringArray(R.array.countries);
    }
}
