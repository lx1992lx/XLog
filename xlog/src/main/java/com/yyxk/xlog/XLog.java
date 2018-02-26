package com.yyxk.xlog;

import android.text.TextUtils;

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
 * 创建时间：2017/12/11 下午4:14
 * 修改人：LX
 * 修改时间：2017/12/11 下午4:14
 * 修改备注：
 */

public class XLog {
    public static final int V = 0x1;
    public static final int D = 0x2;
    public static final int I = 0x3;
    public static final int W = 0x4;
    public static final int E = 0x5;
    public static final int WTF = 0x6;

    public static String mDefautTag = "LxLog_TAG";
    public static String mGlobalTag;
    public static final String LOG_SPACE_LINE = "===================================";
    public static String mMainThreadName="main";

    public static String mListenerMethodName = "whenLogPrint";
    public static boolean IS_SHOW_LOG;//是否显示Log
    public static LogListener mLogListener;//日志打印监听器

    private static int STACK_TRACE_INDEX_5 = 5;
    /**
     * 初始化，建议在Application初始化时初始化
     *
     * @param isShowLog 是否显示Log
     * @param tag       标签
     */
    public static void init(boolean isShowLog, String tag) {
        if (TextUtils.isEmpty(tag)) {
            mGlobalTag = mDefautTag;
        } else {
            mGlobalTag = tag;
        }
        IS_SHOW_LOG = isShowLog;
    }

    /**
     * 初始化
     *
     * @param isShowLog 是否显示Log
     * @param tag       标签
     * @param listener  日志打印监听器
     */
    public static void init(boolean isShowLog, String tag, LogListener listener) {
        init(isShowLog, tag);
        if (listener != null) {
            mLogListener = listener;
        } else {
            throw new NullPointerException("LogListener must not be null");
        }
    }

    /**
     * 初始化
     * @param isShowLog
     * @param tag
     * @param listener
     * @param wrap 再次包装层级，需指定层级
     */
    public static void init(boolean isShowLog, String tag, LogListener listener,int wrap) {
        init(isShowLog, tag,listener);
        STACK_TRACE_INDEX_5+=wrap;
    }


    public static void i(String tag, Object objMsg) {
        printLog(I, objMsg, tag);
    }

    public static void i(Object objMsg) {
        printLog(I, objMsg, mGlobalTag);
    }

    public static void d(String tag, Object objMsg) {
        printLog(D, objMsg, tag);
    }

    public static void d(Object objMsg) {
        printLog(D, objMsg, mGlobalTag);
    }

    public static void e(String tag, Object objMsg) {
        printLog(E, objMsg, tag);
    }

    public static void e(Object objMsg) {
        printLog(E, objMsg, mGlobalTag);
    }

    public static void v(String tag, Object objMsg) {
        printLog(V, objMsg, tag);
    }

    public static void v(Object objMsg) {
        printLog(V, objMsg, mGlobalTag);
    }

    public static void w(String tag, Object objMsg) {
        printLog(W, objMsg, tag);
    }

    public static void w(Object objMsg) {
        printLog(W, objMsg, mGlobalTag);
    }

    public static void wtf(String tag, Object objMsg) {
        printLog(WTF, objMsg, tag);
    }

    public static void wtf(Object objMsg) {
        printLog(WTF, objMsg, mGlobalTag);
    }

    /**
     * 打印日志
     *
     * @param type
     * @param objMsg
     * @param tag
     */
    private static synchronized void printLog(int type,Object objMsg, String tag) {

        if (!IS_SHOW_LOG) {
            return;
        }

        if (objMsg == null) {
            objMsg = LOG_SPACE_LINE;
        }

        String[] content = createMsgHeader(STACK_TRACE_INDEX_5);
        String header=content[0];
        String methodName=content[1];
        String msg = createMsg(objMsg);

        LoggerPrinter.defaultPrint(type, msg, header + tag);

        if (mLogListener != null && !methodName.equals(mListenerMethodName)) {
            mLogListener.whenLogPrint(type, tag, msg, header);
        }
    }

    /**
     * 创建日志文本
     *
     * @param objMsg
     * @return
     */
    private static String createMsg(Object objMsg) {
        String msg;
        msg = objMsg.toString();
        String dJson = JsonFormat.detectJson(msg);
        if (dJson != null && dJson.equals(msg)) {
            msg = JsonFormat.format(msg);
        } else if (dJson != null && !dJson.equals(msg)) {
            msg = msg.substring(0, msg.indexOf(dJson)) + JsonFormat.format(dJson);
        }
        return msg;
    }


    /**
     * 创建日志Header
     *
     * @param stackTraceIndex
     * @return
     */
    private static String[] createMsgHeader(int stackTraceIndex) {
        String header;

        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[stackTraceIndex];
        int lineNumber = stackTraceElement.getLineNumber();
        String fileName = stackTraceElement.getFileName();
        String methodName = stackTraceElement.getMethodName();

        if (lineNumber < 0) {
            lineNumber = 0;
        }
        String threadName="";
        if(Thread.currentThread().getName().equals(mMainThreadName)){
            threadName="{ threadId="+Thread.currentThread().getId()+" }";
        }

        header = "[ (" + fileName + ":" + lineNumber + ")#" + methodName +threadName+ " ] ";

        return new String[]{header,methodName};
    }



}
