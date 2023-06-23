package com.ayfer.kronometre

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ayfer.kronometre.R
import com.ayfer.kronometre.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding: ActivityMainBinding
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var stopTime:Long=0
        binding.buttonStart?.setOnClickListener {
            binding.chronometer!!.base=SystemClock.elapsedRealtime()+stopTime
            binding.chronometer!!.start()
            binding.buttonStart!!.visibility=View.GONE
            binding.buttonPause!!.visibility= View.VISIBLE
            binding.imageView!!.setImageDrawable(getDrawable(R.drawable.pause))
        }
        binding.buttonPause?.setOnClickListener {
            stopTime= binding.chronometer!!.base-SystemClock.elapsedRealtime()
            binding.chronometer?.stop()
            binding.buttonPause!!.visibility= View.GONE
            binding.buttonStart!!.visibility=View.VISIBLE
            binding.imageView!!.setImageDrawable(getDrawable(R.drawable.start))
        }
        binding.buttonReset?.setOnClickListener {
            binding.chronometer!!.base=SystemClock.elapsedRealtime()
            binding.chronometer?.stop()
            binding.buttonPause!!.visibility= View.GONE
            binding.buttonStart!!.visibility=View.VISIBLE
            binding.imageView!!.setImageDrawable(getDrawable(R.drawable.start))



        }
    }
}