package ch.swissonid.design_lib_sample.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ch.swissonid.design_lib_sample.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ParallaxFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ParallaxFragment extends Fragment {

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parallax, container, false);
    }


}
