package com.example.pankaj.flickrbrowser;

/**
 * Created by pankaj on 6/28/2017.
 */
enum DownloadStatus {IDLE, PROCESSING, NOT_INITIALSED, FAILED_OR_EMPTY, OK}

public class GetRawData {
    String URL = "https://api.flickr.com/services/" +
            "feeds/photos_public.gne?format=json&nojsoncallback=1";

    private String LOG_TAG = GetRawData.class.getSimpleName();
    private String mRawUrl;
    private String mData;
    private DownloadStatus mDownloadStatus;

    public GetRawData(String mRawUrl) {
        this.mRawUrl = mRawUrl;
        this.mDownloadStatus = DownloadStatus.IDLE;
    }

    public void reset() {
        this.mDownloadStatus = DownloadStatus.IDLE;
        this.mRawUrl = null;
        this.mData = null;
    }

    public String getmData() {
        return mData;
    }

    public DownloadStatus getmDownloadStatus() {
        return mDownloadStatus;
    }

}
