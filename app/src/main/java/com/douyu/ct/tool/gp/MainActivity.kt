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
            val pkgName = binding.etPkgName.text.toString()
            val gpPkgName = "com.android.vending"
            if (!AppUtils.isAppInstalled(gpPkgName)) {
                ToastUtils.showShort("未安装GP")
                return@setOnClickListener
            }
            if (pkgName.isBlank()) {
                ToastUtils.showShort("包名不能为空")
                return@setOnClickListener
            }
            ToastUtils.showShort("包名: ${pkgName}, 马上跳转")
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/details?id=${pkgName}")
            )
            intent.setPackage(gpPkgName)
            startActivity(intent)
        }
    }
}