package project.rr.fb88appchnhthc.slotmachine_features.presentation


import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_slot_machine.*
import project.rr.fb88appchnhthc.databinding.FragmentSlotMachineBinding
import project.rr.fb88appchnhthc.slotmachine_features.common.EventClick
import project.rr.fb88appchnhthc.slotmachine_features.common.Utils
import kotlin.random.Random

class SlotMachineFragment : Fragment(), EventClick {

    private var countDown = 0

    private var _binding : FragmentSlotMachineBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSlotMachineBinding.inflate(inflater,container,false)
        onImageClickFun()
        setOnClickListenerFun()
        requestOrientation()

        return binding.root

    }

    private fun requestOrientation() {
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    private fun onImageClickFun(){

        binding.image1.setEventEnd(this)
        binding.image2.setEventEnd(this)
        binding.image3.setEventEnd(this)
    }

    private fun setOnClickListenerFun(){

        binding.leverUp.setOnClickListener{
            if(Utils.score >= 50){
                binding.leverUp.visibility = View.GONE
                binding.leverDown.visibility = View.VISIBLE
                binding.image1.setRandomValue(Random.nextInt(6), Random.nextInt(15-5+1)+5)
                binding.image2.setRandomValue(Random.nextInt(6), Random.nextInt(15-5+1)+5)
                binding.image3.setRandomValue(Random.nextInt(6), Random.nextInt(15-5+1)+5)
                Utils.score -= 50
                score_tv.text = Utils.score.toString()
            }else{
                Toast.makeText(context,"You dont have enough money", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun eventEnd(result: Int, count: Int) {
        if(countDown < 2){
            countDown++
        }
        else {
            leverDown.visibility = View.GONE
            leverUp.visibility = View.VISIBLE
            countDown = 0

            if (image1.value == image2.value && image2.value == image3.value) {
                Toast.makeText(context, "YOU WON!!!!", Toast.LENGTH_SHORT).show()
                Utils.score += 300
                score_tv.text = Utils.score.toString()
            } else if (image1.value == image2.value || image2.value == image3.value || image1.value == image3.value) {
                Toast.makeText(context, "You did good.", Toast.LENGTH_SHORT).show()
                Utils.score += 100
                score_tv.text = Utils.score.toString()
            } else {
                Toast.makeText(context, "You lost. Better luck next time.", Toast.LENGTH_SHORT)
                    .show()
                Utils.score += 0
                score_tv.text = Utils.score.toString()
            }
        }
    }
}