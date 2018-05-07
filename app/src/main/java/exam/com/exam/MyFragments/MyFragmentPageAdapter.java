package exam.com.exam.MyFragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import exam.com.exam.Index;


/**
 * Created by gzw on 2018/4/28.
 */

public class MyFragmentPageAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 4;

    private MyFragmentone myFragmentone;
    private MyFragmenttwo myFragmenttwo;
    private MyFragmenthree myFragmenthree;
    private MyFragmentfour myFragmentfour;

    public MyFragmentPageAdapter(FragmentManager fm) {
        super(fm);
        myFragmentone = new MyFragmentone();
        myFragmenttwo = new MyFragmenttwo();
        myFragmenthree = new MyFragmenthree();
        myFragmentfour = new MyFragmentfour();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch(position){
            case Index.PAGE_ONE:
                fragment = myFragmentone;
                break;
            case Index.PAGE_TWO:
                fragment = myFragmenttwo;
                break;
            case Index.PAGE_THREE:
                fragment = myFragmenthree;
                break;
            case Index.PAGE_FOUR:
                fragment = myFragmentfour;
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup viewGroup,int position){
        return super.instantiateItem(viewGroup,position);
    }

    @Override
    public void destroyItem(ViewGroup viewGroup,int position,Object obj){
        System.out.println("position destory"+position);
        super.destroyItem(viewGroup,position,obj);
    }


}
