package com.example.mvvmexample.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexample.databinding.NewsRowItemBinding
import com.example.mvvmexample.models.coronaNews.CoronaNewsResult

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.MyViewlHolder>() {

     val newsList = arrayListOf<CoronaNewsResult>()

    class MyViewlHolder(private val binding: NewsRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(coronaNewsResult: CoronaNewsResult) {

            binding.coronaNewsResult = coronaNewsResult
            binding.executePendingBindings()

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewlHolder {
        val binding: NewsRowItemBinding =
            NewsRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewlHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewlHolder, position: Int) {
        val news = newsList[position]
        holder.bind(news)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }


}