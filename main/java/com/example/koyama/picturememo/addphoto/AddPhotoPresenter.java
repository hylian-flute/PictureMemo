package com.example.koyama.picturememo.addphoto;

import android.net.Uri;

import com.example.koyama.picturememo.data.PhotoRepository;

public class AddPhotoPresenter implements AddPhotoContract.Presenter {
    private final PhotoRepository mPhotosRepository;
    private final AddPhotoContract.View mAddPhotoView;
    private final AddPhotoContract.Activity mAddPhotoActivity;

    private boolean mIsStarted = false;

    public AddPhotoPresenter(PhotoRepository photosRepository,
                             AddPhotoContract.View addPhotoView,
                             AddPhotoContract.Activity addPhotoActivity){
        mPhotosRepository = photosRepository;
        mAddPhotoView = addPhotoView;
        mAddPhotoActivity = addPhotoActivity;
        mAddPhotoView.setPresenter(this);
    }

    public void start(){
        // バックグラウンドからの復帰時に無効
        if(!mIsStarted){
            // 写真選択画面を呼び出す
            mAddPhotoActivity.showPicker();
            mIsStarted = true;
        }
    }

    public void savePhoto(String memo){
        mPhotosRepository.savePhoto(memo);
        mAddPhotoActivity.finishWithResult(true);
    }

    // 写真が選ばれてActivityに帰ってきたときに実行
    public void result(boolean result, Uri uri){
        if(!result)
            return;

        mPhotosRepository.setTemporaryPhoto(uri);
        mAddPhotoView.showPhoto(uri);
    }
}
