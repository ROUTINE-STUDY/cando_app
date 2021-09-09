package com.goodee.cando_app.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.goodee.cando_app.R
import com.goodee.cando_app.databinding.FragmentDiaryBinding
import com.goodee.cando_app.dto.Diary

class DiaryFragment : Fragment() {
    private val TAG: String = "로그"
    private lateinit var diaryBinding: FragmentDiaryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG,"DiaryFragment - onCreateView() called")
        diaryBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_diary, container, false)
        val data = test()
        var adapter = DiaryRecyclerViewAdapter()
        adapter.list = data
        diaryBinding.recyclerviewDiaryDiarylist.adapter = adapter
        diaryBinding.recyclerviewDiaryDiarylist.layoutManager = LinearLayoutManager(requireActivity())

        return diaryBinding.root
    }

    fun test(): MutableList<Diary> {
        val data = mutableListOf<Diary>()
        for (number in 1..100) {
            data.add(Diary(number.toString(),"제목 : ${number}번째 글", "${number}번째 유저",System.currentTimeMillis(), System.currentTimeMillis(),number))
        }

        return data
    }
}