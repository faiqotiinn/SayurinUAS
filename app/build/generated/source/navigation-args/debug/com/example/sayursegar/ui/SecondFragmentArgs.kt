package com.example.sayursegar.ui

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.example.sayursegar.model.Fresh
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class SecondFragmentArgs(
  public val fresh: Fresh?
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(Fresh::class.java)) {
      result.putParcelable("fresh", this.fresh as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(Fresh::class.java)) {
      result.putSerializable("fresh", this.fresh as Serializable?)
    } else {
      throw UnsupportedOperationException(Fresh::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Fresh::class.java)) {
      result.set("fresh", this.fresh as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(Fresh::class.java)) {
      result.set("fresh", this.fresh as Serializable?)
    } else {
      throw UnsupportedOperationException(Fresh::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): SecondFragmentArgs {
      bundle.setClassLoader(SecondFragmentArgs::class.java.classLoader)
      val __fresh : Fresh?
      if (bundle.containsKey("fresh")) {
        if (Parcelable::class.java.isAssignableFrom(Fresh::class.java) ||
            Serializable::class.java.isAssignableFrom(Fresh::class.java)) {
          __fresh = bundle.get("fresh") as Fresh?
        } else {
          throw UnsupportedOperationException(Fresh::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"fresh\" is missing and does not have an android:defaultValue")
      }
      return SecondFragmentArgs(__fresh)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): SecondFragmentArgs {
      val __fresh : Fresh?
      if (savedStateHandle.contains("fresh")) {
        if (Parcelable::class.java.isAssignableFrom(Fresh::class.java) ||
            Serializable::class.java.isAssignableFrom(Fresh::class.java)) {
          __fresh = savedStateHandle.get<Fresh?>("fresh")
        } else {
          throw UnsupportedOperationException(Fresh::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"fresh\" is missing and does not have an android:defaultValue")
      }
      return SecondFragmentArgs(__fresh)
    }
  }
}
