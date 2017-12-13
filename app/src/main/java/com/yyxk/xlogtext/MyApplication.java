package com.yyxk.xlogtext;

import android.app.Application;

import com.yyxk.xlog.LogListener;
import com.yyxk.xlog.XLog;

/**
 * ----------Dragon be here!----------/
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━
 * 项目名称：XLogText
 * 包名:com.yyxk.xlogtext
 * 类描述：
 * 创建人：LX
 * 创建时间：2017/12/12 下午5:28
 * 修改人：LX
 * 修改时间：2017/12/12 下午5:28
 * 修改备注：
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        XLog.init(true,"123");
        XLog.init(true, "123", new LogListener() {
            @Override
            public void whenLogPrint(int type, String tag, String msg, String header) {
                //TODO 记录日志、上传等操作
                //这里使用XLog打印的日志不会调用whenLogPrint()
                XLog.i("日志正常打印");
            }
        });
    }
}
