package com.easefun.polyvsdk.live.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.easefun.polyvsdk.live.R;

public class PolyvDialogFragment extends DialogFragment {
    public String message;

    public void show(FragmentManager manager, String tag, String message) {
        this.message = message;
        show(manager, tag);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog alertDialog = new AlertDialog.Builder(getContext()).setTitle("温馨提示")
                .setMessage(message)
                .setPositiveButton("知道了", null)
                .show();
        // show之后才可以获取，否则获取为null
        alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.center_view_color_blue));
        return alertDialog;
    }
}
