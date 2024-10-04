package com.yaroslav_pys.nitrixapp.presentation.recuclersAD

import android.annotation.SuppressLint
import android.net.Uri
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.yaroslav_pys.nitrixapp.data.remote.dto.Video
import com.yaroslav_pys.nitrixapp.databinding.ItemVideoDataBinding
import com.yaroslav_pys.nitrixapp.presentation.utils.recyclers.diffAdapterDelegateLayoutContainer

@SuppressLint("NotifyDataSetChanged")
fun videosAdapterDelegate(
    openFullClick: (Video) -> Unit,
) = diffAdapterDelegateLayoutContainer<Video, Any, ItemVideoDataBinding>(
    viewBinding = { inflater, root -> ItemVideoDataBinding.inflate(inflater, root, false) },
    on = { item: Any, _: List<Any>, _: Int -> item is Video },
    same = { oldItem: Video, newItem: Video -> oldItem == newItem },
    contentEquals = { oldItem: Video, newItem: Video ->
        oldItem == newItem
    }
) {

    bind { payloadBundle ->
        with(binding) {
            rootItem.setOnClickListener {
                openFullClick.invoke(item)
            }
            title.text = item.title
            description.text = item.description

            val uri: Uri = Uri.parse(item.sources[0])
            val player = SimpleExoPlayer.Builder(root.context).build()
            videoPlayer.player = player

            val mediaItem = MediaItem.fromUri(uri)
            player.setMediaItem(mediaItem)

            player.prepare()
            player.play()
        }
    }
}