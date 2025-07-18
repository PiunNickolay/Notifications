package ru.netology.learningandtrying.dto

data class Post(
    val id: Long,
    val author: String,
    val published: String,
    val content: String,
    val likedByMe: Boolean = false,
    val likeCount: Int = 100,
    val shareCount: Int = 100,
    val viewCount: Int = 1000,
    val video: String? = null
)