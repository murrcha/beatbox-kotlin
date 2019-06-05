package com.kkaysheva.beatbox.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.kkaysheva.beatbox.model.BeatBox
import com.kkaysheva.beatbox.model.Sound

class SoundViewModel(private val beatBox: BeatBox) : BaseObservable() {
    var sound: Sound? = null
        set(value) {
        field = value
        notifyChange()
    }

    @Bindable
    fun onButtonClicked() {
        sound?.let {
            beatBox.play(it)
        }
    }
}
