package com.easefun.polyvsdk.live.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.easefun.polyvsdk.live.R;

import java.lang.reflect.Field;

public class PolyvTipsFragment extends DialogFragment {
    private String message;
    private DialogInterface.OnClickListener posListener;

    public void show(FragmentManager manager, String message, DialogInterface.OnClickListener posListener) {
        this.message = message;
        this.posListener = posListener;
        setCancelable(false);
        try {
            Field mDismissed = DialogFragment.class.getDeclaredField("mDismissed");
            mDismissed.setAccessible(true);
            mDismissed.set(this, false);
            Field mShownByMe = DialogFragment.class.getDeclaredField("mShownByMe");
            mShownByMe.setAccessible(true);
            mShownByMe.set(this, true);
            FragmentTransaction ft = manager.beginTransaction();
            ft.add(this, "tipsFragment");
            ft.commitAllowingStateLoss();
        } catch (Exception e) {
            try {
                show(manager, "tipsFragment");
            } catch (Exception e1) {
            }
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog alertDialog = new AlertDialog.Builder(getContext()).setTitle("提示")
                .setMessage(message)
                .setPositiveButton("进入直播", posListener)
                .show();
        alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.center_view_color_blue));
        return alertDialog;
    }
}
