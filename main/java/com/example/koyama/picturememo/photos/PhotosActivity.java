package com.example.koyama.picturememo.photos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.koyama.picturememo.R;
import com.example.koyama.picturememo.addphoto.AddPhotoActivity;

public class PhotosActivity extends AppCompatActivity{
    private PhotosPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ビューを配置
        setContentView(R.layout.photos_act);

        // ビューを指定して fragment を生成
        PhotosFragment fragment = (PhotosFragment)getSupportFragmentManager().findFragmentById(R.id.photos_frag);

        // プレゼンターを生成
        mPresenter = new PhotosPresenter(this, fragment);

        // ギャラリーを開く
        //showPicker();

    }

    public void showAddPhoto(){
        Intent intent = new Intent(this, AddPhotoActivity.class);
        startActivityForResult(intent, AddPhotoActivity.REQUEST_ADD_PHOTO);
    }
}
