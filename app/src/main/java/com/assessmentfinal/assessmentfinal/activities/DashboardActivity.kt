package com.assessmentfinal.assessmentfinal.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assessmentfinal.assessmentfinal.R
import com.assessmentfinal.assessmentfinal.adapter.DashboardAdapter
import com.assessmentfinal.assessmentfinal.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

// DashboardActivity.kt
@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    private lateinit var viewModel: DashboardViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DashboardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val keypass = intent.getStringExtra("KEYPASS") ?: return

        viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = DashboardAdapter()
        recyclerView.adapter = adapter

        viewModel.dashboardData.observe(this, { response ->
            response?.let {
                adapter.setData(it.entities)
            }
        })

        viewModel.fetchDashboardData(keypass)
    }
}
