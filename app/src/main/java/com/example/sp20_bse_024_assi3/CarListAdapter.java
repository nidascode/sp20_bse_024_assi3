package com.example.sp20_bse_024_assi3;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.VideoViewHolder> {
    private DataViewModel dataViewModel;

    public CarListAdapter(DataViewModel dataViewModel) {
        this.dataViewModel = dataViewModel;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Creating the layout for the single item of recyclerview
        LinearLayout itemLayout = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);
        return new VideoViewHolder(itemLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        TextView singleVideoName = holder.singleVideoName;
        singleVideoName.setText(dataViewModel.getCarVideos()[position].name);
    }

    @Override
    public int getItemCount() {
        return dataViewModel.getCarVideos().length;
    }

    class VideoViewHolder extends RecyclerView.ViewHolder {
        TextView singleVideoName;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            singleVideoName = itemView.findViewById(R.id.singleListItem);

            singleVideoName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dataViewModel.setPlayingVideoIndex(getAdapterPosition());
                }
            });
        }

    }
}
