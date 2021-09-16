package com.example.nativecode;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogVerifyDataFragment extends DialogFragment {

    private static final String ARG_NAME = "name";
    private static final String ARG_MOBILE = "mobile";
    private static final String ARG_EMAIL = "email";
    private static final String ARG_COUNTRY = "country";
    private static final String ARG_PRICE = "price";
    private static final String ARG_NOTES = "notes";
    private static final String ARG_PROP_NAME = "propertyName";


    /**
     * Create a new instance of MyDialogFragment, providing "num"
     * as an argument.
     */
    static DialogVerifyDataFragment newInstance(String name, String mobile, String email, String country, String price, String notes, String propName) {
        DialogVerifyDataFragment f = new DialogVerifyDataFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putString(ARG_MOBILE, mobile);
        args.putString(ARG_EMAIL, email);
        args.putString(ARG_COUNTRY, country);
        args.putString(ARG_PRICE, price);
        args.putString(ARG_NOTES, notes);
        args.putString(ARG_PROP_NAME, propName);
        f.setArguments(args);

        return f;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_dialog_check, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //TODO get du lieu tai day
        //TODO: Hien tai anh chi hien thi name len de tu em lam tiep nhe, tuong tu may thang con lai
        updateUI(view);


        //TODO: Sau khi verify xong em thuc hien action button thi lam nhu cac buoc lem da tu lam truoc do
    }

    private void updateUI(View view) {
        assert getArguments() != null;
        setArgName(getArguments(), view);
    }

    private void setArgName(Bundle args, View view) {
        String name = args.getString(ARG_NAME);
        TextView tvName = view.findViewById(R.id.tvName);
        tvName.setText(name);
    }

}
