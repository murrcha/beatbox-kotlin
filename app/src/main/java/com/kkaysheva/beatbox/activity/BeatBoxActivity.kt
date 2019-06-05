package com.kkaysheva.beatbox.activity

import androidx.fragment.app.Fragment
import com.kkaysheva.beatbox.fragment.BeatBoxFragment

open class BeatBoxActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment = BeatBoxFragment.newInstance()
}
