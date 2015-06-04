package ch.swissonid.design_lib_sample.fragments;


import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ch.swissonid.design_lib_sample.BuildConfig;
import ch.swissonid.design_lib_sample.R;
import ch.swissonid.design_lib_sample.adapters.RVArrayAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ParallaxFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ParallaxFragment extends BaseFragment {

    @InjectView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;

    private static final int AMOUNT_OF_DATA = 50;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ParallaxFragment.
     */
    public static ParallaxFragment newInstance() {
        return new ParallaxFragment();
    }

    public ParallaxFragment() {
        // Required empty public constructor
    }

    private void setList() {
        RecyclerView recyclerView = ButterKnife.findById(getActivity(), R.id.simpleList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        RVArrayAdapter arrayAdapter = new RVArrayAdapter(getData());
        recyclerView.setAdapter(arrayAdapter);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setList();
        mCollapsingToolbar.setTitle(getString(getTitle()));

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
    protected int getToolbarId() {
        return R.id.toolbar_parallax;
    }

    @Override
    protected int getTitle() {
        return R.string.parallax_menu_title;
    }

    @Override
    public boolean hasCustomToolbar() {
        return true;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_parallax;
    }
}
