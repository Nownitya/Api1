package com.insurfin.api1.ui.api6

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.insurfin.api1.R
import com.insurfin.api1.databinding.ActivityGithubUserBinding

class GithubUserActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityGithubUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window , false)
        super.onCreate(savedInstanceState)

        binding = ActivityGithubUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_github_user)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController , appBarConfiguration)

//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view , "Replace with your own action" , Snackbar.LENGTH_LONG)
//                .setAnchorView(R.id.fab)
//                .setAction("Action" , null).show()
//        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_github_user)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}