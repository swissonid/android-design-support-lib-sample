package ch.swissonid.design_lib_sample.fragments.tabs;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.InjectView;
import ch.swissonid.design_lib_sample.R;
import ch.swissonid.design_lib_sample.adapters.PagerAdapter;
import ch.swissonid.design_lib_sample.fragments.BaseFragment;

import static ch.swissonid.design_lib_sample.util.LogUtils.LOGD;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabHolderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabHolderFragment extends BaseFragment {
    @InjectView(R.id.tab_layout)
    TabLayout mTabLayout;

    @InjectView(R.id.view_pager)
    ViewPager mViewPager;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TabFragment.
     */
    public static TabHolderFragment newInstance() {
        return new TabHolderFragment();
    }

    public TabHolderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root =  super.onCreateView(inflater, container, savedInstanceState);
        setupTabTextColor();
        setupViewPager();
        return root;
    }

    private void setupTabTextColor() {
        int tabTextColor = getResources().getColor(R.color.titleTextColor);
        mTabLayout.setTabTextColors(tabTextColor,tabTextColor);
    }

    private void setupViewPager() {
        //You could use the normal supportFragmentManger if you like
        PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager(), getActivity());
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);//this is the new nice thing ;D
    }

    @Override
    protected int getToolbarId() {
        return R.id.toolbar_tabbar;
    }

    @Override
    public boolean hasCustomToolbar() {
        return true;
    }

    @Override
    protected int getTitle() {
        return R.string.tabs_menu_title;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_tab_holder;
    }


}
