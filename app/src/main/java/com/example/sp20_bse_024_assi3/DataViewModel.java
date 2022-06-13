package com.example.sp20_bse_024_assi3;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DataViewModel extends ViewModel {
    private MutableLiveData<Integer> playingVideoIndex = new MutableLiveData<>();

    private final CarVideo[] videos = {
            new CarVideo(R.raw.bmw, "BMW"),
            new CarVideo(R.raw.ferrari, "Ferrari"),
            new CarVideo(R.raw.lamborghini, "Lamborghini"),
            new CarVideo(R.raw.mclaren, "McLaren"),
    };

    public CarVideo[] getCarVideos() {
        return videos;
    }

    public MutableLiveData<Integer> getPlayingVideoIndex() {
        return playingVideoIndex;
    }

    public void setPlayingVideoIndex(int index) {
        this.playingVideoIndex.setValue(index);
    }
}
