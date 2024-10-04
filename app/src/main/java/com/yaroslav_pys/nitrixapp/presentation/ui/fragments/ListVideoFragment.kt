package com.yaroslav_pys.nitrixapp.presentation.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yaroslav_pys.nitrixapp.data.remote.dto.Video
import com.yaroslav_pys.nitrixapp.databinding.VideoListFragmentBinding
import com.yaroslav_pys.nitrixapp.presentation.base.BaseFragment
import com.yaroslav_pys.nitrixapp.presentation.recuclersAD.videosAdapterDelegate
import com.yaroslav_pys.nitrixapp.presentation.utils.recyclers.AsyncListDiffDelegationAdapter
import com.yaroslav_pys.nitrixapp.presentation.viewmodels.ShowVideoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListVideoFragment : BaseFragment<VideoListFragmentBinding>() {

    private val viewModel: ShowVideoViewModel by viewModels()
    private val videosAdapter = AsyncListDiffDelegationAdapter(
        videosAdapterDelegate(
            openFullClick = ::openFullClick,
        )
    )

    private fun openFullClick(video: Video) {
        findNavController().navigate(
            ListVideoFragmentDirections.actionListVideoFragmentToExoFullscreen(
                video.sources[0]
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = VideoListFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        requestData()
        setupObserver()
    }

    private fun initUi() {
        with(binding.listVideoRecycler) {
            adapter = videosAdapter
        }

    }

    private fun requestData() {
        viewModel.getVideoListInfo()
    }

    private fun setupObserver() {
        viewModel.videos.observe(viewLifecycleOwner) { data ->
            Log.d("yarek","data "+data?.categories?.get(0)?.nameVideos)
            Log.d("yarek","data "+ (data?.categories?.get(0)?.nameVideos?.get(0)?.sources?.get(0) ?: "s"))
            videosAdapter.items = data?.categories?.get(0)?.nameVideos.orEmpty()
        }
    }

}