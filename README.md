# XLog
A powerful log util for android
---------------
![image](https://github.com/lx1992lx/XLog/blob/master/proPic.png)
<br><br><br>

### 主要功能<br>
  *标记Log代码位置，（在android studio中可以点击快速定位）<br>
  *支持Kotlin<br>
  *支持Log打印监听<br>
  *支持JSON格式打印，自动格式化JSON<br>
  
  
---------------


### 使用方法<br>
1.在build.gradle 中集成：<br>

    compile 'com.yyxk.XLog:xlog:1.0.4'

2.在Application的onCreate()方法里进行初始化：<br>

     //最简单集成
    XLog.init(true,"123");
     

  或者初始化一个Log打印监听器：<br>
    
     XLog.init(true, "123", new LogListener() {
            @Override
            public void whenLogPrint(int type, String tag, String msg, String header) {
                //TODO 记录日志、上传等操作
                //这里使用XLog打印的日志不会调用whenLogPrint()
                XLog.i("日志正常打印");
            }
     });
     
3.打印日志:<br>


     XLog.i("a log");
     
  或者可以单独指定tag：<br>
    
    XLog.d("onCreate","a log");
     
4.可以在Log中直接打印JSON：<br>
   
   
     XLog.d("{\"code\":\"this is JavaActivity\",\"data\":{\"code\":123}}");
     
  或者是一段带着标题的JSON：<br>
  
  
    XLog.d("这是请求数据：{\"code\":\"this is JavaActivity\",\"data\":{\"code\":123}}");
    
 <br><br>
(P.S: XLog支持类型是I、D、W、E、V、WTF类型的日志)<br>

<br><br>
联系作者：
<br>
微信：lx1992lxlx
<br>
邮箱：1012025958@qq.com

