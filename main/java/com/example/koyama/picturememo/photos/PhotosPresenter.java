package com.example.koyama.picturememo.photos;

import com.example.koyama.picturememo.data.PhotoData;
import com.example.koyama.picturememo.data.PhotoRepository;

import java.util.List;

public class PhotosPresenter {
    private PhotoRepository mPhotoRepository;
    private PhotosFragment mPhotosView;
    private PhotosActivity mActivity;

    /*
    public void start(){
        List<PhotoData> photos = mPhotoRepository.getPhotos();
        mPhotosView.showPhotos(photos);
    }
    */
    public PhotosPresenter(PhotosActivity activity, PhotosFragment fragment){
        fragment.setPresenter(this);
        mActivity = activity;
        mPhotoRepository = PhotoRepository.getInstance();
    }

    public void showGallery(){
        mActivity.showAddPhoto();
    }

    public void removePhoto(int index){

    }

    public void openPhotoDetails(int index){

    }
}
