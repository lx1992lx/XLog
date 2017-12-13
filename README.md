# XLog
A powerful log util for android
---------------
### 主要功能<br>
  *标记Log代码位置，（在android studio中可以点击快速定位）<br>
  *支持Kotlin<br>
  *支持Log打印监听<br>
  *支持JSON格式打印，自动格式化JSON<br>
---------------
### 使用方法<br>
1.在build.gradle 中集成：<br>
2.在Application的onCreate()方法里进行初始化：<br>


    XLog.init(true,"123");//最简单集成
    
  或者初始化一个Log打印监听器：<br>
    
    XLog.init(true, "123", new LogListener() {
            @Override
            public void whenLogPrint(int type, String tag, String msg, String header) {
                //TODO 记录日志、上传等操作
                //这里使用XLog打印的日志不会调用whenLogPrint()
                XLog.i("日志正常打印");
            }
        });
