package com.pancake.footballfever.ui.league_state.top_score

import androidx.lifecycle.ViewModel
import com.pancake.footballfever.ui.league_state.top_score.adapter.TopScorerListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopScorerViewModel @Inject constructor(): ViewModel(), TopScorerListener {
}