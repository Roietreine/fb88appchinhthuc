package project.rr.fb88appchnhthc.privacy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import project.rr.fb88appchnhthc.common.AppModel
import project.rr.fb88appchnhthc.databinding.PrivacyViewBinding

class PrivacyAdapter : RecyclerView.Adapter<PrivacyAdapter.AdapterHolder>() {



    private var privacyList = emptyList<AppModel>()

    class AdapterHolder(val adapts: PrivacyViewBinding) : RecyclerView.ViewHolder(adapts.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHolder =
        AdapterHolder(
            PrivacyViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
        with(holder) {
            with(privacyList[position]) {
                adapts.privacyTitle.text = this.appTitle
                adapts.privacyDesc.text = this.appDesc
            }
        }
    }

    override fun getItemCount(): Int {
        return privacyList.size
    }


    fun setAdapter(setAdapt: List<AppModel>) {
        this.privacyList = setAdapt
    }
}