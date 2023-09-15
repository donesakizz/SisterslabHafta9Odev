package com.example.cocukeglencefirebase.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.example.cocukeglencefirebase.R
import com.example.cocukeglencefirebase.databinding.FragmentDetailBinding
import com.example.cocukeglencefirebase.util.downloadFromUrl


class DetailFragment : Fragment(R.layout.fragment_detail) {
    private lateinit var binding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)

        val data = args.contentDetail

        binding.toolbarDetail.title = "${data.contentName}"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarDetail)

        data.contentImage?.let { binding.detailIv.downloadFromUrl(it) }
        binding.detailTv.text = data.contentDetail.toString()
    }


}