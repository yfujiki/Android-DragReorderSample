package com.yfujiki.android_dragreordersample

import android.app.ActionBar
import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MainRecyclerViewAdapter(this)
    }

}

class MainRecyclerViewAdapter(val activity: Activity): RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder>() {
    val emojis = listOf(
        "😀",
        "😃",
        "😄",
        "😁",
        "😆",
        "😅",
        "😂",
        "🤣",
        "☺️",
        "😊",
        "😇",
        "🙂",
        "🙃",
        "😉"
    )

    override fun getItemCount(): Int {
        return emojis.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val emoji = emojis[position]
        val textView = holder.itemView as TextView
        textView.text = emoji
        textView.textSize = 64F
        textView.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
        textView.setTextColor(Color.parseColor("#000000"))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val textView = TextView(activity)
        var layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        textView.layoutParams = layoutParams

        val viewHolder = ViewHolder(textView)
        return viewHolder
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    }
}

