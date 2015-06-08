package ch.swissonid.design_lib_sample.fragments;

import android.animation.Animator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ArrayAdapter;

import butterknife.InjectView;
import ch.swissonid.design_lib_sample.R;
import ch.swissonid.design_lib_sample.widget.OnDetectScrollListener;
import ch.swissonid.design_lib_sample.widget.ScrollListView;

/**
 * Created by saijad dhuka on 6/8/15.
 */
public class FloatingActionButtonFragment extends BaseFragment{



    private final Interpolator mInterpolator = new AccelerateDecelerateInterpolator();
    private boolean isAnimating=false;

    @InjectView(R.id.sample_list)
    ScrollListView sampleListView;

    @InjectView(R.id.floating_action_button)
    FloatingActionButton floatingActionButton;

    public static FloatingActionButtonFragment newInstance() {
        return new FloatingActionButtonFragment();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter listViewAdapter=new ArrayAdapter(getActivity().getBaseContext(),android.R.layout.simple_list_item_1,getActivity().getResources().getStringArray(R.array.countries));
        sampleListView.setAdapter(listViewAdapter);
        sampleListView.setOnDetectScrollListener(new OnDetectScrollListener() {
            @Override
            public void onUpScrolling() {
                if(!isAnimating)
                    floatingActionButton.animate().setInterpolator(mInterpolator)
                            .setDuration(200)
                            .translationY(0).setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            floatingActionButton.setVisibility(View.VISIBLE);
                            isAnimating=true;
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            isAnimating=false;
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });

            }

            @Override
            public void onDownScrolling() {
                if(!isAnimating)
                    floatingActionButton.animate().setInterpolator(mInterpolator)
                            .setDuration(200)
                            .translationY(floatingActionButton.getHeight()).setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            isAnimating=true;
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            floatingActionButton.setVisibility(View.GONE);
                            isAnimating=false;
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
            }
        });


    }


    @Override
    protected int getTitle() {
        return R.string.floating_action_button;
    }

    @Override
    protected int getToolbarId() {
        return -1;
    }

    @Override
    public boolean hasCustomToolbar() {
        return false;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_floating_action_button;
    }



}
