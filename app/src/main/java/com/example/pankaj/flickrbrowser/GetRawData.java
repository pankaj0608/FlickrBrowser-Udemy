package com.example.pankaj.flickrbrowser;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by pankaj on 6/28/2017.
 */
enum DownloadStatus {
    IDLE, PROCESSING, NOT_INITIALSED, FAILED_OR_EMPTY, OK
}

public class GetRawData {

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

    public void execute() {
        this.mDownloadStatus = DownloadStatus.PROCESSING;
        DownloadRawData downloadRawData = new DownloadRawData();
        downloadRawData.execute(this.mRawUrl);
    }

    public String getmData() {
        return mData;
    }

    public DownloadStatus getmDownloadStatus() {
        return mDownloadStatus;
    }

    public class DownloadRawData extends AsyncTask<String, Void, String> {

        @Override
        protected void onPostExecute(String webData) {
            mData = webData;
            Log.v(LOG_TAG, mData);
            System.out.println(mData);

        }

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            if (params == null) {
                return null;
            }

            try {

                URL url = new URL(params[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();

                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;

                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }

                return buffer.toString();

            } catch (Exception e) {
                Log.e(LOG_TAG, e.getMessage());
                return null;

            } finally {
                if (urlConnection != null)
                    urlConnection.disconnect();

                if (reader != null)
                    try {
                        reader.close();
                    } catch (Exception e) {
                        Log.e(LOG_TAG, e.getMessage());
                    }
            }


        }
    }
}
