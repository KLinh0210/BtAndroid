package com.example.bai_1;

import android.app.Dialog;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;

import com.example.bai_1.R;


public class MoreInformationDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_text).setPositiveButton(R.string.dialog_visit,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int id) {
                                Intent visit = new Intent(Intent.ACTION_VIEW,
                                        Uri.parse("https://www.facebook.com/profile.php?id=100008676049414&mibextid=ZbWKwl"));
                                Intent chooser = Intent.createChooser(visit,
                                        getResources().getString(R.string.open_with));
                                startActivity(chooser);
                            }
                        }).setNegativeButton(R.string.dialog_exit, null);

        return builder.create();
    }

}
