package ch.swissonid.design_lib_sample.fragments;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import ch.swissonid.design_lib_sample.DrawerActivity;
import ch.swissonid.design_lib_sample.R;

public abstract class BaseFragment extends Fragment {
    Toolbar mToolbar;

    public DrawerActivity getDrawerActivity(){
        return ((DrawerActivity) super.getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setToolbar(view);
    }

    protected void setToolbar(View view) {
        if(!hasCustomToolbar()) return;
        mToolbar = ButterKnife.findById(view,getToolbarId());
        mToolbar.setTitle(getTitle());
        mToolbar.setNavigationIcon(R.drawable.ic_menu);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDrawerActivity().openDrawer();
            }
        });
    }

    protected @IdRes int getToolbarId(){
        return R.id.toolbar;
    }

    public boolean hasCustomToolbar(){
        return false;
    }

    protected @StringRes int getTitle(){
        return R.string.not_title_set;
    }

    protected abstract  @LayoutRes int getLayout();
}
