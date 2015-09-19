package ch.swissonid.design_lib_sample.fragments;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import ch.swissonid.design_lib_sample.Data;
import ch.swissonid.design_lib_sample.R;
import ch.swissonid.design_lib_sample.adapters.MusicCardRVArrayAdapter;

public class OverlappingContentFragment extends BaseFragment {
    private static final int AMOUNT_OF_COLUMNS = 2;
    public static final int AMOUNT_OF_IMGS = 8;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PinnedAppBarkFragment.
     */
    public static OverlappingContentFragment newInstance() {
        return new OverlappingContentFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        setupRecyclerView(view);
        return view;
    }


    private void setupRecyclerView(View view) {
        RecyclerView recyclerView = ButterKnife.findById(view, R.id.simpleGrid);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), AMOUNT_OF_COLUMNS);
        recyclerView.setLayoutManager(layoutManager);

        MusicCardRVArrayAdapter arrayAdapter = new MusicCardRVArrayAdapter(Data.getData(AMOUNT_OF_IMGS));
        recyclerView.setAdapter(arrayAdapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_overlapping_content;
    }

    @Override
    public boolean hasCustomToolbar() {
        return true;
    }

    @Override
    protected int getTitle() {
        return R.string.overlapping_content_menu_title;
    }

    @Override
    protected int getToolbarId() {
        return R.id.toolbar_overlapping_content;
    }
}
