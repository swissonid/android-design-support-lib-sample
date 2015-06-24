package ch.swissonid.design_lib_sample.fragments;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.concurrent.atomic.AtomicBoolean;

import butterknife.InjectView;
import ch.swissonid.design_lib_sample.R;
import ch.swissonid.design_lib_sample.adapters.RVArrayAdapter;
import ch.swissonid.design_lib_sample.util.AnimUtils;
import ch.swissonid.design_lib_sample.util.LogUtils;

public class FloatingActionButtonFragment extends BaseFragment{

    @InjectView(R.id.simpleList)
    RecyclerView mRecyclerView;

    @InjectView(R.id.appbar)
    AppBarLayout mAppBarLayout;

    @InjectView(R.id.floating_action_button)
    FloatingActionButton mFab;

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;


    public static FloatingActionButtonFragment newInstance() {
        return new FloatingActionButtonFragment();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setList();
        moveFab();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void moveFab(){
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                float deltaY = mFab.getHeight()*1.5f;
                if(i <0)animFab(deltaY);
                else animFab(-deltaY);
            }
        });
    }



    private void animFab(final float deltaY){
        ViewCompat.animate(mFab)
                .translationYBy(deltaY)
                .setInterpolator(AnimUtils.FAST_OUT_SLOW_IN_INTERPOLATOR)
                .withLayer()
                .start();
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
