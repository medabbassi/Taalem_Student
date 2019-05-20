package com.yoo_devit.taalem_student.Activites.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yoo_devit.taalem_student.CourseFragment;
import com.yoo_devit.taalem_student.FilesFragment;

public class PageAdapter extends FragmentPagerAdapter {


        private int numOfTabs;

        public PageAdapter(FragmentManager fm, int numOfTabs) {
            super(fm);
            this.numOfTabs = numOfTabs;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new CourseFragment();
                case 1:
                    return new FilesFragment();

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return numOfTabs;
        }
    }

