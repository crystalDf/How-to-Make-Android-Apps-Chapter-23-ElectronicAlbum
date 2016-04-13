package com.star.electronicalbum;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.UUID;

public class PhotoPagerActivity extends FragmentActivity {

    private static final String EXTRA_PHOTO_ID = "photo_id";

    private ViewPager mViewPager;
    private List<Photo> mPhotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_pager);

        UUID photoId = (UUID) getIntent().getSerializableExtra(EXTRA_PHOTO_ID);

        mViewPager = (ViewPager) findViewById(R.id.activity_photo_view_pager);

        mPhotos = PhotoLab.getInstance(this).getPhotos();

        FragmentManager fragmentManager = getSupportFragmentManager();

        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Photo photo = mPhotos.get(position);
                return PhotoFragment.newInstance(photo.getId());
            }

            @Override
            public int getCount() {
                return mPhotos.size();
            }
        });

        for (int i = 0; i < mPhotos.size(); i++) {
            if (mPhotos.get(i).getId().equals(photoId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }

    public static Intent newIntent(Context context, UUID crimeId) {
        Intent intent = new Intent(context, PhotoPagerActivity.class);
        intent.putExtra(EXTRA_PHOTO_ID, crimeId);
        return intent;
    }
}
