package ru.netology.learningandtrying.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import ru.netology.learningandtrying.dao.PostDao
import ru.netology.learningandtrying.dto.Post
import ru.netology.learningandtrying.entity.PostEntity

class PostRepositoryRoomImpl(private val dao: PostDao) : PostRepository {

    override fun get(): LiveData<List<Post>> = dao.getAll().map { list-> list.map{ it.toDto()} }

    override fun likeById(id: Long) = dao.likeById(id)

    override fun shareById(id: Long) = dao.shareById(id)

    override fun removeById(id: Long) = dao.removeById(id)

    override fun save(post: Post) = dao.save(PostEntity.fromDto(post))
}