package com.example.cocukeglencefirebase.repository

import androidx.lifecycle.MutableLiveData
import com.example.cocukeglencefirebase.model.Category
import com.example.cocukeglencefirebase.model.Content
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class HomeRepository {

    fun getCategoryFromFirebase(
        refCategory: DatabaseReference,
        categoryLiveData: MutableLiveData<List<Category>>
    ) {
        refCategory.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val categoryList = ArrayList<Category>()

                for (c in snapshot.children) {
                    val category = c.getValue(Category::class.java)

                    if (category != null) {
                        categoryList.add(category)
                        categoryLiveData.postValue(categoryList)
                    } else {
                        categoryLiveData.postValue(null)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }

    fun getContentFromFirebase(
        refContent: DatabaseReference,
        contentLiveData: MutableLiveData<List<Content>>
    ) {
        refContent.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val contentList = ArrayList<Content>()

                for (c in snapshot.children) {
                    val content = c.getValue(Content::class.java)

                    if (content != null) {
                        contentList.add(content)
                        contentLiveData.postValue(contentList)
                    } else {
                        contentLiveData.postValue(null)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }

}