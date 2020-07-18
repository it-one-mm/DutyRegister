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

public class UserLogin extends BottomSheetDialogFragment {

    Context context;

    public UserLogin(Context context) {
        this.context = context;
    }

    Button butLogInU;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myview = inflater.inflate(R.layout.userlogin,container,false);

        butLogInU = myview.findViewById(R.id.butLoginU);

        butLogInU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myint = new Intent(context,UserMainPanel.class);
                startActivity(myint);
                dismiss();
            }
        });

        return myview;
    }
}
