package ch.swissonid.design_lib_sample.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import ch.swissonid.design_lib_sample.R;

public class Navigator{
    private final FragmentManager mFragmentManager;

    public Navigator(final FragmentManager fragmentManager){
        mFragmentManager = fragmentManager;
    }

    public Fragment getActiveFragment() {
        if (mFragmentManager.getBackStackEntryCount() == 0) {
            return null;
        }
        String tag = mFragmentManager
                .getBackStackEntryAt(mFragmentManager.getBackStackEntryCount() - 1).getName();
        return mFragmentManager.findFragmentByTag(tag);
    }

    /**
     * Pushes the fragment, and add to the back stack
     */
    public void goTo(Fragment fragment) {
        mFragmentManager.beginTransaction()
                .addToBackStack(getName(fragment))
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.container, fragment, getName(fragment))
                .commit();
        mFragmentManager.executePendingTransactions();
    }

    private String getName(Fragment fragment) {
        return fragment.getClass().getName();
    }

    public void setStartFragment(Fragment startFragment){
        if(getSize() > 0){
            this.clearHistory();
        }
        this.replaceFragment(startFragment);
    }

    /**
     * Replace the screen
     */
    protected void replaceFragment(Fragment screen) {
        mFragmentManager.beginTransaction()
                .replace(R.id.container, screen, screen.getClass().getSimpleName())
                .commit();
        mFragmentManager.executePendingTransactions();
    }

    /**
     * Pops the back stack
     */
    public void goOneFragmentBack() {
        mFragmentManager.popBackStackImmediate();
    }

    public int getSize() {
        return mFragmentManager.getBackStackEntryCount();
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * Pops to root Fragment
     */
    public void gotToTheStartFragmentBack() {
        for (int i = 0; i <= mFragmentManager.getBackStackEntryCount(); ++i) {
            goOneFragmentBack();
        }
    }

    public void clearHistory() {
        while(mFragmentManager.popBackStackImmediate());
    }
}
