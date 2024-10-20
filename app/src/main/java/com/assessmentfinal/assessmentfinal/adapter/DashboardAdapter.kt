package com.assessmentfinal.assessmentfinal.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assessmentfinal.assessmentfinal.R
import com.assessmentfinal.assessmentfinal.activities.DetailActivity
import com.assessmentfinal.assessmentfinal.models.EntityDetails

// DashboardAdapter.kt
class DashboardAdapter : RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>() {

    private var entities: List<EntityDetails> = emptyList()

    inner class DashboardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.entity_name)
        private val architect: TextView = itemView.findViewById(R.id.entity_architect)
        private val location: TextView = itemView.findViewById(R.id.entity_location)
        private val yearCompleted: TextView = itemView.findViewById(R.id.entity_year)
        private val style: TextView = itemView.findViewById(R.id.entity_style)
        private val height: TextView = itemView.findViewById(R.id.entity_height)
        // Add other views as needed

        fun bind(entity: EntityDetails) {
            name.text = entity.name
            architect.text = entity.architect
            location.text = entity.location
            yearCompleted.text = entity.yearCompleted.toString()
            style.text = entity.style
            height.text = entity.height.toString()


            // Bind other views as needed
            itemView.setOnClickListener {
                val context = itemView.context // Get the context from the itemView
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("ENTITY_NAME", entity.name)
                intent.putExtra("ENTITY_ARCHITECT", entity.architect)
                intent.putExtra("ENTITY_LOCATION", entity.location)
                intent.putExtra("ENTITY_YEAR", entity.yearCompleted)
                intent.putExtra("ENTITY_STYLE", entity.style)
                intent.putExtra("ENTITY_HEIGHT", entity.height)
                intent.putExtra("ENTITY_DESCRIPTION", entity.description)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_entity, parent, false)
        return DashboardViewHolder(view)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val entity = entities[position] // Bind the correct entity to the ViewHolder
        holder.bind(entity)
    }

    override fun getItemCount(): Int = entities.size

    fun setData(newEntities: List<EntityDetails>) {
        entities = newEntities
        notifyDataSetChanged()
    }
}
