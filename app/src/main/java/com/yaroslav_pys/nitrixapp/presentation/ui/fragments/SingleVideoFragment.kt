package com.yaroslav_pys.nitrixapp.presentation.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.yaroslav_pys.nitrixapp.databinding.FullScreenVideoFragmentBinding
import com.yaroslav_pys.nitrixapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SingleVideoFragment : BaseFragment<FullScreenVideoFragmentBinding>() {
    private var player: ExoPlayer? = null
    private val args: SingleVideoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FullScreenVideoFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        player = getPlayer(binding.videoPlayer.context)
        binding.videoPlayer.player = player
        playVideo(getVideo())

    }

    private fun playVideo(url: String) {
        player?.run {
            addMediaItem(getMediaItem(url))
            prepare()
            play()
        }
    }

    fun getPlayer(context: Context): ExoPlayer {
        return ExoPlayer.Builder(context)
            .setMediaSourceFactory(getMediaSource(context))
            .build()
    }

    private fun getMediaItem(url: String): MediaItem {
        return MediaItem.fromUri(url)
    }

    private fun getSourceFactory(context: Context): DataSource.Factory {
        return DefaultDataSource.Factory(context)
    }

    private fun getMediaSource(context: Context): MediaSource.Factory {
        return ProgressiveMediaSource.Factory(getSourceFactory(context))
    }

    private fun getVideo(): String {
        return args.videos
    }

}