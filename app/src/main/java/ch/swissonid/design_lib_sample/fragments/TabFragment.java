package ch.swissonid.design_lib_sample.fragments;


import android.support.v4.app.Fragment;

import ch.swissonid.design_lib_sample.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabFragment extends BaseFragment {
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TabFragment.
     */
    public static TabFragment newInstance() {
        return new TabFragment();
    }

    public TabFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getTitle() {
        return R.string.tabs_menu_title;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_tab;
    }


}
