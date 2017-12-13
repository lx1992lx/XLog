package com.yyxk.xlogtext

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yyxk.xlog.XLog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        XLog.wtf("on Kotlin Activity create")
        var intent= Intent(this,JavaActivity::class.java)
        startActivity(intent)
    }
}
