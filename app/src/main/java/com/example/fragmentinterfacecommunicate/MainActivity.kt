package com.example.fragmentinterfacecommunicate

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fragmentinterfacecommunicate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Communicator {
    private lateinit var binding: ActivityMainBinding
    private lateinit var receiverFragment: ReceiverFragment
    private lateinit var senderFragment: SenderFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()

    }

    private fun initViews() {
        receiverFragment = ReceiverFragment()
        senderFragment = SenderFragment()
        supportFragmentManager.beginTransaction().replace(R.id.sender, senderFragment).commit()
        supportFragmentManager.beginTransaction().replace(R.id.receiver, receiverFragment).commit()

    }

    override fun sendMessage(message: String) {
        receiverFragment.sendMessage(message)
    }


}