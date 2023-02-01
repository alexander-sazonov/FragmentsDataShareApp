package com.samsung.myitschool;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.samsung.myitschool.databinding.FragmentInfoBinding;

public class EditFragment extends Fragment {


    public EditFragment() {
        super(R.layout.fragment_edit);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText nameEt = view.findViewById(R.id.name_et);
        EditText surnameEt = view.findViewById(R.id.surname_et);
        EditText ageEt = view.findViewById(R.id.age_et);
        Button saveBtn = view.findViewById(R.id.save_btn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEt.getText().toString();
                String surname = surnameEt.getText().toString();
                int age = Integer.parseInt(ageEt.getText().toString());
                Bundle result = new Bundle();
                result.putString("name_key", name);
                result.putString("surname_key", surname);
                result.putInt("age_key", age);
                getParentFragmentManager().setFragmentResult("requestKey", result);
                getParentFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.container, InfoFragment.class,null)
                        .commit();
            }
        });

    }
}
