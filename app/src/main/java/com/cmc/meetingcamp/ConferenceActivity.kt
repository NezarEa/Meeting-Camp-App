package com.cmc.meetingcamp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cmc.meetingcamp.databinding.ActivityConferenceBinding
import com.zegocloud.uikit.prebuilt.videoconference.ZegoUIKitPrebuiltVideoConferenceConfig
import com.zegocloud.uikit.prebuilt.videoconference.ZegoUIKitPrebuiltVideoConferenceFragment
import kotlin.random.Random

class ConferenceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConferenceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inflate the binding and set the content view
        binding = ActivityConferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Log to verify binding
        Log.d("ConferenceActivity", "Binding inflated successfully")

        // Set window insets listener using View Binding
        try {
            ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
                v?.let {
                    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                    it.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                } ?: run {
                    Log.e("ConferenceActivity", "Main view is null.")
                }
                insets
            }
            Log.d("ConferenceActivity", "WindowInsetsListener set successfully")
        } catch (e: Exception) {
            Log.e("ConferenceActivity", "Error setting WindowInsetsListener", e)
        }

        addConferenceScreen()
    }

    private fun addConferenceScreen() {
        val appID: Long = 1706221475
        val appSign: String = "52e65cfb3e53988fe2ae5eb4d9ad58ba59ef5380d3edcb027a4f4f89501d3cdb"

        val conferenceID: String = "test_conference_id"
        val userID: String = generateUserID()
        val userName: String = "${userID}_Name"

        val config = ZegoUIKitPrebuiltVideoConferenceConfig()
        val fragment = ZegoUIKitPrebuiltVideoConferenceFragment.newInstance(
            appID, appSign, userID, userName, conferenceID, config
        )
        supportFragmentManager.beginTransaction()
            .replace(binding.constraintLayout.id, fragment)
            .commitNow()
    }

    private fun generateUserID(): String {
        val builder = StringBuilder()
        val random = Random.Default
        while (builder.length < 5) {
            val nextInt = random.nextInt(10)
            if (builder.isEmpty() && nextInt == 0) {
                continue
            }
            builder.append(nextInt)
        }
        return builder.toString()
    }
}
