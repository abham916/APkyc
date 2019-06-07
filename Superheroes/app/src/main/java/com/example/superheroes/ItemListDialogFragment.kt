package com.example.superheroes

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_item_list_dialog.*
import kotlinx.android.synthetic.main.fragment_item_list_dialog.view.*


// TODO: Customize parameter argument names
const val ARG_NAME = "Name"
const val ARG_GENDER = "Gender"
const val ARG_POWER = "Power"
const val ARG_IMAGE = "Image"

/**
 *
 * A fragment that shows a list of items as a modal bottom sheet.
 *
 * You can show this modal bottom sheet from your activity like this:
 * <pre>
 *    ItemListDialogFragment.newInstance(30).show(supportFragmentManager, "dialog")
 * </pre>
 *
 * You activity (or fragment) needs to implement [ItemListDialogFragment.Listener].
 */
class ItemListDialogFragment : BottomSheetDialogFragment() {
    private var mListener: Listener? = null
    private var paramName: String? = null
    private var paramPower: Int? = null
    private var paramGender: String? = null
    private var paramImageUrl: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            paramName = it.getString(ARG_NAME)
            paramPower = it.getInt(ARG_POWER)
            paramGender = it.getString(ARG_GENDER)
            paramImageUrl = it.getInt(ARG_IMAGE)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_item_list_dialog, container, false)
        root.imageView.setImageResource(paramImageUrl!!)
        root.textViewHName.text = paramName
        root.textViewHGender.text = paramGender
        root.textViewHPower.text = paramPower.toString()
        return root
    }



//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        val parent = parentFragment
//        if (parent != null) {
//            mListener = parent as Listener
//        } else {
//            mListener = context as Listener
//        }
//    }

//    override fun onDetach() {
//        mListener = null
//        super.onDetach()
//    }

    interface Listener {
        fun onItemClicked(position: Int)
    }
//
//    private inner class ViewHolder internal constructor(inflater: LayoutInflater, parent: ViewGroup) :
//        RecyclerView.ViewHolder(inflater.inflate(R.layout.fragment_item_list_dialog_item, parent, false)) {
//
//        internal val text: TextView = itemView.text
//
//        init {
//            text.setOnClickListener {
//                mListener?.let {
//                    it.onItemClicked(adapterPosition)
//                    dismiss()
//                }
//            }
//        }
//    }

//    private inner class ItemAdapter internal constructor(private val mItemCount: Int) :
//        RecyclerView.Adapter<ViewHolder>() {
//
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//            return ViewHolder(LayoutInflater.from(parent.context), parent)
//        }
//
//        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//            holder.text.text = position.toString()
//        }
//
//        override fun getItemCount(): Int {
//            return mItemCount
//        }
//    }

    companion object {

        // TODO: Customize parameters
        fun newInstance(name: String, gender: String, power: Int, image: Int): ItemListDialogFragment =
            ItemListDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, name)
                    putString(ARG_GENDER, gender)
                    putInt(ARG_POWER, power)
                    putInt(ARG_IMAGE, image)
                }
            }

    }
}
