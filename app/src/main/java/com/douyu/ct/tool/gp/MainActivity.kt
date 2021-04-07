package com.douyu.ct.tool.gp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.AppUtils
import com.blankj.utilcode.util.ToastUtils
import com.douyu.ct.tool.gp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btToGpApp.setOnClickListener {
            val linkString = binding.etAppLink.text.toString()
            val gpPkgName = "com.android.vending"
            if (!AppUtils.isAppInstalled(gpPkgName)) {
                ToastUtils.showShort("未安装GP")
                return@setOnClickListener
            }
            if (linkString.isBlank()) {
                ToastUtils.showShort("App链接不能为空")
                return@setOnClickListener
            }
            ToastUtils.showShort("App链接: ${linkString}, 马上跳转")
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(linkString))
            intent.setPackage(gpPkgName)
            startActivity(intent)
        }
    }
}