package com.example.dutyregister;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class AdminLogin extends BottomSheetDialogFragment {

    Context context;

    public AdminLogin(Context context) {
        this.context = context;
    }

    Button butLogInA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myview = inflater.inflate(R.layout.adminlogin,container,false);

        butLogInA = myview.findViewById(R.id.butLoginA);

        butLogInA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myint = new Intent(context,AdminMainPanel.class);
                startActivity(myint);
                dismiss();
            }
        });

        return myview;
    }
}
