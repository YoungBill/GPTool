package com.douyu.ct.tool.gp

import android.app.Application
import com.blankj.utilcode.util.Utils

/**
Created by taochen on 4/7/21.
Email: 935612713@qq.com.
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
    }
}