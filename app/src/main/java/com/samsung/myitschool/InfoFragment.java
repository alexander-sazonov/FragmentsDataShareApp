package com.samsung.myitschool;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.samsung.myitschool.databinding.FragmentInfoBinding;

import org.w3c.dom.Text;

public class InfoFragment extends Fragment {

    public InfoFragment() {
        super(R.layout.fragment_info);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView nameTv = view.findViewById(R.id.name_tv);
        TextView surnameTv = view.findViewById(R.id.surname_tv);
        TextView ageTv = view.findViewById(R.id.age_tv);
        getParentFragmentManager().setFragmentResultListener(
                "requestKey",
                this,
                new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        String name = result.getString("name_key");
                        String surname = result.getString("surname_key");
                        int age = result.getInt("age_key");
                        nameTv.setText(name);
                        surnameTv.setText(surname);
                        ageTv.setText(String.valueOf(age));
                    }
                }
        );
        view.findViewById(R.id.edit_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container,EditFragment.class,null)
                        .commit();
            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
