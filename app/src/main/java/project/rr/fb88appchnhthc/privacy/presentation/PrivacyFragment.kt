package project.rr.fb88appchnhthc.privacy.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import project.rr.fb88appchnhthc.databinding.FragmentPrivacyBinding
import project.rr.fb88appchnhthc.privacy.adapter.PrivacyAdapter
import project.rr.fb88appchnhthc.privacy.viewmodel.PrivacyViewModel


class PrivacyFragment : Fragment() {


    private var _binding: FragmentPrivacyBinding? = null
    private val binding get() = _binding!!
    private var privacyVM = PrivacyViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPrivacyBinding.inflate(inflater, container, false)
        privacyVM = ViewModelProvider(this)[PrivacyViewModel::class.java]

        privacyVM.pvcFun()
        val adapts = PrivacyAdapter()
        privacyVM.prvcyNf.observe(viewLifecycleOwner) {
            if (it != null) {
                adapts.setAdapter(it)
                binding.privacyRecycler.apply {
                    setHasFixedSize(true)
                    adapter = adapts
                    layoutManager = LinearLayoutManager(context)
                }
            }
        }
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}