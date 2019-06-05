package com.kkaysheva.beatbox

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.kkaysheva.beatbox.model.BeatBox
import com.kkaysheva.beatbox.model.Sound
import com.kkaysheva.beatbox.viewmodel.SoundViewModel
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class SoundViewModelTest {

    private lateinit var beatBox: BeatBox
    private lateinit var sound: Sound
    private lateinit var subject: SoundViewModel

    @Before
    fun setUp() {
        beatBox = mock(BeatBox::class.java)
        sound = Sound("assetPath")
        subject = SoundViewModel(beatBox)
        subject.sound = sound
    }

    @Test
    fun exposesSoundNameAsTitle() {
        assertThat(subject.sound!!.name).isEqualTo(sound.name)
    }

    @Test
    fun callsBeatBoxPlayOnButtonClicked() {
        subject.onButtonClicked()

        verify(beatBox).play(sound)
    }
}
