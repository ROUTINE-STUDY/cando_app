package com.goodee.cando_app.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.goodee.cando_app.R
import com.goodee.cando_app.dto.DiaryDto
import com.goodee.cando_app.viewmodel.Diary
import com.google.firebase.auth.FirebaseAuth

class DiaryWriteFragment : Fragment() {
    private val TAG: String = "로그"
    private lateinit var writeButton: Button
    private lateinit var contentView: EditText
    private lateinit var titleInputView: EditText
    private lateinit var diary: Diary

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"DiaryWriteFragment - onCreate() called")
        super.onCreate(savedInstanceState)
        diary = Diary(requireActivity().application)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG,"DiaryWriteFragment - onCreateView() called")
        val view = inflater.inflate(R.layout.fragment_diary_write, container, false)
        writeButton = view.findViewById<Button>(R.id.button_diarywrite_writebutton)
        titleInputView = view.findViewById<EditText>(R.id.edittext_diarywrite_titleinput)
        contentView = view.findViewById<EditText>(R.id.edittext_diarywrite_contentinput)
        setEvent()

        return view
    }

    private fun setEvent() {
        Log.d(TAG,"DiaryWriteFragment - setEvent() called")
        writeButton!!.setOnClickListener {
            Log.d(TAG,"DiaryWriteFragment - writeButton is clicked.")
            val diaryDto = DiaryDto(titleInputView?.text.toString(), contentView?.text.toString(), FirebaseAuth.getInstance().currentUser?.email.toString())
            diary.writeDiary(diaryDto)
            findNavController().navigate(R.id.action_diaryWriteFragment_to_diaryFragment)
        }
    }
}