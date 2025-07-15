package ru.netology.learningandtrying.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.netology.learningandtrying.dto.Post


@Entity
data class PostEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val author: String,
    val published: String,
    val content: String,
    val likedByMe: Boolean = false,
    val likeCount: Int = 0,
    val shareCount: Int = 0,
    val viewCount: Int = 100,
    val video: String? = null
){
    fun toDto() = Post(id, author, content, published, likedByMe, likeCount, shareCount, viewCount, video)

    companion object{
        fun fromDto(post: Post) = PostEntity(
            post.id,
            post.author,
            post.content,
            post.published,
            post.likedByMe,
            post.likeCount,
            post.shareCount,
            post.viewCount,
            post.video,
        )
    }
}
