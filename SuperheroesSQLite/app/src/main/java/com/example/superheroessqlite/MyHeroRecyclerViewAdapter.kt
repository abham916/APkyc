package com.example.superheroessqlite

import android.support.v4.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide


import kotlinx.android.synthetic.main.fragment_hero.view.*

class MyHeroRecyclerViewAdapter(
    private val activity: MainActivity,
    private val fragmentManager: FragmentManager,
    private val mValues: ArrayList<Hero>
//    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MyHeroRecyclerViewAdapter.ViewHolder>() {

//    private val mOnClickListener: View.OnClickListener

//    init {
//        mOnClickListener = View.OnClickListener { v ->
//            val item = v.tag as DummyItem
//            // Notify the active callbacks interface (the activity, if the fragment is attached to
//            // one) that an item has been selected.
//            mListener?.onListFragmentInteraction(item)
//        }
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_hero, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = mValues[position]
//        holder.mIdView.text = item.id
//        holder.mContentView.text = item.content
//
//        with(holder.mView) {
//            tag = item
//            setOnClickListener(mOnClickListener)
//        }
        val item = mValues[position]

//        holder.bind(item)
        holder.mView.hero_name.text = item.name
        holder.mView.hero_gender.text = item.gender
        holder.mView.hero_power.text = item.power.toString()
        Glide.with(activity)
            .load(item.image)
            .placeholder(R.drawable.unknown)
            .into(holder.mView.hero_image)

        Log.e("YC",item.image.toString())

        holder.mView.setOnClickListener(){
            val bottomSheetFragment =  HeroListDialogFragment.newInstance(item.name, item.gender, item.power, item.image)
            bottomSheetFragment.show(fragmentManager,"")
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
//        val mIdView: TextView = mView.item_number

//        fun bind(item: Hero){
//            mView.hero_name.text = item.name
//            mView.hero_gender.text = item.gender
//            mView.hero_power.text = item.power.toString()
//            mView.hero_image.setImageResource(item.image)
//        }


//        override fun toString(): String {
//            return super.toString() + " '" + mContentView.text + "'"
//        }
    }
}
