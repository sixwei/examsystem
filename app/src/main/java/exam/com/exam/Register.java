package exam.com.exam;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.net.URLEncoder;

/**
 * Created by gzw on 2018/4/16.
 */

public class Register extends AppCompatActivity implements View.OnClickListener {

    private Button btn1,btn2;
    private EditText editText1,editText2,editText3;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        if (editText2==editText3)
        creatNewUser();
        else {
            System.out.print("兩次密碼不一致");
            Toast.makeText(this,"兩次密碼不一樣",Toast.LENGTH_SHORT).show();
        }
    }

    private void init(){
        btn1=findViewById(R.id.register_btn_sure);
        btn2=findViewById(R.id.register_btn_cancel);
        editText1 = findViewById(R.id.register_uname);
        editText2 = findViewById(R.id.register_password);
        editText3 = findViewById(R.id.register_password_check);
    }

    private void creatNewUser(){
        new Thread(){
            public void run() {
                try{
                    String uname = editText1.getText().toString().trim();
                    String password = editText2.getText().toString().trim();
                    String path = "/user/create";
                    String data = "uname="+ URLEncoder.encode(uname,"utf-8")+"$password="+password;
                    HttpURLConnection connection = Tools.createLink(path,data);

                    int code = connection.getResponseCode();
                    if (code==200){
                        Tools.showToast(Register.this,"用户创建成功");
                    }
                    else
                        Tools.showToast(Register.this,"服务器出现错误");

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }.start();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.register_btn_sure:
                creatNewUser();
                Intent intent = new Intent (Register.this,Index.class);
                startActivity(intent);
                finish();
            case R.id.register_btn_cancel:
                Intent intent1 = new Intent(Register.this,MainActivity.class);
                startActivity(intent1);
                finish();
        }

    }
}
