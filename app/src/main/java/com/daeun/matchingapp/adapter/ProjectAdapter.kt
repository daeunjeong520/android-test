package com.daeun.matchingapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daeun.matchingapp.databinding.ProjectItemBinding
import com.daeun.matchingapp.domain.Project

class ProjectAdapter (
    val list: MutableList<Project>,
    val itemClickListener: ItemClickListener? = null,
): RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val inflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = ProjectItemBinding.inflate(inflater, parent, false)
        return ProjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        val project = list[position]
        holder.bind(project)
        holder.itemView.setOnClickListener { itemClickListener?.onClick(project) }
    }

    // item 개수 반환(리스트 개수 반환)
    override fun getItemCount(): Int {
        return list.size
    }

    class ProjectViewHolder(private val binding: ProjectItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(project: Project) {
            binding.apply {
                name.text = project.name
                jobGroup.text = project.jobGroup
                job.text = project.job
                salary.text = project.salary
                startDate.text = project.startDate
            }
        }
    }

    interface ItemClickListener {
        fun onClick(project: Project)
    }
}