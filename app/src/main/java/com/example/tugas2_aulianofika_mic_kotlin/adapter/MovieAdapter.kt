package com.example.tugas2_aulianofika_mic_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas2_aulianofika_mic_kotlin.MovieActivity
import com.example.tugas2_aulianofika_mic_kotlin.R
import com.example.tugas2_aulianofika_mic_kotlin.model.ModelMovie

class MovieAdapter constructor(
    private val getActivity: MovieActivity, //agar recycle bisa diklik
    private val movieList: List<ModelMovie>

) : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    class MyViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        val txtMovie: TextView = itemView.findViewById(R.id.txtmovie)
        val imgMovie: ImageView = itemView.findViewById(R.id.imgmovie)
        val cardMovie: CardView = itemView.findViewById(R.id.cardMovie)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie_card, parent, false)
        return MyViewHolder(nView)
    }

    override fun onBindViewHolder(holder: MovieAdapter.MyViewHolder, position: Int) {
      holder.txtMovie.text = movieList[position].titlle
      holder.imgMovie.setImageResource(movieList[position].image)

      //untuk bisa diklik
      holder.cardMovie.setOnClickListener(){
          Toast.makeText(getActivity, movieList[position].titlle,
              Toast.LENGTH_SHORT).show()
      }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}