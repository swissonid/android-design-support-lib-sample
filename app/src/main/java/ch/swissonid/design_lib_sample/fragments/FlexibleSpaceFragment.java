package ch.swissonid.design_lib_sample.fragments;


import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import butterknife.Bind;
import ch.swissonid.design_lib_sample.R;
import ch.swissonid.design_lib_sample.util.ScreenUtil;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FlexibleSpaceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FlexibleSpaceFragment extends BaseFragment {

    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PinnedAppBarkFragment.
     */
    public static FlexibleSpaceFragment newInstance() {
        return new FlexibleSpaceFragment();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mCollapsingToolbar.setTitle(getString(getTitle()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if(view == null) return null;
        View scrollingView = view.findViewById(R.id.scrollingContent);
        int screenHeight = ScreenUtil.getWindowHeightWithoutActionBar(view.getContext());
        if(scrollingView.getHeight() < screenHeight){
            scrollingView.getLayoutParams().height = screenHeight;
        }
        return  view;
    }

    public FlexibleSpaceFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getTitle() {
        return R.string.flexible_space_menu_title;
    }

    @Override
    protected int getToolbarId() {
        return R.id.toolbar_flexible_space;
    }

    @Override
    public boolean hasCustomToolbar() {
        return true;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_flexible_space;
    }


}
