package com.example.koyama.picturememo.photos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.koyama.picturememo.R;

public class PhotoDetailActivity extends AppCompatActivity {
    private PhotoDetailPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ビューを配置
        // add_photo_act は add_photo_frag が1つあるだけ
        setContentView(R.layout.photo_detail_act);

        // ビューを指定して fragment を生成
        PhotoDetailFragment fragment = (PhotoDetailFragment)getSupportFragmentManager().findFragmentById(R.id.photo_detail_frag);

        // プレゼンターを生成
        mPresenter = new PhotoDetailPresenter();

        // ギャラリーを開く
        //showPicker();

    }
}
