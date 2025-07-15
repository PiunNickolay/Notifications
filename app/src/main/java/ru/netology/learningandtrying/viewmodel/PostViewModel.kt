package ru.netology.learningandtrying.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ru.netology.learningandtrying.db.AppDb
import ru.netology.learningandtrying.dto.Post
import ru.netology.learningandtrying.repository.PostRepository
import ru.netology.learningandtrying.repository.PostRepositoryRoomImpl

private val empty = Post(
    id = 0,
    author = "",
    published = "",
    content = "",
    likedByMe = false
)
class PostViewModel(application: Application): AndroidViewModel(application) {
    private val repository: PostRepository = PostRepositoryRoomImpl(
        AppDb.getIstance(application).postDao
    )
    val data = repository.get()
    val edited = MutableLiveData(empty)
    val draft = MutableLiveData<String?>()
    fun likeById(id: Long) = repository.likeById(id)
    fun shareById(id: Long) = repository.shareById(id)
    fun removeById(id: Long) = repository.removeById(id)
    fun changeContentAndSave(text:String){
        edited.value?.let{
            if(it.content != text){
                repository.save(it.copy(content = text))
            }
        }
        edited.value = empty
    }
    fun edit(post: Post){
        edited.value = post
    }
    fun cancelEdit(){
        edited.value = empty
    }
}