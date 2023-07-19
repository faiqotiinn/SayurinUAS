package com.example.sayursegar

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class HomeActivityDirections private constructor() {
  public companion object {
    public fun actionHomeActivityToFirstFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.actionHomeActivity_to_FirstFragment)
  }
}
