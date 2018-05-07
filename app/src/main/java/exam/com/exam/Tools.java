package exam.com.exam;

import android.content.Context;
import android.os.Looper;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by gzw on 2018/4/16.
 */

public class Tools {


    //进行建立连接的公共方法，路径，数据
    static public HttpURLConnection createLink(String path,String data) throws Exception{

        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setConnectTimeout(5000);
        //设置头信息
        conn.setRequestProperty("Content-Type","application/x-www-form-urlencode");
        conn.setRequestProperty("Content-Length",data.length()+"");
        conn.setDoOutput(true);
        conn.getOutputStream().write(data.getBytes());
        return conn;
    }

    //显示提示信息
    static public void showToast(Context context,String content){

        Looper.prepare();
        Handler handler = new Handler() {
            @Override
            public void publish(LogRecord logRecord) {

            }

            @Override
            public void flush() {

            }

            @Override
            public void close() throws SecurityException {

            }


        };

    }


    //用于进行页面转换用Intent无参




}
