package ch.swissonid.design_lib_sample.fragments;


import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;

import butterknife.InjectView;
import ch.swissonid.design_lib_sample.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FlexibleSpaceWithImageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FlexibleSpaceWithImageFragment extends BaseFragment {

    @InjectView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ParallaxFragment.
     */
    public static FlexibleSpaceWithImageFragment newInstance() {
        return new FlexibleSpaceWithImageFragment();
    }

    public FlexibleSpaceWithImageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mCollapsingToolbar.setTitle(getString(getTitle()));
    }

    @Override
    protected int getToolbarId() {
        return R.id.toolbar_flexible_space_with_image;
    }

    @Override
    protected int getTitle() {
        return R.string.flexible_space_with_image_menu_title;
    }

    @Override
    public boolean hasCustomToolbar() {
        return true;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_flexible_space_with_image;
    }
}
