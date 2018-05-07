package exam.com.exam.QuestionTab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.util.List;

import exam.com.exam.R;
import exam.com.exam.entity.Chapter;

/**
 * Created by gzw on 2018/4/28.
 */

public class ChapterShow extends Activity {

    private ListView listView;
    private List<Chapter> chapters;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.chapter_content);
        listView = findViewById(R.id.chapter_content_class);
        initListData();
    }

    private void initListData(){
        new Thread(){
            public void run(){
                try {


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            listView.setAdapter(new MyAdapter());
                        }
                    });

                }catch(Exception e){
                    e.printStackTrace();
                }
            };
        }.start();
    }

    private class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            //return chapters.size();
            return 3;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }


        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1;
            if (view == null){
                view1 = View.inflate(getApplicationContext(),R.layout.chapter_content_item,null);
            }else{
                view1 = view;
            }
            //找到控件
            TextView chapter_class = view1.findViewById(R.id.chapter_content_item_text);
            view1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ChapterShow.this,Question.class);
                    //传递参数进行不同的处理
                    startActivity(intent);
                    finish();
                }
            });

            //数据的添加
            //chapter_class.setText("数据");

            return view1;
        }
    }

}
