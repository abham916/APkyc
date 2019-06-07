package com.example.superheroessqlite

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat.getSystemService
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_add_n_update_data.*
import kotlinx.android.synthetic.main.fragment_add_n_update_data.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AddDataFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AddDataFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class AddDataFragment : Fragment() {
    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_add_n_update_data, container, false)
        root.btnConfirm.text = "Add"

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        view.setOnTouchListener{ v: View, event: MotionEvent ->
//            val imm = (context.INPUT_METHOD_SERVICE) as InputMethodManager
//            imm.hideSoftInputFromWindow(windowToken, 0)
//            true
//        }
        btnConfirm.setOnClickListener(){
            if(editHeroName.text.isEmpty() || editHeroGender.text.isEmpty() || editHeroPower.text.isEmpty())
                Toast.makeText(context, "Hero's name, gender, and power must be filled out!", Toast.LENGTH_LONG).show()
            else {
                val hero = Hero()

                hero.name = editHeroName.text.toString()
                hero.gender = editHeroGender.text.toString()
                hero.power = editHeroPower.text.toString().toInt()
                if(editHeroImage.text.isEmpty()) hero.image = 0
                else {
                    val imageID = context!!.resources.getIdentifier(editHeroImage.text.toString(),
                        "drawable", "com.example.superheroessqlite")
                    hero.image = imageID
                }
                HeroFragment.dbHandler.addHero(activity, hero)

                fragmentManager!!
                    .beginTransaction()
                    .replace(R.id.fragContainer, HeroFragment())
                    .commit()
            }
        }

        btnCancle.setOnClickListener(){
            fragmentManager!!
                .beginTransaction()
                .replace(R.id.fragContainer, HeroFragment())
                .commit()
        }
    }


//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (context is OnFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
//        }
//    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddDataFragment.
         */
        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            AddDataFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
    }
}
