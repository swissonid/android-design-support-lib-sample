package ch.swissonid.design_lib_sample.fragments.tabs;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import ch.swissonid.design_lib_sample.Data;
import ch.swissonid.design_lib_sample.R;
import ch.swissonid.design_lib_sample.adapters.MusicCardRVArrayAdapter;
import ch.swissonid.design_lib_sample.fragments.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabFragment extends BaseFragment {

    private static final String ARG_START = "start_param";
    public static final int AMOUNT_OF_COLUMNS = 2;
    public static final int AMOUNT_OF_IMG_IN_VIEW = 5;

    private @DrawableRes int mStart;


    public static TabFragment newInstance(int start) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_START, start);
        fragment.setArguments(args);
        return fragment;
    }

    public TabFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mStart = getArguments().getInt(ARG_START);
        }
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

        MusicCardRVArrayAdapter arrayAdapter = new MusicCardRVArrayAdapter(Data.getData(mStart, AMOUNT_OF_IMG_IN_VIEW));
        recyclerView.setAdapter(arrayAdapter);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_tab;
    }


}
