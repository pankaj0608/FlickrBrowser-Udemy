package com.example.pankaj.flickrbrowser;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by pankaj on 6/30/2017.
 */
public class FlickrRecyclerViewAdpter
        extends RecyclerView.Adapter<FlickrImageViewHolder> {

    private Context mContext;
    private List<Photo> mPhotoList;

    public FlickrRecyclerViewAdpter(Context mContext, List<Photo> mPhotoList) {
        this.mContext = mContext;
        this.mPhotoList = mPhotoList;
    }

    @Override
    public FlickrImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view =
                LayoutInflater.from(
                        viewGroup.getContext()).inflate(R.layout.browse, null);

        FlickrImageViewHolder flickrImageViewHolder = new FlickrImageViewHolder(view);

        return flickrImageViewHolder;
    }

    @Override
    public void onBindViewHolder(FlickrImageViewHolder flickrImageViewHolder, int position) {

        Photo photoItem = mPhotoList.get(position);
        Picasso.with(mContext).load(photoItem.getmImage()).
                error(R.drawable.placeholder).
                placeholder(R.drawable.placeholder)
        .into(flickrImageViewHolder.thumbnail);

        flickrImageViewHolder.title.setText(photoItem.getmTitle());
    }

    @Override
    public int getItemCount() {
        return mPhotoList == null ? 0 : mPhotoList.size();
    }
}
