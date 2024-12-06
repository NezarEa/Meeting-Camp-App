package com.cmc.meetingcamp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cmc.meetingcamp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val PERMISSION_REQUEST_CODE = 1001
    private val REQUIRED_PERMISSIONS = arrayOf(
        Manifest.permission.CAMERA,
        Manifest.permission.RECORD_AUDIO
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inflate the binding and set the content view
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Log to verify binding
        Log.d("MainActivity", "Binding inflated successfully")

        // Set window insets listener using View Binding
        try {
            ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
                v?.let {
                    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                    it.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                } ?: run {
                    Log.e("MainActivity", "Main view is null.")
                }
                insets
            }
            Log.d("MainActivity", "WindowInsetsListener set successfully")
        } catch (e: Exception) {
            Log.e("MainActivity", "Error setting WindowInsetsListener", e)
        }

        // Check and request permissions
        if (!hasAllPermissions()) {
            ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, PERMISSION_REQUEST_CODE)
        }

        // Set click listener for the button
        binding.btn.setOnClickListener {
            if (hasAllPermissions()) {
                Log.d("MainActivity", "Start Conference button clicked")
                val intent = Intent(this@MainActivity, ConferenceActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please grant all permissions to proceed.", Toast.LENGTH_SHORT).show()
                ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, PERMISSION_REQUEST_CODE)
            }
        }
    }

    // Helper function to check permissions
    private fun hasAllPermissions(): Boolean {
        return REQUIRED_PERMISSIONS.all { permission ->
            ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
        }
    }

    // Handle the permission request response
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
                Toast.makeText(this, "Permissions granted!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Permissions denied. The app may not function correctly.", Toast.LENGTH_LONG).show()
            }
        }
    }
}
