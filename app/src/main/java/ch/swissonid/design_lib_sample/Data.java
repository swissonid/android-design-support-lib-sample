package ch.swissonid.design_lib_sample;

import android.support.annotation.DrawableRes;

/**
 * Created by pmueller on 19.9.15.
 */
public class Data {
        public static final @DrawableRes
        int[] ROOT_DATA = {
            R.drawable.car,
            R.drawable.cross,
            R.drawable.doll,
            R.drawable.desert,
            R.drawable.fantastic,
            R.drawable.girl,
            R.drawable.glass,
            R.drawable.jump,
            R.drawable.mens,
            R.drawable.plunge,
            R.drawable.shadow,
            R.drawable.wall,
            R.drawable.baseball,
            R.drawable.beach_with_hair,
            R.drawable.cat_window,
            R.drawable.crying,
            R.drawable.food,
            R.drawable.map,
            R.drawable.mini_food,
            R.drawable.mirror,
            R.drawable.soup
        };

        public static @DrawableRes int[] getData( final int amountOfImgs){
                return getData(0, amountOfImgs);
        }

        public static @DrawableRes int[] getData(final int startPoint, final int amountOfImgs){
                @DrawableRes int[] data = new int[amountOfImgs];
                int j=0;
                for(int i=startPoint; i<(startPoint+amountOfImgs);++i){
                        data[j++] = Data.ROOT_DATA[i];
                }
                return data;
        }
}
