package com.pancake.footballfever.ui.selectFavoriteTeams

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentSelectFavoriteTeamsBinding
import com.pancake.footballfever.domain.models.FavoriteTeam
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.selectFavoriteTeams.adapter.MyItemDetailsLookup
import com.pancake.footballfever.ui.selectFavoriteTeams.adapter.MyItemKeyProvider
import com.pancake.footballfever.ui.selectFavoriteTeams.adapter.SelectFavoriteTeamsAdapter
import com.pancake.footballfever.utilities.EventObserver
import com.pancake.footballfever.utilities.SharedPrefManager
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Calendar

@AndroidEntryPoint
class SelectFavoriteTeamsFragment :
    BaseFragment<FragmentSelectFavoriteTeamsBinding, SelectFavoriteTeamsViewModel>() {
    override val layoutId = R.layout.fragment_select_favorite_teams
    override val viewModel: SelectFavoriteTeamsViewModel by viewModels()

    private var tracker: SelectionTracker<FavoriteTeam>? = null
    private var selectedTeams = mutableListOf<FavoriteTeam>()
    private val args: SelectFavoriteTeamsFragmentArgs by navArgs()
    private val calendar = Calendar.getInstance()
    private var season = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showInitialDialog()
        initOnClickListener()
        getPremierLeagueTeams()
        initRecyclerAdapter()
        observeEvents()
    }

    private fun showInitialDialog() {
        AlertDialog.Builder(this.requireContext()).setTitle(getString(R.string.hint))
            .setMessage(getString(R.string.hint_to_select_favorite_teams))
            .setPositiveButton(getString(R.string.ok)) { dialogInterface, which ->
                dialogInterface.cancel()
            }.create().show()
    }

    private fun initOnClickListener() {
        binding.refreshButton.setOnClickListener {
            formatDate()
            viewModel.getPremierLeagueTeams(args.countryName, season)
        }
    }

    private fun getPremierLeagueTeams() {
        formatDate()
        viewModel.getPremierLeagueTeams(args.countryName, season)
    }

    private fun initRecyclerAdapter() {
        val recycler = binding.favoriteTeamsRecycler
        val adapter = SelectFavoriteTeamsAdapter(viewModel)
        binding.favoriteTeamsRecycler.adapter = adapter
        tracker = SelectionTracker.Builder(
            "mySelection",
            recycler,
            MyItemKeyProvider(adapter),
            MyItemDetailsLookup(recycler),
            StorageStrategy.createParcelableStorage(FavoriteTeam::class.java)
        ).withSelectionPredicate(
            SelectionPredicates.createSelectAnything()
        ).build()

        adapter.tracker = tracker

        tracker?.addObserver(
            object : SelectionTracker.SelectionObserver<FavoriteTeam>() {
                override fun onSelectionChanged() {
                    super.onSelectionChanged()
                    tracker?.let {
                        selectedTeams.addAll(it.selection.toMutableList())
                    }
                }
            })
    }

    private fun observeEvents() {
        viewModel.nextEvent.observe(viewLifecycleOwner, EventObserver {
            if (selectedTeams.isNotEmpty()) {
                SharedPrefManager.isSelectFavoriteTeams = true
                viewModel.addFavoriteTeams(selectedTeams)
                val nav =
                    SelectFavoriteTeamsFragmentDirections.actionSelectFavoriteTeamsFragmentToHomeFragment()
                findNavController().navigate(nav)
            } else {
                showAlertDialog()
            }
        })
    }

    private fun showAlertDialog() {
        AlertDialog.Builder(this.requireContext()).setTitle(getString(R.string.alert))
            .setMessage(getString(R.string.alert_selection))
            .setPositiveButton(getString(R.string.ok)) { dialogInterface, which ->
                dialogInterface.cancel()
            }.create().show()
    }

    private fun formatDate() {
        season = SimpleDateFormat("YYYY").format(calendar.time).toInt().minus(1)
    }
}