package com.example.sp20_bse_024_assi3;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

public class VideoFragment extends Fragment {
    DataViewModel dataViewModel;
    VideoView videoView;

    public VideoFragment() {
        // Required empty public constructor
    }

    public static VideoFragment newInstance() {
        return new VideoFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video, container, false);

        videoView = view.findViewById(R.id.video_view);

        dataViewModel = new ViewModelProvider(requireActivity()).get(DataViewModel.class);

        dataViewModel.getPlayingVideoIndex().observe(requireActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable final Integer playingVideoIndex) {
                if(playingVideoIndex == null) {
                    return;
                }

                CarVideo video = dataViewModel.getCarVideos()[playingVideoIndex];
                Uri uri = Uri.parse("android.resource://" + requireActivity().getPackageName() + "/" + video.id);
                videoView.setVideoURI(uri);
                videoView.start();
            }
        });
        return view;
    }
}