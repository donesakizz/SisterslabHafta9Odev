package com.example.cocukeglencefirebase.view.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocukeglencefirebase.model.Content
import com.example.cocukeglencefirebase.repository.HomeRepository
import com.google.firebase.database.DatabaseReference

class ListViewModel: ViewModel() {


    private val homeRepository = HomeRepository()
    var contentLiveData: MutableLiveData<List<Content>> = MutableLiveData()

    fun getContent(refContent: DatabaseReference) =
        homeRepository.getContentFromFirebase(refContent, contentLiveData)
}