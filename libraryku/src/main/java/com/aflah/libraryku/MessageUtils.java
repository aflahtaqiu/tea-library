package com.aflah.libraryku;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

/**
 * Created by aflah on 30/07/19
 * Email  : aflahtaqiusondha@gmail.com
 * Github : https://github.com/aflahtaqiu
 */


public class MessageUtils {

    private static AlertDialog alertDialog;

    public static void showToast (Context context, CharSequence message, int duration) {
        Toast.makeText(context, message, duration).show();
    }

    public static void showToast (Context context, CharSequence message) {
        showToast(context, message, Toast.LENGTH_LONG);
    }

    public static void showToast (Context context, int resId, int duration) {
        Toast.makeText(context, resId, duration).show();
    }

    public static void showToast (Context context, int resId) {
        showToast(context, resId, Toast.LENGTH_LONG);
    }

    public static void showSnackbar (View view, CharSequence message, int duration, Snackbar.Callback callback) {
        Snackbar.make(view, message, duration).setCallback(callback).show();
    }

    public static void showSnackbar (View view, int resId, int duration, Snackbar.Callback callback) {
        Snackbar.make(view, resId, duration).setCallback(callback).show();
    }

    public static void showSnackbar (View view, CharSequence message, int duration) {
        showSnackbar(view, message, duration, null);
    }

    public static void showSnackbar (View view, int resId, int duration) {
        showSnackbar(view, resId, duration, null);
    }

    public static void showSnackbar (View view, CharSequence message, Snackbar.Callback callback) {
        showSnackbar(view, message, Snackbar.LENGTH_LONG, callback);
    }

    public static void showSnackbar (View view, int resId, Snackbar.Callback callback) {
        showSnackbar(view, resId, Snackbar.LENGTH_LONG, callback);
    }

    public static void showSnackbar (View view, CharSequence message) {
        showSnackbar(view, message, Snackbar.LENGTH_LONG, null);
    }

    public static void showSnackbar (View view, int resId) {
        showSnackbar(view, resId, Snackbar.LENGTH_LONG, null);
    }

    public static void setTextFieldError (TextInputLayout textInputLayout, String errorMessage) {
        textInputLayout.setError(errorMessage);
    }

    public static void showAlertDialog (Context context, String title, String message, String positiveBtnText,
                                        DialogInterface.OnClickListener positiveClickListener,
                                        String negativeBtnText, DialogInterface.OnClickListener negativeCLickListener) {
        alertDialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveBtnText, positiveClickListener)
                .setNegativeButton(negativeBtnText, negativeCLickListener)
                .create();
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.show();
    }

    public static void showAlertDialog (Context context, String title, String message, String positiveBtnText,
                                        DialogInterface.OnClickListener positiveClickListener) {
        showAlertDialog(context, title, message, positiveBtnText, positiveClickListener, "Cancel",
                new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
    }

    public static void showAlertDialog (Context context, String title, String message) {
        showAlertDialog(context, title, message, "Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }, null, null);
    }

    public static void hideAlertDialog () {
        if (alertDialog.isShowing())
            alertDialog.dismiss();
    }
}
