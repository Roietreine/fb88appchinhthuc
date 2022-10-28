package project.rr.fb88appchnhthc.common.presentation.dashboard

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.navigation.findNavController
import project.rr.fb88appchnhthc.R
import project.rr.fb88appchnhthc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


   private var bckToExit = false


    private val currentFragment by lazy {
        findNavController(R.id.frag_view)
    }

    private lateinit var binding : ActivityMainBinding

    companion object{
        fun getStartIntent (context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onBackPressed() {
        if (currentFragment.currentDestination?.id == R.id.mainFragment) {
            if (bckToExit) {
                finishAffinity()
                return
            }
            bckToExit = true
            Toast.makeText(this, "Press back again to exit.", Toast.LENGTH_SHORT).show()
            Handler().postDelayed({ bckToExit = false }, 2000)
        } else {
            findNavController(R.id.frag_view).navigateUp()
        }
    }
}
