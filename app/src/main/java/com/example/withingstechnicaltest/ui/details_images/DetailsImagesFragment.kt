package com.example.withingstechnicaltest.ui.details_images

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.withingstechnicaltest.R
import com.example.withingstechnicaltest.ui.search_images.model.ImageSearchUi
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details_images.*

class DetailsImagesFragment : Fragment() {

    private val args: DetailsImagesFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details_images, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val selectedImages = args.selectedImages
        fragment_details_images_carousel.apply {
            setImageListener { position, imageView ->
                Picasso
                    .get()
                    .load(selectedImages[position].largeImageURL)
                    .into(imageView)
            }

            pageCount = selectedImages.size
        }
    }
}