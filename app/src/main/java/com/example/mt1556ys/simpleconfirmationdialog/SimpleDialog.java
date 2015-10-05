package com.example.mt1556ys.simpleconfirmationdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by mt1556ys on 10/5/15.
 */
public class SimpleDialog extends DialogFragment {

    interface SimpleDialogListener {
        void userClickedOK();
        void userClickedCancel();
    }

    SimpleDialogListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mListener = (SimpleDialogListener) activity;
        } catch (ClassCastException cce) {
            throw new ClassCastException("Dialog host must implement SimpleDialogListener");
        }
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        String dialogMessage;
        String defaultMessage = "OK - Cancel Dialog";
        Bundle args = getArguments();

        if (args != null) {
            dialogMessage = args.getString("Message", defaultMessage);
        } else {
            dialogMessage = defaultMessage;
        }

        //Dialog builder
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        AlertDialog dialog = builder.setTitle("OK-Cancel Dialog")
                .setMessage(dialogMessage)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.userClickedOK();
                    }
                })

                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.userClickedCancel();
                    }
                })
                .create();

        return dialog;
    }
}
