package exam.com.exam;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import exam.com.exam.MyFragments.MyFragmentPageAdapter;


/**
 * Created by gzw on 2018/4/16.
 */

public class Index extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener {

    //对于各种标签的定义
    private TextView txt_topbar;
    private RadioGroup rg_top_bat;
    private RadioButton rb_indexshow;
    private RadioButton rb_collect;
    private RadioButton rb_question;
    private RadioButton rb_mi;
    private ViewPager vpage;


    private MyFragmentPageAdapter myAdapter;

    //几个代表页面的常量

    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_index);
        myAdapter = new MyFragmentPageAdapter(getSupportFragmentManager());
        bindViews();
        rb_indexshow.setChecked(true);
    }

    //对于view的初始化
    private void bindViews(){
        //txt_topbar = findViewById(R.id.txt_topbar);
        rg_top_bat = findViewById(R.id.rg_tab_bar);
        rb_indexshow  = findViewById(R.id.rb_indexshow);
        rb_collect = findViewById(R.id.rb_collect);
        rb_question = findViewById(R.id.rb_question);
        rb_mi = findViewById(R.id.rb_mi);
        rg_top_bat.setOnCheckedChangeListener(this);

        vpage = findViewById(R.id.vpager);
        vpage.setAdapter(myAdapter);
        vpage.setCurrentItem(0);
        vpage.addOnPageChangeListener(this);

    }



    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId){
            case R.id.rb_indexshow:
                vpage.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rb_collect:
                vpage.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rb_question:
                vpage.setCurrentItem(PAGE_THREE);
                break;
            case R.id.rb_mi:
                vpage.setCurrentItem(PAGE_FOUR);
                break;
        }

    }

    //重写viewPage页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三种，0表示什么都没做，1表示正在滑动，2滑动完成

        if (state == 2){
            switch(vpage.getCurrentItem()){
                case PAGE_ONE:
                    rb_indexshow.setChecked(true);
                    break;
                case PAGE_TWO:
                    rb_collect.setChecked(true);
                    break;
                case PAGE_THREE:
                    rb_question.setChecked(true);
                    break;
                case PAGE_FOUR:
                    rb_mi.setChecked(true);
                    break;

            }
        }

    }
}
