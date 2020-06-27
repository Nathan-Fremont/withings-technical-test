package com.example.withingstechnicaltest.ui.search_images

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.withingstechnicaltest.R
import com.example.withingstechnicaltest.ui.search_images.model.ImageSearchUi
import com.example.withingstechnicaltest.ui.search_images.view.adapter.SearchImagesAdapter
import kotlinx.android.synthetic.main.fragment_search_images.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class SearchImagesFragment : Fragment() {

    private val viewModel: SearchImagesViewModel by viewModel()
    private val recyclerAdapter: SearchImagesAdapter by lazy {
        SearchImagesAdapter(
            selectedItems
        )
    }
    private val selectedItems = ArrayList<ImageSearchUi>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_images, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_search_images_recycler_view.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = recyclerAdapter
        }

        viewModel.uiData.observe(viewLifecycleOwner, Observer { listImages ->
            Timber.d("Got some images, will submit them to adapter")
            selectedItems.clear()
            recyclerAdapter.submitList(listImages)
        })

        fragment_search_images_search_view.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Timber.d("onQueryTextSubmit with query : $query")
                viewModel.searchImagesWithQuery(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })

        fragment_search_images_floating_button.setOnClickListener {
            if (selectedItems.size >= 2) {
                val action =
                    SearchImagesFragmentDirections.actionSearchImagesFragmentToDetailsImagesFragment(
                        selectedItems.toTypedArray()
                    )
                findNavController().navigate(action)
            } else {
                Toast
                    .makeText(
                        context,
                        getString(R.string.fragment_search_images_error_selected_not_enough),
                        Toast.LENGTH_SHORT
                    )
                    .show()
            }
        }
    }
}