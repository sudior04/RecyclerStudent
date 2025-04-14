package com.example.sinhvien

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview_student.R
import com.example.recycleview_student.Student
import com.example.recycleview_student.StudentAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var studentAdapter: StudentAdapter
    private val studentList = mutableListOf<Student>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val inputHoten = findViewById<EditText>(R.id.inputHoten)
//        val inputMSSV = findViewById<EditText>(R.id.inputMSSV)
        val edtName = findViewById<EditText>(R.id.inputHoten)
        val edtMSSV = findViewById<EditText>(R.id.inputMSSV)
        val btnAdd = findViewById<Button>(R.id.buttonAdd)
        val recyclerView = findViewById<RecyclerView>(R.id.list_students)

        studentAdapter = StudentAdapter(studentList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = studentAdapter

        edtName.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus && edtName.text.toString() == "Họ và tên") {
                edtName.setText("")
            }
        }
        edtMSSV.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus && edtMSSV.text.toString() == "MSSV") {
                edtMSSV.setText("")
            }
        }

        btnAdd.setOnClickListener {
            val name = edtName.text.toString().trim()
            val mssv = edtMSSV.text.toString().trim()
            if (name.isNotEmpty() && mssv.isNotEmpty()) {
                studentList.add(Student(name, mssv))
                studentAdapter.notifyItemInserted(studentList.size - 1)
                edtName.text.clear()
                edtMSSV.text.clear()
            }
        }
    }
}