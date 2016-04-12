package com.star.electronicalbum;


import android.graphics.Bitmap;

import java.util.UUID;

public class Photo {

    private UUID mId;
    private Bitmap mBitmap;

    public Photo() {
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public Bitmap getBitmap() {
        return mBitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        mBitmap = bitmap;
    }
}
