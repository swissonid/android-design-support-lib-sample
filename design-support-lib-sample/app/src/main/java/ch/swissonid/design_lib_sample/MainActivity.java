package ch.swissonid.design_lib_sample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import butterknife.ButterKnife;
import ch.swissonid.design_lib_sample.adapters.RVArrayAdapter;
import ch.swissonid.design_lib_sample.fragments.StandardAppBarFragment;
import ch.swissonid.design_lib_sample.util.Navigator;

public class MainActivity extends AppCompatActivity {



    private static Navigator mNavigator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initNavigator();
        mNavigator.goTo(StandardAppBarFragment.newInstance());
    }

    private void initNavigator() {
        mNavigator = new Navigator(getSupportFragmentManager());
    }


    private void setToolbar() {
        Toolbar mToolbar = ButterKnife.findById(this, R.id.toolbar);
        if(mToolbar == null) return;
        setSupportActionBar(mToolbar);
    }

}
