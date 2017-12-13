package com.yyxk.xlog;

import android.util.Log;

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
 * <p>
 * 项目名称：XLogText
 * 包名:com.yyxk.xlog
 * 类描述：
 * 创建人：LX
 * 创建时间：2017/12/12 下午5:21
 * 修改人：LX
 * 修改时间：2017/12/12 下午5:21
 * 修改备注：
 */

public class LoggerPrinter {

    private static int MAX_LENGTH = 4000;

    public static void defaultPrint(int type, String msg, String tag) {
        int index = 0;
        int length = msg.length();
        int count = length / MAX_LENGTH;
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                String sub = msg.substring(index, index + MAX_LENGTH);
                print(type, tag, sub);
                index += MAX_LENGTH;
            }
            print(type, tag, msg.substring(index, length));
        } else {
            print(type, tag, msg);
        }
    }

    private static void print(int type, String tag, String msg) {
        switch (type) {
            case XLog.V:
                Log.v(tag, msg);
                break;
            case XLog.D:
                Log.d(tag, msg);
                break;
            case XLog.I:
                Log.i(tag, msg);
                break;
            case XLog.E:
                Log.e(tag, msg);
                break;
            case XLog.W:
                Log.w(tag, msg);
                break;
            case XLog.WTF:
                Log.wtf(tag, msg);
                break;
        }
    }

}
