package ch.swissonid.design_lib_sample;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ch.swissonid.design_lib_sample.fragments.BaseFragment;
import ch.swissonid.design_lib_sample.fragments.FlexibleSpaceWithImageFragment;
import ch.swissonid.design_lib_sample.fragments.FlexibleSpaceFragment;
import ch.swissonid.design_lib_sample.fragments.StandardAppBarFragment;
import ch.swissonid.design_lib_sample.fragments.tabs.TabHolderFragment;
import ch.swissonid.design_lib_sample.util.LogUtils;
import ch.swissonid.design_lib_sample.util.Navigator;

import static ch.swissonid.design_lib_sample.util.LogUtils.LOGD;

public class DrawerActivity extends AppCompatActivity implements DrawerLayout.DrawerListener
        , NavigationView.OnNavigationItemSelectedListener{

    @InjectView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @InjectView(R.id.navigation_view)
    NavigationView mNavigationView;

    private static Navigator mNavigator;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private @IdRes int mCurrentMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        ButterKnife.inject(this);
        setupToolbar();
        setupNavDrawer();
        initNavigator();
        mCurrentMenuItem = R.id.standard_app_bar_menu_item;
        setNewRootFragment(StandardAppBarFragment.newInstance());
        //TODO make it work
        //setTransparentStatusBar();
    }

    private void initNavigator() {
        if(mNavigator != null) return;
        mNavigator = new Navigator(getSupportFragmentManager(), R.id.container);
    }

    private void setNewRootFragment(BaseFragment fragment){
        if(fragment.hasCustomToolbar()){
            hideActionBar();
        }else {
            showActionBar();
        }
        mNavigator.setRootFragment(fragment);
        mDrawerLayout.closeDrawers();
    }

    private void setupToolbar() {
        mToolbar = ButterKnife.findById(this, R.id.toolbar);
        if(mToolbar == null) {
            LOGD(this, "Didn't find a toolbar");
            return;
        }
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar == null) return;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }

    private void hideActionBar(){
        ActionBar actionBar = getSupportActionBar();
        if(actionBar == null) return;
        actionBar.hide();
    }

    private void showActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar == null) return;
        actionBar.show();
    }

    private void setupNavDrawer() {
        if(mDrawerLayout == null) {
            LogUtils.LOGE(this, "mDrawerLayout is null - Can not setup the NavDrawer! Have you set the android.support.v7.widget.DrawerLayout?");
            return;
        }
        mDrawerLayout.setDrawerListener(this);
        //TODO look at documantation => homepage do I really need like that?
        mDrawerToggle = new ActionBarDrawerToggle(this
                , mDrawerLayout
                , mToolbar
                , R.string.navigation_drawer_open
                , R.string.navigation_drawer_close);

        mDrawerToggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);
        LOGD(this, "setup setupNavDrawer");
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }


    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        mDrawerToggle.onDrawerSlide(drawerView, slideOffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        mDrawerToggle.onDrawerOpened(drawerView);
    }

    public void openDrawer(){
        mDrawerLayout.openDrawer(Gravity.LEFT);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        mDrawerToggle.onDrawerClosed(drawerView);
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        mDrawerToggle.onDrawerStateChanged(newState);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        @IdRes int id = menuItem.getItemId();
        if(id == mCurrentMenuItem) {
            mDrawerLayout.closeDrawers();
            return false;
        }
        switch (id){
            case R.id.standard_app_bar_menu_item:
                setNewRootFragment(StandardAppBarFragment.newInstance());
                break;
            case R.id.tabs_menu_item:
                setNewRootFragment(TabHolderFragment.newInstance());
                break;

            case R.id.parallax_menu_item:
                setNewRootFragment(FlexibleSpaceWithImageFragment.newInstance());
                break;

            case R.id.pinned_app_bar_menu_item:
                setNewRootFragment(FlexibleSpaceFragment.newInstance());
                break;
        }
        mCurrentMenuItem = id;
        menuItem.setChecked(true);
        return false;
    }

    @Override
    public void finish() {
        mNavigator = null;
        super.finish();
    }

    public void setTransparentStatusBar(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            window.setStatusBarColor(getResources().getColor(android.R.color.transparent));
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        }
    }
}
