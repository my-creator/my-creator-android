package com.crecrew.crecre.Network.Get

data class CommunityReplyData(
    val content: String,
    val idx: Int,
    val is_anonymous: Int,
    val name: String,
    val post_idx: Int,
    val profile_url: String,
    val reply_create_time: String,
    val user_idx: Int
)