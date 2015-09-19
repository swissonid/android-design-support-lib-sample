package ch.swissonid.design_lib_sample;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import ch.swissonid.design_lib_sample.fragments.BaseFragment;
import ch.swissonid.design_lib_sample.fragments.FlexibleSpaceFragment;
import ch.swissonid.design_lib_sample.fragments.FlexibleSpaceWithImageFragment;
import ch.swissonid.design_lib_sample.fragments.FloatingActionButtonFragment;
import ch.swissonid.design_lib_sample.fragments.OverlappingContentFragment;
import ch.swissonid.design_lib_sample.fragments.StandardAppBarFragment;
import ch.swissonid.design_lib_sample.fragments.tabs.TabHolderFragment;
import ch.swissonid.design_lib_sample.util.LogUtils;
import ch.swissonid.design_lib_sample.util.Navigator;

import static ch.swissonid.design_lib_sample.util.LogUtils.LOGD;

public class DrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.navigation_view)
    NavigationView mNavigationView;

    private static Navigator mNavigator;
    private Toolbar mToolbar;
    private @IdRes int mCurrentMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        ButterKnife.bind(this);
        setupToolbar();
        setupNavDrawer();
        initNavigator();
        mCurrentMenuItem = R.id.standard_app_bar_menu_item;
        setNewRootFragment(StandardAppBarFragment.newInstance());
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
        mNavigationView.setNavigationItemSelectedListener(this);
        LOGD(this, "setup setupNavDrawer");
    }

    public void openDrawer(){
        mDrawerLayout.openDrawer(Gravity.LEFT);
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

            case R.id.floating_action_button:
                setNewRootFragment(FloatingActionButtonFragment.newInstance());
                break;

            case R.id.overlapping_content_menu_item:
                setNewRootFragment(OverlappingContentFragment.newInstance());
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
}
