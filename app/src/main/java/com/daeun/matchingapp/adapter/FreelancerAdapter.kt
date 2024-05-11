package com.daeun.matchingapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daeun.matchingapp.databinding.FreelancerItemBinding
import com.daeun.matchingapp.domain.Freelancer

class FreelancerAdapter(
    private val list: MutableList<Freelancer>,
    private val itemClickListener: ItemClickListener? = null,
    ): RecyclerView.Adapter<FreelancerAdapter.FreelancerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FreelancerViewHolder {
        val inflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = FreelancerItemBinding.inflate(inflater, parent, false)
        return FreelancerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FreelancerViewHolder, position: Int) {
        val freelancer = list[position]
        holder.bind(freelancer)
        holder.itemView.setOnClickListener { itemClickListener?.onClick(freelancer) }
    }

    // item 개수 반환(리스트 개수 반환)
    override fun getItemCount(): Int {
        return list.size
    }

    class FreelancerViewHolder(private val binding: FreelancerItemBinding ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(freelancer: Freelancer) {
            binding.apply {
                name.text = freelancer.name
                workStyle.text = freelancer.workStyle
                job.text = freelancer.job
                careerYear.text = freelancer.careerYear
            }
        }
    }

    interface ItemClickListener {
        fun onClick(freelancer: Freelancer)
    }
}