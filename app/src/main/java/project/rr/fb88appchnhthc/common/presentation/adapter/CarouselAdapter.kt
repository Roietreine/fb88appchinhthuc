package project.rr.fb88appchnhthc.common.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import project.rr.fb88appchnhthc.databinding.CarouselPlaceholderBinding

class CarouselAdapter(val dataImg: ArrayList<Int>) :
    RecyclerView.Adapter<CarouselAdapter.AdapterHolder>() {
    class AdapterHolder(val adapts: CarouselPlaceholderBinding) :
        RecyclerView.ViewHolder(adapts.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHolder =
        AdapterHolder(
            CarouselPlaceholderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
        holder.adapts.apply {
            carouselPlaceholder.setBackgroundResource(dataImg[position])
        }
    }

    override fun getItemCount(): Int {
        return dataImg.size
    }
}