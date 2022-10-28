package project.rr.fb88appchnhthc.webview.presentation

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import project.rr.fb88appchnhthc.R
import project.rr.fb88appchnhthc.common.AppModel
import project.rr.fb88appchnhthc.databinding.FragmentDisplayBinding
import project.rr.fb88appchnhthc.webview.adapter.DisplayAdapter
import project.rr.fb88appchnhthc.webview.utils.DisplayInterface
import project.rr.fb88appchnhthc.webview.viewmodel.DisplayViewModel


class DisplayFragment : Fragment(), DisplayInterface {


    private var _binding: FragmentDisplayBinding? = null
    private val binding get() = _binding!!
    private var dfViewModel = DisplayViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentDisplayBinding.inflate(inflater, container, false)
        dfViewModel = ViewModelProvider(this)[DisplayViewModel::class.java]

        recyclerViewSetup()
        return binding.root
    }

    private fun recyclerViewSetup() {
        dfViewModel.dsplyFun()
        val adapts = DisplayAdapter(this)
        dfViewModel.dsplynf.observe(viewLifecycleOwner) {
            if (it != null) {
                adapts.setAdapter(it)
                binding.displayRecycler.apply {
                    setHasFixedSize(true)
                    adapter = adapts
                    layoutManager = LinearLayoutManager(context)
                }
            }
        }
    }

    override fun onItemClick(data: AppModel) {
        val dialog = Dialog(requireContext())
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.content_view_show_all)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        val title = dialog.findViewById<TextView>(R.id.display_title_show_all)
        val desc = dialog.findViewById<TextView>(R.id.display_desc_show_all)

        title.text = data.appTitle
        desc.text = data.appDesc

        dialog.show()
    }
}