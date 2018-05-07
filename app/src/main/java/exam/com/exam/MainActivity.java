package exam.com.exam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import exam.com.exam.QuestionTab.ChapterShow;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn1;
    private Button btn2;
    private EditText editText1,editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);


    }

    //初始化组件
    private void bindView(){
        btn1=findViewById(R.id.login_btn_login);
        btn2 = findViewById(R.id.login_btn_register);
        editText1=findViewById(R.id.login_edit_account);
        editText2=findViewById(R.id.login_edit_pwd);
    }

    //监听事件
    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.login_btn_login:
               login2();
              // login();
               //用于测试chapter_content_item的样式布局
               //loginchaapter_content_item();

               break;
           case R.id.login_btn_register:
               Intent intent = new Intent(MainActivity.this,Register.class);
               startActivity(intent);
               finish();
       }

    }


    //测试用例直接用于跳转
    public void login2(){
        Intent intent = new Intent(MainActivity.this,Index.class);
        startActivity(intent);
        finish();
    }

    private void loginchaapter_content_item(){
        Intent intent = new Intent(MainActivity.this,ChapterShow.class);
        startActivity(intent);
        finish();
    }


    /**
     * 登录界面的设计，和index的跳转
     * 这是与服务器进行连接时的部分
     */
    public void login(){
        if (isUserNameAndPwdValid()){
            new Thread(){
                public void run(){
                    try {
                        //获取密码和用户
                        String uname = editText1.getText().toString().trim();
                        String password = editText2.getText().toString().trim();
                        String data = "uname="+ URLEncoder.encode(uname,"utf-8")+"$password="+password;
                        String path = "user/login";
                        URL url = new URL(path);

                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("POST");
                        conn.setConnectTimeout(5000);
                        //设置头信息
                        conn.setRequestProperty("Content-Type","application/x-www-form-urlencode");
                        conn.setRequestProperty("Content-Length",data.length()+"");
                        conn.setDoOutput(true);
                        conn.getOutputStream().write(data.getBytes());
                        System.out.print(path);

                        int code = conn.getResponseCode();
                        if (code==200){
                            InputStream in = conn.getInputStream();
                            showToast("登录成功");
                            Intent intent = new Intent(MainActivity.this,Index.class);
                            startActivity(intent);
                            finish();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    //设置Toast的同一调用
    public void showToast(final String content){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "content", Toast.LENGTH_SHORT).show();
            }
        });

    }


    //判断用户和密码是否为空

    public boolean isUserNameAndPwdValid(){

        return true;

    }
}
