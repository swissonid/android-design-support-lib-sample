package ch.swissonid.design_lib_sample.fragments;


import android.support.v4.app.Fragment;

import ch.swissonid.design_lib_sample.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ParallaxFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ParallaxFragment extends BaseFragment {


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
