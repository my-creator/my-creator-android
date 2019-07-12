package com.crecrew.crecre.Data

data class VoteItemData(
    var choice_idx :Int,
    var vote_idx: Int,
    var name: String,
    var count: Int,
    var creator_profile_url : String,
    var follower_grade_idx : String,
    var follower_grade_name : String,
    var follower_grade_level : String,
    var follower_grade_img_url : String,
    var view_grade_img_url : String,
    var rank: Int
)