package com.example.koyama.picturememo.addphoto;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.koyama.picturememo.R;

public class AddPhotoFragment extends Fragment implements AddPhotoContract.View{
    private static ImageView mImageView;
    private EditText mEditText;
    private AddPhotoContract.Presenter mPresenter;

    public void setPresenter(AddPhotoContract.Presenter presenter){
        mPresenter = presenter;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        // レイアウト add_photo_frag をインスタンス化
        View root = inflater.inflate(R.layout.add_photo_frag, container, false);
        mImageView = root.findViewById(R.id.addPhotoImageView);
        mEditText = root.findViewById(R.id.addPhotoMemoEditText);
        FloatingActionButton fab = root.findViewById(R.id.addPhotoFab);

        // ボタンのイベントリスナー
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mPresenter.savePhoto(mEditText.getText().toString());
            }
        });

        return root;
    }

    @Override
    public void onResume(){
        super.onResume();
        mPresenter.start();
    }

    public void showPhoto(Uri photoImage){
        mImageView.setImageURI(photoImage);
    }
}
