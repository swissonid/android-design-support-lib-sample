package ch.swissonid.design_lib_sample.fragments.tabs;


import android.os.Bundle;
import android.app.Fragment;
import android.view.View;
import android.widget.TextView;

import butterknife.InjectView;
import ch.swissonid.design_lib_sample.R;
import ch.swissonid.design_lib_sample.fragments.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabFragment extends BaseFragment {
    @InjectView(R.id.text_view)
    TextView mTextView;
    private static final String ARG_TITLE = "arg_title";

    private String mTitleParam;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param title title that will be shown
     * @return A new instance of fragment TabFragment.
     */
    public static TabFragment newInstance(String title) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
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
            mTitleParam = getArguments().getString(ARG_TITLE);
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(mTitleParam.isEmpty()) return;
        mTextView.setText(mTitleParam);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_tab;
    }


}
