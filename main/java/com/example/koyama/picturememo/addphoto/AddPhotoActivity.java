package com.example.koyama.picturememo.addphoto;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.koyama.picturememo.R;
import com.example.koyama.picturememo.data.PhotoRepository;

public class AddPhotoActivity extends AppCompatActivity implements AddPhotoContract.Activity{
    private final int REQUEST_PICTURE_CHOICE = 1;
    public static final int REQUEST_ADD_PHOTO = 2;
    private AddPhotoPresenter mPresenter;

    // アプリ起動時に一番最初に呼ばれるメソッド
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ビューを配置
        // add_photo_act は add_photo_frag が1つあるだけ
        setContentView(R.layout.add_photo_act);

        // ビューを指定して fragment を生成
        AddPhotoFragment fragment = (AddPhotoFragment)getSupportFragmentManager().findFragmentById(R.id.add_photo_frag);

        // プレゼンターを生成
        mPresenter = new AddPhotoPresenter(PhotoRepository.getInstance(), fragment, this);

        // ギャラリーを開く
        //showPicker();

    }

    /* ギャラリーを開く intent 呼び出し */
    public void showPicker(){
        // Androidの写真を選択する機能を指定
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/jpeg");

        // 写真を選んだ結果を受け取って onActivityResult へ
        startActivityForResult(intent, REQUEST_PICTURE_CHOICE);
    }

    /* 結果を受け取るための callback 関数 */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode != REQUEST_PICTURE_CHOICE)
            return;

        if(resultCode != RESULT_OK)
            return;

        /*
            data の getData() で選択された画像の URI が取れるので、
            それを ImageView に設定すれば画像が表示される。
         */
        Uri uri = data.getData();
        mPresenter.result(resultCode == RESULT_OK, uri);


        //ImageView imageView = findViewById(R.id.addPhotoImageView);
        //imageView.setImageURI(uri);
        //mFragment.showPhoto(uri);
    }

    public void finishWithResult(Boolean result){
        Intent intent = new Intent();
        setResult((result) ? RESULT_OK : RESULT_CANCELED, intent);
        finish();
    }
}
