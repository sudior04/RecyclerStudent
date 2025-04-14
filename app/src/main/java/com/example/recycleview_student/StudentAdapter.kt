package com.example.recycleview_student

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Student(val name: String, val mssv: String)

class StudentAdapter(
    private val students: MutableList<Student>
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtStudent: TextView = itemView.findViewById(R.id.txtStudent)
        val txtMSSV: TextView = itemView.findViewById(R.id.txtMSSV)
        val btnDelete: Button = itemView.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.txtStudent.text = student.name
        holder.txtMSSV.text = "MSSV: ${student.mssv}"

        holder.btnDelete.setOnClickListener {
            students.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, students.size)
        }
    }

    override fun getItemCount(): Int = students.size
}