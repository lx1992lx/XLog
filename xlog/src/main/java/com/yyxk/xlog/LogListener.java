package com.yyxk.xlog;

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
 * 项目名称：LxLogTest
 * 包名:com.yyxk.lxlog
 * 类描述：
 * 创建人：LX
 * 创建时间：2017/12/11 下午4:21
 * 修改人：LX
 * 修改时间：2017/12/11 下午4:21
 * 修改备注：
 */

public interface LogListener {
    /**
     * Log记录监听
     * @param type  类型 v、d、i、w、e
     * @param tag   标签
     * @param msg   日志内容
     * @param header    日志抬头
     */
    void whenLogPrint(int type, String tag, String msg, String header);
}
