package ch.swissonid.design_lib_sample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ch.swissonid.design_lib_sample.util.ScreenUtil;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(AndroidJUnit4.class)
public class ScreenUtilTest {

    private static final int STATUSBAR_HEIGHT = 25;
    private static final int ACTIONBAR_HEIGHT = 56;

    private DrawerActivity mActivity;
    @Rule
    public ActivityTestRule<DrawerActivity> mDrawerRule = new ActivityTestRule<>(DrawerActivity.class);


    @Before
    public void setUp(){
        mActivity = mDrawerRule.getActivity();
    }

    @Test
    public void getActionBarHeightTest(){
        assertThat(ScreenUtil.getActionBarHeight(mActivity))
                .isEqualTo(scale(ACTIONBAR_HEIGHT));
    }

    @Test
    public void getStatusBarHeightTest(){
        assertThat(ScreenUtil.getStatusBarHeight(mDrawerRule.getActivity()))
                .isEqualTo(scale(STATUSBAR_HEIGHT));
    }

    @Test
    public void getContentViewTest(){
        View contentView = mActivity.getWindow().findViewById(android.R.id.content);
        assertThat(ScreenUtil.getWindowHeight(mActivity)).isEqualTo(contentView.getHeight());
        assertThat(ScreenUtil.getWindowHeightWithoutStatusAndActionBar(mActivity))
                .isEqualTo(contentView.getHeight());
    }

    private float getScaleFactor(){
        return mActivity.getResources().getDisplayMetrics().density;
    }

    private int scale(int height){
        return Math.round(height * getScaleFactor());
    }
}
