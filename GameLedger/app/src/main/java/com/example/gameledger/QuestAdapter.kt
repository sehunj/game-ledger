package com.example.gameledger

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class QuestAdapter(val questList:ArrayList<Quests>) : RecyclerView.Adapter<QuestAdapter.CustomViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_quest, parent, false)
        return QuestAdapter.CustomViewHolder(view)

    }

    override fun onBindViewHolder(holder: QuestAdapter.CustomViewHolder, position: Int) {
        holder.questCategory.text = questList.get(position).questCategory
        holder.questTitle.text = questList.get(position).questTitle
        holder.questValue.text = questList.get(position).questValue
        holder.accumulatedAmmount.text = questList.get(position).accumulatedAmmount
    }

    override fun getItemCount(): Int {
        return questList.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val questCategory = itemView.findViewById<TextView>(R.id.tv_questCategory)    // 카테고리
        val questTitle = itemView.findViewById<TextView>(R.id.tv_quest)    // 퀘스트
        val questValue = itemView.findViewById<TextView>(R.id.tv_questValue)    // 퀘스트 목표 금액
        val accumulatedAmmount = itemView.findViewById<TextView>(R.id.tv_accumulatedAmmount)  // 누적 금액
        val questCompleteButton = itemView.findViewById<Button>(R.id.btn_questComplete)
    }
}