package project.rr.fb88appchnhthc.webview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import project.rr.fb88appchnhthc.common.AppModel
import project.rr.fb88appchnhthc.databinding.ContentViewBinding
import project.rr.fb88appchnhthc.webview.utils.DisplayInterface

class DisplayAdapter(val listener: DisplayInterface) :
    RecyclerView.Adapter<DisplayAdapter.AdapterHolder>() {

    private var emptyList = mutableListOf<AppModel>()

    class AdapterHolder(val adapts: ContentViewBinding) : RecyclerView.ViewHolder(adapts.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHolder =
        AdapterHolder(
            ContentViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
        with(holder) {
            with(emptyList[position]) {
                adapts.displayTitle.text = this.appTitle
                adapts.displayDesc.text = this.appDesc
                adapts.onclickCardview.setOnClickListener {
                    listener.onItemClick(this)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return emptyList.size
    }


    fun setAdapter(setAdapt: List<AppModel>) {
        emptyList.addAll(setAdapt)
    }
}