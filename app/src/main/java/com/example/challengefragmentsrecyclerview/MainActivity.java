package com.example.challengefragmentsrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    ImageView ivMake;
    TextView tvModel, tvName, tvPhone;
    Button btnCarInfo, btnOwnerInfo;
    ListFrag listFrag;
    ShowInfoFrag showInfoFrag;
    DetailFrag detailFrag;
    CarInfoFrag carInfoFrag;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivMake = findViewById(R.id.ivMake);
        tvModel = findViewById(R.id.tvModel);
        tvName = findViewById(R.id.tvName);
        tvPhone = findViewById(R.id.tvPhone);
        btnCarInfo = findViewById(R.id.btnCarInfo);
        btnOwnerInfo = findViewById(R.id.btnOwnerInfo);

        fragmentManager = this.getSupportFragmentManager();
        listFrag = (ListFrag) fragmentManager.findFragmentById(R.id.listFrag);
        showInfoFrag = (ShowInfoFrag) fragmentManager.findFragmentById(R.id.showInfoFrag);
        detailFrag = (DetailFrag) fragmentManager.findFragmentById(R.id.detailFrag);
        carInfoFrag = (CarInfoFrag) fragmentManager.findFragmentById(R.id.carInfoFrag);

        carInfoFrag.getView().setVisibility(View.VISIBLE);
        detailFrag.getView().setVisibility(View.GONE);

        // Another way of implementation
        /*
        fragmentManager.beginTransaction()
                .show(listFrag)
                .show(showInfoFrag)
                .show(detailFrag)
                .hide(carInfoFrag)
                .commit();
         */

        btnCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carInfoFrag.getView().setVisibility(View.VISIBLE);
                detailFrag.getView().setVisibility(View.GONE);

                // Another way of implementation
                /*
                fragmentManager.beginTransaction()
                        .hide(detailFrag)
                        .show(carInfoFrag)
                        .commit();
                 */
            }
        });

        btnOwnerInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detailFrag.getView().setVisibility(View.VISIBLE);
                carInfoFrag.getView().setVisibility(View.GONE);

                // Another way of implementation
                /*
                fragmentManager.beginTransaction()
                        .show(detailFrag)
                        .hide(carInfoFrag)
                        .commit();
                 */
            }
        });

        onItemClicked(0);
    }

    @Override
    public void onItemClicked(int index) {

        String make = ApplicationClass.people.get(index).getCar().getMake();

        if (make.equals("mercedes")) {
            ivMake.setImageResource(R.drawable.mercedes);
        } else if (make.equals("volkswagen")) {
            ivMake.setImageResource(R.drawable.volkswagen);
        } else if (make.equals("nissan")) {
            ivMake.setImageResource(R.drawable.nissan);
        }

        tvModel.setText(ApplicationClass.people.get(index).getCar().getModel());

        tvName.setText(ApplicationClass.people.get(index).getFirstName() + " " + ApplicationClass.people.get(index).getLastName());
        tvPhone.setText(ApplicationClass.people.get(index).getPhoneNumber());
    }
}