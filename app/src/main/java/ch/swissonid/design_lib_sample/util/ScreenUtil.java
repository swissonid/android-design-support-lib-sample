package ch.swissonid.design_lib_sample.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

public class ScreenUtil {

    public static Point getWindowSize(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point displaySize = new Point();
        display.getSize(displaySize);
        return displaySize;
    }

    public static int getWindowHeight(Context context){
        return getWindowSize(context).x;
    }

    public static int getWindowHeightWithoutStatusAndActionBar(Activity activity){
        int statusBar = getStatusBarHeight(activity);
        return getWindowHeightWithoutActionBar(activity) - statusBar;
    }

    public static int getWindowHeightWithoutActionBar(Context context){
        int windowHeight = getWindowHeight(context);
        int actionBar = getActionBarHeight(context);
        return windowHeight - actionBar;
    }
    public static int getStatusBarHeight(Activity activity){
        Window window = activity.getWindow();
        Rect rect = new Rect();
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    public static int getActionBarHeight(Context context){
        TypedValue typedValue = new TypedValue();
        int actionBatHeight = 0;
        if(context.getTheme().resolveAttribute(android.R.attr.actionBarSize,typedValue,true)){
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            float actionBar = TypedValue.complexToDimension(typedValue.data,displayMetrics);
            actionBatHeight = Math.round(actionBar);
        }
        return actionBatHeight;
    }



}
