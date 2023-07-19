// Generated by view binder compiler. Do not edit!
package com.example.sayursegar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.sayursegar.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRegisterBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText PasseditText;

  @NonNull
  public final TextView PasstextView;

  @NonNull
  public final EditText fullnameeditText;

  @NonNull
  public final TextView fullnametextView;

  @NonNull
  public final Button loginButton;

  @NonNull
  public final EditText unameeditText;

  @NonNull
  public final TextView unametextView;

  private ActivityRegisterBinding(@NonNull ConstraintLayout rootView,
      @NonNull EditText PasseditText, @NonNull TextView PasstextView,
      @NonNull EditText fullnameeditText, @NonNull TextView fullnametextView,
      @NonNull Button loginButton, @NonNull EditText unameeditText,
      @NonNull TextView unametextView) {
    this.rootView = rootView;
    this.PasseditText = PasseditText;
    this.PasstextView = PasstextView;
    this.fullnameeditText = fullnameeditText;
    this.fullnametextView = fullnametextView;
    this.loginButton = loginButton;
    this.unameeditText = unameeditText;
    this.unametextView = unametextView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_register, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRegisterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.PasseditText;
      EditText PasseditText = ViewBindings.findChildViewById(rootView, id);
      if (PasseditText == null) {
        break missingId;
      }

      id = R.id.PasstextView;
      TextView PasstextView = ViewBindings.findChildViewById(rootView, id);
      if (PasstextView == null) {
        break missingId;
      }

      id = R.id.fullnameeditText;
      EditText fullnameeditText = ViewBindings.findChildViewById(rootView, id);
      if (fullnameeditText == null) {
        break missingId;
      }

      id = R.id.fullnametextView;
      TextView fullnametextView = ViewBindings.findChildViewById(rootView, id);
      if (fullnametextView == null) {
        break missingId;
      }

      id = R.id.loginButton;
      Button loginButton = ViewBindings.findChildViewById(rootView, id);
      if (loginButton == null) {
        break missingId;
      }

      id = R.id.unameeditText;
      EditText unameeditText = ViewBindings.findChildViewById(rootView, id);
      if (unameeditText == null) {
        break missingId;
      }

      id = R.id.unametextView;
      TextView unametextView = ViewBindings.findChildViewById(rootView, id);
      if (unametextView == null) {
        break missingId;
      }

      return new ActivityRegisterBinding((ConstraintLayout) rootView, PasseditText, PasstextView,
          fullnameeditText, fullnametextView, loginButton, unameeditText, unametextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}