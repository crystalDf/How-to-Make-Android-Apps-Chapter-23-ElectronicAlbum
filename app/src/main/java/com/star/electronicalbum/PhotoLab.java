package com.star.electronicalbum;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PhotoLab {

    private static PhotoLab sPhotoLab;

    private List<Photo> mPhotos;

    public PhotoLab(Context context) {
        mPhotos = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Photo photo = new Photo();
            mPhotos.add(photo);
        }
    }

    public static PhotoLab getInstance(Context context) {
        if (sPhotoLab == null) {
            synchronized (PhotoLab.class) {
                if (sPhotoLab == null) {
                    sPhotoLab = new PhotoLab(context);
                }
            }
        }
        return sPhotoLab;
    }

    public List<Photo> getPhotos() {
        return mPhotos;
    }

    public Photo getPhoto(UUID id) {
        for (Photo photo : mPhotos) {
            if (photo.getId().equals(id)) {
                return photo;
            }
        }
        return null;
    }
}
