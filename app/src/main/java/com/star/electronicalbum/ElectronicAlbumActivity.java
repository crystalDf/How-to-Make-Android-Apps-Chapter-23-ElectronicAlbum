package com.star.electronicalbum;

import android.support.v4.app.Fragment;

public class ElectronicAlbumActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ElectronicAlbumFragment();
    }
}
