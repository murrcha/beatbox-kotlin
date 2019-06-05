package com.kkaysheva.beatbox.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kkaysheva.beatbox.R
import com.kkaysheva.beatbox.viewmodel.SoundViewModel
import com.kkaysheva.beatbox.databinding.ListItemSoundBinding
import com.kkaysheva.beatbox.model.BeatBox
import com.kkaysheva.beatbox.model.Sound

class SoundAdapter(private val beatBox: BeatBox) : RecyclerView.Adapter<SoundAdapter.SoundHolder>() {

    private val sounds = arrayListOf<Sound>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil
            .inflate<ListItemSoundBinding>(
                inflater,
                R.layout.list_item_sound,
                parent, false
            )
        return SoundHolder(binding, beatBox)
    }

    override fun getItemCount(): Int = sounds.size

    override fun onBindViewHolder(holder: SoundHolder, position: Int) {
        val sound = sounds[position]
        holder.bind(sound)
    }

    fun setSounds(sounds: List<Sound>) {
        this.sounds.clear()
        this.sounds.addAll(sounds)
        notifyDataSetChanged()
    }

    class SoundHolder(
        private val binding: ListItemSoundBinding,
        beatBox: BeatBox) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.viewModel = SoundViewModel(beatBox)
        }

        fun bind(sound: Sound) {
            binding.viewModel!!.sound = sound
            binding.executePendingBindings()
        }
    }
}
