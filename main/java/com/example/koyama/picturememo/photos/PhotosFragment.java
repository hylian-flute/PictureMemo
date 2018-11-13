package com.example.koyama.picturememo.photos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.koyama.picturememo.R;
import com.example.koyama.picturememo.data.PhotoData;

import java.util.ArrayList;

public class PhotosFragment extends Fragment {
    private PhotosAdapter mAdapter = null;
    private PhotosPresenter mPresenter;

    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        mAdapter = new PhotosAdapter(new ArrayList<PhotoData>(0), mPhotoItemListener);
    }

    public void setPresenter(PhotosPresenter presenter){
        mPresenter = presenter;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.photos_frag, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.photoRecyclerView);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ItemTouchHelper touchHelper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT){
                    @Override
                    public boolean onMove(RecyclerView view, RecyclerView.ViewHolder holder,
                                          RecyclerView.ViewHolder target){
                        return false;
                    }

                    @Override
                    public void onSwiped(RecyclerView.ViewHolder holder, int direction){
                        int index = holder.getAdapterPosition();
                        mPresenter.removePhoto(index);
                    }
                }
        );
        touchHelper.attachToRecyclerView(recyclerView);
        FloatingActionButton fab = root.findViewById(R.id.showGalleryFab);

        // ボタンのイベントリスナー
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mPresenter.showGallery();
            }
        });


        return root;
    }

    private final PhotosAdapter.Listener mPhotoItemListener = new PhotosAdapter.Listener(){
        @Override
        public void onItemClicked(int index){
            mPresenter.openPhotoDetails(index);
        }
    };

}
