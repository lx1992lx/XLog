package com.yyxk.xlogtext;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

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
 * 创建时间：2017/12/12 下午5:27
 * 修改人：LX
 * 修改时间：2017/12/12 下午5:27
 * 修改备注：
 */

public class JavaActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.i("以下是打印JSON");
        LogUtil.i("{\"code\":\"this is JavaActivity\",\"data\":{\"code\":123}}");
        LogUtil.i("以下是打印带一段文字的JSON");
        LogUtil.i("这是请求数据：{\"code\":\"this is JavaActivity\",\"data\":{\"code\":123}}");
    }
}
