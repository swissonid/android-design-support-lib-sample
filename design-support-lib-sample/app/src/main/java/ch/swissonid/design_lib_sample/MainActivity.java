package ch.swissonid.design_lib_sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ch.swissonid.design_lib_sample.fragments.StandardAppBarFragment;
import ch.swissonid.design_lib_sample.util.LogUtils;
import ch.swissonid.design_lib_sample.util.Navigator;

public class MainActivity extends AppCompatActivity implements DrawerLayout.DrawerListener{

    @InjectView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    private static Navigator mNavigator;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        setupToolbar();
        setupNavDrawer();
        initNavigator();
        mNavigator.goTo(StandardAppBarFragment.newInstance());
    }

    private void initNavigator() {
        mNavigator = new Navigator(getSupportFragmentManager());
    }

    private void setupToolbar() {
        mToolbar = ButterKnife.findById(this, R.id.toolbar);
        if(mToolbar == null) return;
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupNavDrawer() {
        if(mDrawerLayout == null) {
            LogUtils.LOGE(this, "mDrawerLayout is null - Can not setup the NavDrawer! Have you set the android.support.v7.widget.DrawerLayout?");
            return;
        }
        mDrawerLayout.setDrawerListener(this);

        mDrawerToggle = new ActionBarDrawerToggle(this
                , mDrawerLayout
                , mToolbar
                , R.string.navigation_drawer_open
                , R.string.navigation_drawer_close);

        mDrawerToggle.syncState();
        LogUtils.LOGD(this, "setup setupNavDrawer");
    }


    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        mDrawerToggle.onDrawerSlide(drawerView, slideOffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        mDrawerToggle.onDrawerOpened(drawerView);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        mDrawerToggle.onDrawerClosed(drawerView);
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        mDrawerToggle.onDrawerStateChanged(newState);
    }
}
