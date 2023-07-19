package com.example.sayursegar.ui

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.example.sayursegar.R
import com.example.sayursegar.model.Fresh
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class FirstFragmentDirections private constructor() {
  private data class ActionFirstFragmentToSecondFragment(
    public val fresh: Fresh?
  ) : NavDirections {
    public override val actionId: Int = R.id.action_FirstFragment_to_SecondFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
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
  }

  public companion object {
    public fun actionFirstFragmentToSecondFragment(fresh: Fresh?): NavDirections =
        ActionFirstFragmentToSecondFragment(fresh)
  }
}
