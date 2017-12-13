package com.yyxk.xlog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
 * 创建时间：2017/12/12 下午4:34
 * 修改人：LX
 * 修改时间：2017/12/12 下午4:34
 * 修改备注：
 */

public class JsonFormat {
    /**
     * 得到格式化json数据  退格用\t 换行用\r
     */
    public static String format(String jsonStr) {
        int level = 0;
        StringBuffer jsonForMatStr = new StringBuffer();
        for(int i=0;i<jsonStr.length();i++){
            char c = jsonStr.charAt(i);
            if(level>0&&'\n'==jsonForMatStr.charAt(jsonForMatStr.length()-1)){
                jsonForMatStr.append(getLevelStr(level));
            }
            switch (c) {
                case '{':
                case '[':
                    jsonForMatStr.append(c+"\n");
                    level++;
                    break;
                case ',':
                    jsonForMatStr.append(c+"\n");
                    break;
                case '}':
                case ']':
                    jsonForMatStr.append("\n");
                    level--;
                    jsonForMatStr.append(getLevelStr(level));
                    jsonForMatStr.append(c);
                    break;
                default:
                    jsonForMatStr.append(c);
                    break;
            }
        }

        return jsonForMatStr.toString();

    }

    private static String getLevelStr(int level){
        StringBuffer levelStr = new StringBuffer();
        for(int levelI = 0;levelI<level ; levelI++){
            levelStr.append("\t");
        }
        return levelStr.toString();
    }

    /**
     * 检测是否有JSON
     * @param msg
     * @return
     */
    public static String detectJson(String msg) {
        if(isJSON(msg)){
            return msg;
        }else if(msg.contains("{")||msg.contains("[")){
            if(msg.contains("{")&&msg.indexOf("{")<msg.indexOf("[")&&msg.contains("[")){
                String substring = msg.substring(msg.indexOf("{"), msg.length());
                return isJSON(substring)?substring:null;
            }else if(msg.contains("{")&&msg.indexOf("{")>msg.indexOf("[")&&msg.contains("[")){
                String substring = msg.substring(msg.indexOf("["), msg.length());
                return isJSON(substring)?substring:null;
            }else if (msg.contains("{")){
                String substring = msg.substring(msg.indexOf("{"), msg.length());
                return isJSON(substring)?substring:null;
            }else if(msg.contains("[")){
                String substring = msg.substring(msg.indexOf("["), msg.length());
                return isJSON(substring)?substring:null;
            }
        }
        return null;
    }

    /**
     * 字符串是否是JSON字符串
     * @param str
     * @return
     */
    public static boolean isJSON(String str) {
        try {
            new JSONObject(str);
        } catch (JSONException e) {
            try {
                new JSONArray(str);
            } catch (JSONException e1) {
                return false;
            }
        }
        return true;
    }

}
