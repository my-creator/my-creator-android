@file:Suppress("UNREACHABLE_CODE")

package com.crecrew.crecre.UI.Adapter

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.crecrew.crecre.Network.Get.VoteTestData
import com.crecrew.crecre.R
import android.widget.*
import com.bumptech.glide.request.RequestOptions
import com.crecrew.crecre.Data.PostVoteChoiceResponse
import com.crecrew.crecre.Network.VoteNetworkService
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.json.JSONObject
import retrofit2.Call

class VoteTestAdapter(val ctx: Context, val dataList: ArrayList<VoteTestData>) :
    RecyclerView.Adapter<VoteTestAdapter.Holder>() {

    var check1: Int = 0;
    var check2: Int = 0;
    var check3: Int = 0;
    var check4: Int = 0;
    var check5: Int = 0;

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img_thumnail = itemView.findViewById(R.id.card_main_image_test) as ImageView
        var txt_dayleft = itemView.findViewById(R.id.rv_item_current_card_dayleft_test) as TextView
        var txt_ongoing = itemView.findViewById(R.id.rv_item_current_card_isongoing_test) as TextView
        var stamp = itemView.findViewById(R.id.rv_item_current_card_stamp_test) as ImageView
        var title = itemView.findViewById(R.id.rv_item_vote_title_test) as TextView
        var explain = itemView.findViewById(R.id.rv_item_vote_explain_test) as TextView
        //개별 아이템들ㅇㅇ
        var img_item1 = itemView.findViewById(R.id.item_img1_test) as ImageView
        var img_item2 = itemView.findViewById(R.id.item_img2_test) as ImageView
        var img_item3 = itemView.findViewById(R.id.item_img3_test) as ImageView
        var img_item4 = itemView.findViewById(R.id.item_img4_test) as ImageView
        var img_item5 = itemView.findViewById(R.id.item_img5_test) as ImageView

        var txt_itemname1 = itemView.findViewById(R.id.item_name1_test) as TextView
        var txt_itemname2 = itemView.findViewById(R.id.item_name2_test) as TextView
        var txt_itemname3 = itemView.findViewById(R.id.item_name3_test) as TextView
        var txt_itemname4 = itemView.findViewById(R.id.item_name4_test) as TextView
        var txt_itemname5 = itemView.findViewById(R.id.item_name5_test) as TextView
        var txt_votenum1 = itemView.findViewById(R.id.vote_num1_test) as TextView
        var txt_votenum2 = itemView.findViewById(R.id.vote_num2_test) as TextView
        var txt_votenum3 = itemView.findViewById(R.id.vote_num3_test) as TextView
        var txt_votenum4 = itemView.findViewById(R.id.vote_num4_test) as TextView
        var txt_votenum5 = itemView.findViewById(R.id.vote_num5_test) as TextView
        var txt_rank1 = itemView.findViewById(R.id.vote_rank1_test) as TextView
        var txt_rank2 = itemView.findViewById(R.id.vote_rank2_test) as TextView
        var txt_rank3 = itemView.findViewById(R.id.vote_rank3_test) as TextView
        var txt_rank4 = itemView.findViewById(R.id.vote_rank4_test) as TextView
        var txt_rank5 = itemView.findViewById(R.id.vote_rank5_test) as TextView
        var imageView1 = itemView.findViewById(R.id.vote_check1_test) as ImageView
        var imageView2 = itemView.findViewById(R.id.vote_check2_test) as ImageView
        var imageView3 = itemView.findViewById(R.id.vote_check3_test) as ImageView
        var imageView4 = itemView.findViewById(R.id.vote_check4_test) as ImageView
        var imageView5 = itemView.findViewById(R.id.vote_check5_test) as ImageView
        var line1 = itemView.findViewById(R.id.ll1_test) as LinearLayout
        var line2 = itemView.findViewById(R.id.ll2_test) as LinearLayout
        var line3 = itemView.findViewById(R.id.ll3_test) as LinearLayout
        var line4 = itemView.findViewById(R.id.ll4_test) as LinearLayout
        var line5 = itemView.findViewById(R.id.ll5_test) as LinearLayout
        var letsVote = itemView.findViewById(R.id.lets_vote_test) as TextView

        var imgItemList : ArrayList<ImageView> = arrayListOf(img_item1,img_item2,img_item3,img_item4,img_item5)
        var txtItemList : ArrayList<TextView> = arrayListOf(txt_votenum1,txt_votenum2,txt_votenum3,txt_votenum4,txt_votenum5 )
        var txtVoteItemList : ArrayList<ImageView> = arrayListOf(img_item1,img_item2,img_item3,img_item4,img_item5)
        var txtRankList : ArrayList<ImageView> = arrayListOf(img_item1,img_item2,img_item3,img_item4,img_item5)
        var imageViewItemList : ArrayList<ImageView> = arrayListOf(img_item1,img_item2,img_item3,img_item4,img_item5)
        var lineList : ArrayList<ImageView> = arrayListOf(img_item1,img_item2,img_item3,img_item4,img_item5)

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): VoteTestAdapter.Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_currentvote_card_test, p0, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        var x:Int=2
        var y = dataList[position].choices.size
        if (dataList[position].thumbnail_url != null) {
            Glide.with(ctx)
                .load(dataList[position].thumbnail_url)
                .into(holder.img_thumnail)
            holder.img_thumnail.scaleType = ImageView.ScaleType.CENTER_CROP
        }

        for(choice in dataList[position].choices){
            Glide.with(ctx)
                .load(choice.creator_profile_url)
                .apply(RequestOptions().circleCrop()).into(holder.img_item1)
        }

        /*if (dataList[position].choices[0].creator_profile_url != null) {
            Glide.with(ctx)
                .load(dataList[position].choices[0].creator_profile_url)
                .apply(RequestOptions().circleCrop()).into(holder.img_item1)
        } else holder.img_item1.setVisibility(View.GONE)

        if (dataList[position].choices[1].creator_profile_url != null) {
            Glide.with(ctx)
                .load(dataList[position].choices[1].creator_profile_url)
                .apply(RequestOptions().circleCrop()).into(holder.img_item2)
        } else holder.img_item2.setVisibility(View.GONE)*/

        if (dataList[position].choices.size >=3 ){

            /*if (dataList[position].choices[2].creator_profile_url != null) {
                Glide.with(ctx)
                    .load(dataList[position].choices[2].creator_profile_url)
                    .apply(RequestOptions().circleCrop()).into(holder.img_item3)
            } else holder.img_item3.setVisibility(View.GONE)*/

            if (dataList[position].choices.size >= 4){
                if (dataList[position].choices[3].creator_profile_url != null) {
                    Glide.with(ctx)
                        .load(dataList[position].choices[3].creator_profile_url)
                        .apply(RequestOptions().circleCrop()).into(holder.img_item4)
                } else holder.img_item4.setVisibility(View.GONE)

                if (dataList[position].choices.size == 5){
                    if (dataList[position].choices.size >= 5 && dataList[position].choices[4].creator_profile_url != null) {
                        Glide.with(ctx)
                            .load(dataList[position].choices[4].creator_profile_url)
                            .apply(RequestOptions().circleCrop()).into(holder.img_item5)
                    } else holder.img_item5.setVisibility(View.GONE)
                }
            }
        }

        holder.title.text = dataList[position].title
        if (dataList[position].contents != null) {
            holder.explain.text = "# " + dataList[position].contents
        } else holder.explain.text = "#"

        holder.txt_itemname1.text = "ㅁ"//dataList[position].choices[0].name
        holder.txt_itemname2.text = "ㅁ"//dataList[position].choices[1].name
        if (dataList[position].choices.size >= 3) {
            holder.txt_itemname3.text = dataList[position].choices[2].name
            if (dataList[position].choices.size >= 4) {
                holder.txt_itemname4.text = dataList[position].choices[3].name
                if (dataList[position].choices.size >= 5) {
                    holder.txt_itemname5.text = dataList[position].choices[4].name
                }
            }
        }

        if (dataList[position].my_choice == null) { //투표완료 안했으면
            holder.txt_ongoing.setVisibility(View.GONE)
            holder.txt_dayleft.text = "${2}일 후 개표" //이거 수정ㅠㅠ
            holder.txt_rank1.setVisibility(View.GONE)
            holder.txt_rank2.setVisibility(View.GONE)
            holder.txt_rank3.setVisibility(View.GONE)
            holder.txt_rank4.setVisibility(View.GONE)
            holder.txt_rank5.setVisibility(View.GONE)
            holder.txt_votenum1.setVisibility(View.GONE)
            holder.txt_votenum2.setVisibility(View.GONE)
            holder.txt_votenum4.setVisibility(View.GONE)
            holder.txt_votenum3.setVisibility(View.GONE)
            holder.txt_votenum5.setVisibility(View.GONE)
            holder.letsVote.text = "투표하기"
            holder.stamp.setVisibility(View.GONE)

            if (dataList[position].choices.size < 5) {
                holder.line5.setVisibility(View.GONE)
                if (dataList[position].choices.size < 4) {
                    holder.line4.setVisibility(View.GONE)
                    if (dataList[position].choices.size <3) {
                        holder.line3.setVisibility(View.GONE)
                    }
                }
            }

            holder.imageView1.setOnClickListener {
                check1 = 1 - check1;
                if (check1 == 1) {
                    holder.imageView1.setImageResource(R.drawable.btn_check)
                    holder.letsVote.setTextColor(Color.parseColor("#ff57f7"));
                } else {
                    holder.imageView1.setImageResource(R.drawable.btn_uncheck)
                    holder.letsVote.setTextColor(Color.parseColor("#aaaaaa"));
                }
                holder.imageView2.setImageResource(R.drawable.btn_uncheck); check2 = 0;
                holder.imageView3.setImageResource(R.drawable.btn_uncheck); check3 = 0;
                holder.imageView4.setImageResource(R.drawable.btn_uncheck); check4 = 0;
                holder.imageView5.setImageResource(R.drawable.btn_uncheck); check5 = 0;
            }
            holder.imageView2.setOnClickListener {
                check2 = 2 - check2;
                if (check2 == 2) {
                    holder.imageView2.setImageResource(R.drawable.btn_check)
                    holder.letsVote.setTextColor(Color.parseColor("#ff57f7"));
                } else {
                    holder.imageView2.setImageResource(R.drawable.btn_uncheck)
                    holder.letsVote.setTextColor(Color.parseColor("#aaaaaa"));
                }
                holder.imageView1.setImageResource(R.drawable.btn_uncheck); check1 = 0;
                holder.imageView3.setImageResource(R.drawable.btn_uncheck); check3 = 0;
                holder.imageView4.setImageResource(R.drawable.btn_uncheck); check4 = 0;
                holder.imageView5.setImageResource(R.drawable.btn_uncheck); check5 = 0;
            }
            holder.imageView3.setOnClickListener {
                check3 = 3 - check3;
                if (check3 == 3) {
                    holder.imageView3.setImageResource(R.drawable.btn_check)
                    holder.letsVote.setTextColor(Color.parseColor("#ff57f7"));
                } else {
                    holder.imageView3.setImageResource(R.drawable.btn_uncheck)
                    holder.letsVote.setTextColor(Color.parseColor("#aaaaaa"));
                }
                holder.imageView1.setImageResource(R.drawable.btn_uncheck); check1 = 0;
                holder.imageView2.setImageResource(R.drawable.btn_uncheck); check2 = 0;
                holder.imageView4.setImageResource(R.drawable.btn_uncheck); check4 = 0;
                holder.imageView5.setImageResource(R.drawable.btn_uncheck); check5 = 0;
            }
            holder.imageView4.setOnClickListener {
                check4 = 4 - check4;
                if (check4 == 4) {
                    holder.imageView4.setImageResource(R.drawable.btn_check)
                    holder.letsVote.setTextColor(Color.parseColor("#ff57f7"));
                } else {
                    holder.imageView4.setImageResource(R.drawable.btn_uncheck)
                    holder.letsVote.setTextColor(Color.parseColor("#aaaaaa"));
                }
                holder.imageView1.setImageResource(R.drawable.btn_uncheck); check1 = 0;
                holder.imageView2.setImageResource(R.drawable.btn_uncheck); check2 = 0;
                holder.imageView3.setImageResource(R.drawable.btn_uncheck); check3 = 0;
                holder.imageView5.setImageResource(R.drawable.btn_uncheck); check5 = 0;
            }
            holder.imageView5.setOnClickListener {
                check5 = 5 - check5;
                if (check5 == 5) {
                    holder.imageView5.setImageResource(R.drawable.btn_check)
                    holder.letsVote.setTextColor(Color.parseColor("#ff57f7"));
                } else {
                    holder.imageView5.setImageResource(R.drawable.btn_uncheck)
                    holder.letsVote.setTextColor(Color.parseColor("#aaaaaa"));
                }
                holder.imageView1.setImageResource(R.drawable.btn_uncheck); check1 = 0;
                holder.imageView2.setImageResource(R.drawable.btn_uncheck); check2 = 0;
                holder.imageView4.setImageResource(R.drawable.btn_uncheck); check4 = 0;
                holder.imageView3.setImageResource(R.drawable.btn_uncheck); check3 = 0;
            }
            holder.letsVote.setOnClickListener {
                //로그인한 경우 안한경우 조건문 추가
                postVoteResponse(dataList[position].vote_idx, dataList[position].my_choice)

            }

        } else { //투표한 투표
            //여기 수정해야 합니다
            var a = dataList[position].choices.size
            var b:Int=0
            holder.txt_dayleft.text = "${2}일 후 마감" //이것도 수정..!
            holder.letsVote.text = "투표완료"
            if (dataList[position].choices.size>=3){
                holder.txt_rank3.text = "${dataList[position].choices[2].rank}등"
                holder.txt_votenum3.text = "${dataList[position].choices[2].count}표"

                if (dataList[position].choices.size >= 4){
                    holder.txt_rank4.text = "${dataList[position].choices[3].rank}등"
                    holder.txt_votenum4.text = "${dataList[position].choices[3].count}표"

                    if (dataList[position].choices.size == 5){
                        holder.txt_rank5.text = "${dataList[position].choices[4].rank}등"
                        holder.txt_votenum5.text = "${dataList[position].choices[4].count}표"
                    }
                }
            }
            //if (dataList[position].choices[b].rank == 1) holder.txt_rank1.setTextColor(Color.parseColor("ff57f7"))
            holder.txt_rank1.text = "1등"//"${dataList[position].choices[0].rank}등"
            holder.txt_rank2.text = "1등"//"${dataList[position].choices[1].rank}등"
            holder.txt_votenum1.text = "1등"//"${dataList[position].choices[0].count}표"
            holder.txt_votenum2.text = "1등"//"${dataList[position].choices[1].count}표"

            if (dataList[position].choices.size < 5) holder.line5.setVisibility(View.GONE)
            if (dataList[position].choices.size < 4) holder.line4.setVisibility(View.GONE)
            if (dataList[position].choices.size < 3) holder.line3.setVisibility(View.GONE)

            //if (dataList[position].my_choice == dataList[position].choices[0])
        }

    }
    fun postVoteResponse(x:Int, y:Int){
        //var jsonObject: JSONObject
       /* var jsonObject: JSONObject()
        //jsonObject.put("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkeCI6OSwiZ3JhZGUiOiJBRE1JTiIsIm5hbWUiOiJjcmVjcmUiLCJpYXQiOjE1NjI4NTAwMDgsImV4cCI6MTU2NDA1OTYwOCwiaXNzIjoieWFuZyJ9.hxJxPliUE0puOrDvUpSibnIZUyn7sdR6az0Amg-uR8o")
        //jsonObject.put("voteIdx", x)
        jsonObject.put("choiceidx",y)

        val gsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject

        val postVoteResponse: Call<PostVoteChoiceResponse> =
            VoteNetworkService.postVoteResponse
        //("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkeCI6OSwiZ3JhZGUiOiJBRE1JTiIsIm5hbWUiOiJjcmVjcmUiLCJpYXQiOjE1NjI4NTAwMDgsImV4cCI6MTU2NDA1OTYwOCwiaXNzIjoieWFuZyJ9.hxJxPliUE0puOrDvUpSibnIZUyn7sdR6az0Amg-uR8o", gsonObject)
        //postVoteResponse*/
    }

}


