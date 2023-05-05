package com.insurfin.api1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.insurfin.api1.databinding.ActivityMainBinding
import com.insurfin.api1.ui.api1.Api1Activity
import com.insurfin.api1.ui.api2_retrofit.RetrofitOneActivity
import com.insurfin.api1.ui.api3.UserDetailActivity
import com.insurfin.api1.ui.api4.PostApi1Activity
import com.insurfin.api1.ui.api5.UserDetailsActivity
import com.insurfin.api1.ui.api5.UserDetailsFragment
import com.insurfin.api1.ui.api6.GithubUserActivity
import com.insurfin.api1.ui.permissions.Permission1Fragment
import com.insurfin.api1.ui.permissions.PermissionActivity
import com.insurfin.api1.ui.permissions.PermissionListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.api1.setOnClickListener {
            val intent = Intent(this, Api1Activity::class.java)
            startActivity(intent)
        }

        binding.api2.setOnClickListener {
            val intent = Intent(this, RetrofitOneActivity::class.java)
            startActivity(intent)
        }

        binding.api3.setOnClickListener {
            val intent = Intent(this, UserDetailActivity::class.java)
            startActivity(intent)
        }

        binding.api4.setOnClickListener {
            val intent = Intent(this, PostApi1Activity::class.java)
            startActivity(intent)
        }
        binding.api5.setOnClickListener {
            val intent = Intent(this, UserDetailsActivity::class.java)
            startActivity(intent)
        }

        binding.api6.setOnClickListener {
            val intent = Intent(this, GithubUserActivity::class.java)
            startActivity(intent)
        }



    }


}


