package ch.swissonid.design_lib_sample.adapters;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import ch.swissonid.design_lib_sample.R;

public class MusicCardRVArrayAdapter extends RecyclerView.Adapter<MusicCardRVArrayAdapter.ViewHolder> {

    private @DrawableRes int[] mData;

    public MusicCardRVArrayAdapter(@DrawableRes int[] data){
        mData = data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.music_card, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Context context = holder.mImageView.getContext();
        Picasso.with(context)
                .load(mData[position])
                .resizeDimen(R.dimen.image_width,R.dimen.image_height)
                .centerCrop()
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = ButterKnife.findById(itemView, R.id.imageView);
        }
    }
}
