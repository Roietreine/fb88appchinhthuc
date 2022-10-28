package project.rr.fb88appchnhthc.common.presentation.dashboard

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import project.rr.fb88appchnhthc.R
import project.rr.fb88appchnhthc.common.Utils.Companion.dataImg
import project.rr.fb88appchnhthc.common.Utils.Companion.setTimer
import project.rr.fb88appchnhthc.databinding.FragmentMainBinding
import project.rr.fb88appchnhthc.common.presentation.adapter.CarouselAdapter


class MainFragment : Fragment(), View.OnClickListener {


    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        onClickMainButtons()
        requestOrientation()
        setupCarousel()

        return binding.root
    }

    private fun setupCarousel() {
        binding.carouselView.apply {
            adapter = CarouselAdapter(dataImg)
            setTimer(this, dataImg.size)
        }
        binding.carouselIndicator.setViewPager2(binding.carouselView)
    }

    private fun requestOrientation() {

        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    private fun onClickMainButtons() {

        binding.webView.setOnClickListener(this)
        binding.miniGame.setOnClickListener(this)
        binding.privacyView.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v) {

            binding.webView -> findNavController().navigate(R.id.action_mainFragment_to_webviewFragment)
            binding.privacyView -> findNavController().navigate(R.id.action_mainFragment_to_privacyFragment)
            binding.miniGame -> findNavController().navigate(R.id.action_mainFragment_to_slotMachineFragment)

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}