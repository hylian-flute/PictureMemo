package com.example.koyama.picturememo.addphoto;

import android.net.Uri;

public interface AddPhotoContract {
    interface View{
        void setPresenter(Presenter presenter);
        void showPhoto(Uri photoImage);
    }

    interface Presenter{
        void start();
        void savePhoto(String memo);
    }

    interface Activity{
        void showPicker();
        void finishWithResult(Boolean result);
    }
}
