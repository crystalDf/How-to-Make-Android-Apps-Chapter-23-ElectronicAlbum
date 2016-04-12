package com.star.electronicalbum;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.UUID;


public class PhotoFragment extends Fragment {

    private static final String ARG_PHOTO_ID = "photo_id";

    private Photo mPhoto;
    private ImageView mImageView;

    public static PhotoFragment newInstance(UUID photoId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PHOTO_ID, photoId);

        PhotoFragment photoFragment = new PhotoFragment();
        photoFragment.setArguments(args);

        return photoFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UUID photoId = (UUID) getArguments().getSerializable(ARG_PHOTO_ID);

        mPhoto = PhotoLab.getInstance(getContext()).getPhoto(photoId);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_photo, container, false);

        mImageView = (ImageView) view.findViewById(R.id.photo_image_view);

        return view;
    }

}
