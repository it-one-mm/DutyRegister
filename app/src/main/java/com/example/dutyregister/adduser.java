package com.example.dutyregister;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class adduser extends BottomSheetDialogFragment
{

    Context context;
    EditText edtName,edtPass;
    Button butSaveAdd;

    public adduser(Context context)
    {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myview = inflater.inflate(R.layout.adduserbottomsheet,container,false);

        edtName = myview.findViewById(R.id.edtName);
        edtPass = myview.findViewById(R.id.edtPass);
        butSaveAdd = myview.findViewById(R.id.butSaveAdd);

        butSaveAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Userdao userdao = new Userdao(getContext());
                userdao.adduser(edtName.getText().toString().trim(),edtPass.getText().toString().trim());
                edtName.setText("");
                edtPass.setText("");
                dismiss();
                Toast.makeText(context,"User Saved \n Please Refresh Page",Toast.LENGTH_LONG).show();
            }
        });

        return myview;
    }

}
