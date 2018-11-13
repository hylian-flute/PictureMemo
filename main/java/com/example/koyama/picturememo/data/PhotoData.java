package com.example.koyama.picturememo.data;

import android.net.Uri;

public class PhotoData {
    private final Uri mImageUri;
    private final String mMemo;

    public PhotoData(Uri uri, String memo){
        mImageUri = uri;
        mMemo = memo;
    }

    public Uri getImage(){
        return mImageUri;
    }

    public String getMemo(){
        return mMemo;
    }
}
