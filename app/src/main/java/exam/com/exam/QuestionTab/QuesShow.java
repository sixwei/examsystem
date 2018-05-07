package exam.com.exam.QuestionTab;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import exam.com.exam.R;


/**
 * Created by gzw on 2018/4/28.
 * 题库的相关操作，随机练习，章节练习，在线考试
 * 进行页面的跳转
 */

public class QuesShow extends AppCompatActivity implements View.OnClickListener{


    private RelativeLayout rl_chapter;

    private RelativeLayout rl_random;

    private RelativeLayout rl_online;



    @SuppressLint("ResourceType")
    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.id.activity_ques);
        bindViewAndClick();
    }


    //View绑定和设置监听
    private void bindViewAndClick(){
        rl_chapter = findViewById(R.id.rl_chapter);
        rl_chapter.setOnClickListener(this);
        rl_random = findViewById(R.id.rl_random);
        rl_random.setOnClickListener(this);
        rl_online = findViewById(R.id.rl_online);
        rl_online.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_chapter:
                change(ChapterShow.class);
                break;
            case R.id.rl_random:
                change(RandomShow.class);
                break;
            case R.id.rl_online:
                change(OnlineShow.class);
                break;


        }

    }

    //页面的切换
    public void change(Class clazz){
        Intent intent = new Intent(QuesShow.this,clazz);
        startActivity(intent);
        finish();
    }
}
