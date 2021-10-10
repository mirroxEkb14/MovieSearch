package com.amirovdev.moviesearch.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Describes a film
 *
 * With @Parcelize we can pass the film to another activity
 */

@Parcelize
data class Film(val title: String, val poster: Int, val desc: String): Parcelable
