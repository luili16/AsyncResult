package com.jingyupeiyou.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.llx278.asyncresult.AsyncActivityResult

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.result).setOnClickListener {
            val resut = AsyncActivityResult()
            val i = Intent(this@MainActivity,SecondActivity::class.java)
            i.putExtra("input","bbbbbb")
            resut.startActivityForResult(this@MainActivity,i) {
                Toast.makeText(this@MainActivity,"${it.resultCode} : ${it.data.getStringExtra("param")}",Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {





        super.onActivityResult(requestCode, resultCode, data)
    }
}
