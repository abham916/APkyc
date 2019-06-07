package com.example.superheroessqlite

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_add_n_update_data.*
import kotlinx.android.synthetic.main.fragment_add_n_update_data.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_HERO_NAME = "param1"
private const val ARG_HERO_GENDER = "param2"
private const val ARG_HERO_POWER = "param3"
private const val ARG_HERO_IMAGEID = "param4"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [UpdateDataFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [UpdateDataFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class UpdateDataFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var heroName: String? = null
    private var heroGender: String? = null
    private var heroPower: Int? = null
    private var heroImageID: Int? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            heroName = it.getString(ARG_HERO_NAME)
            heroGender = it.getString(ARG_HERO_GENDER)
            heroPower = it.getInt(ARG_HERO_POWER)
            heroImageID = it.getInt(ARG_HERO_GENDER)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_add_n_update_data, container, false)
        root.btnConfirm.text = "Update"
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val imageName = view.context!!.resources.getResourceEntryName(heroImageID!!)
        editHeroName.setText(heroName)
        editHeroGender.setText(heroGender)
        editHeroPower.setText(heroPower.toString())
//        if(imageName != null) editHeroImage.setText(imageName)

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
                HeroFragment.dbHandler.updateHero(activity, hero, heroName!!)

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
         * @return A new instance of fragment UpdateDataFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String, param3: Int, param4: Int) =
            UpdateDataFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_HERO_NAME, param1)
                    putString(ARG_HERO_GENDER, param2)
                    putInt(ARG_HERO_POWER, param3)
                    putInt(ARG_HERO_IMAGEID, param4)
                }
            }
    }
}
