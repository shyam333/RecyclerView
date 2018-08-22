package com.abiramiaudio.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements YouTubeThumbnailView.OnInitializedListener {

    Context context;
    List<Book>mData;
    private YouTubeThumbnailView youTubeThumbnailView;
    private YouTubeThumbnailLoader youTubeThumbnailLoader;

    public MyAdapter(Context context, List<Book> mData) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflator = LayoutInflater.from(context);
        view = mInflator.inflate(R.layout.card_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.mImageView.setImageResource(mData.get(position).getImage());
        holder.mTextview.setText(mData.get(position).getTitle());

//        holder.mCardview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
////                Intent intent = new Intent(mContext,PlayerActivity.class);
////                intent.putExtra("key",holder.mTextview.getText().toString());
////               // intent.putExtra("key",mData.get(position).getTitle());
////                mContext.startActivity(intent);
//
//            }
//        });

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {

    }

    @Override
    public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextview;
        public CardView mCardview;



        public MyViewHolder(final View v1) {
            super(v1);
            mImageView = (ImageView) v1.findViewById(R.id.imageview);
            mTextview = (TextView)v1.findViewById(R.id.textview);
            mCardview = (CardView)v1.findViewById(R.id.cardview);

            mCardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String value = mTextview.getText().toString();
                    Intent intent = new Intent(context,PlayerActivity.class);
                    intent.putExtra("key",value);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    // intent.putExtra("key",mData.get(position).getTitle());
                    context.startActivity(intent);
                }
            });
        }


    }
}
