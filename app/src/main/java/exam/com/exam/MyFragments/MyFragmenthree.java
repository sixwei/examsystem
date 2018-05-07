package exam.com.exam.MyFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import exam.com.exam.QuestionTab.ChapterShow;
import exam.com.exam.QuestionTab.OnlineShow;
import exam.com.exam.QuestionTab.RandomShow;
import exam.com.exam.R;


/**
 * Created by gzw on 2018/4/28.
 */

public class MyFragmenthree extends Fragment implements View.OnClickListener {

//    public MyFragmenthree() {
//    }


    private RelativeLayout rl_random;
    private RelativeLayout rl_chapter;
    private RelativeLayout rl_online;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_ques);

        //bindViewAndListener();
        View view = inflater.inflate(R.layout.activity_ques, container, false);
        //TextView txt_content = (TextView) view.findViewById(R.id.text_content);
        //txt_content.setText("第三个Fragment");
        //Log.e("HEHE", "1日狗");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rl_random = getActivity().findViewById(R.id.rl_random);
        rl_chapter =  getActivity().findViewById(R.id.rl_chapter);
        rl_online =  getActivity().findViewById(R.id.rl_online);
        rl_random.setOnClickListener(this);
        rl_chapter.setOnClickListener(this);
        rl_online.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.rl_random:
                Intent intent = new Intent(getActivity(), RandomShow.class);
                startActivity(intent);
                break;
            case R.id.rl_chapter:
                Intent intent1 = new Intent(getActivity(), ChapterShow.class);
                startActivity(intent1);

                break;
            case R.id.rl_online:
                Intent intent2 = new Intent(getActivity(), OnlineShow.class);
                startActivity(intent2);
                break;
        }


    }

}

