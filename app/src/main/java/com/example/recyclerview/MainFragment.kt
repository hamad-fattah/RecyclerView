package com.example.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.fragment_countries.*
import kotlinx.android.synthetic.main.fragment_football_teams.*
import kotlinx.android.synthetic.main.fragment_main_screen.*
import kotlinx.android.synthetic.main.row_component.view.*


class MainFragment : Fragment(R.layout.fragment_main) {





    private val titles = arrayListOf(
            Screen(R.string.button_blank_one,R.id.blank),
            Screen(R.string.button_blank_two,R.id.blank)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Recycler_View_Countries.apply {
            adapter = CountryAdapter()
            layoutManager = LinearLayoutManager(requireContext())
        }

        Recycler_View_Football.apply {
            adapter = FootballAdapter()
            layoutManager = LinearLayoutManager(requireContext())
        }



        Recycler_View_Main.apply {
            adapter = MainRecyclerViewAdapter(titles, findNavController())
            layoutManager = GridLayoutManager(requireContext(), 2)
        }

    }

}

class MainRecyclerViewAdapter(
        private val components: List<Screen>,
        private val navController: NavController
) : Adapter<MainRecyclerViewAdapter.MainViewHolder>(){
   inner class MainViewHolder(itemView: View) : ViewHolder(itemView) {
        fun bind(screen: Screen){
            itemView.tvTitle.setText(screen.label)
            itemView.setOnClickListener { screen.screenID?.let {it1 -> navController.navigate(it1)  } }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view : View =
                LayoutInflater.from(parent.context).inflate(R.layout.row_component,parent,false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(components[position])
    }

    override fun getItemCount() = components.size
}

data class Screen(
        val label : Int,
        val screenID: Int? = null
)


