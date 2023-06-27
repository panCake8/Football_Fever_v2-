package com.pancake.footballfever.ui.favourites.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.pancake.footballfever.BR
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.ItemFavouritesBinding
import com.pancake.footballfever.domain.models.FavoriteTeam
import com.pancake.footballfever.ui.base.BaseAdapter
import com.pancake.footballfever.ui.favourites.FavouritesViewModel

class FavouriteTeamsAdapter(
    val viewModel: FavouritesViewModel,
    private val onClickUnFollow: (Int) -> Unit,
    private val onCardClick: (FavoriteTeam) -> Unit
) : BaseAdapter<FavoriteTeam>(viewModel) {
    override val getLayoutId = R.layout.item_favourites

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        when(holder){
            is FavouriteViewHolder->bindFavorite(holder,position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return FavouriteViewHolder(DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            getLayoutId,
            parent,
            false
        ))
    }

    private fun bindFavorite(holder: FavouriteViewHolder, position: Int) {
        val currentItem =  getItem(position)
        holder.binding.apply {
            this.root.setOnClickListener {
                onCardClick(FavoriteTeam(currentItem.id,currentItem.name,currentItem.logo))
            }
            this.btn.setOnClickListener {
                   onClickUnFollow(currentItem.id!!)
            }
            setVariable(BR.item, currentItem)
        }

    }


    inner class FavouriteViewHolder(val binding: ItemFavouritesBinding):BaseViewHolder(binding)

}