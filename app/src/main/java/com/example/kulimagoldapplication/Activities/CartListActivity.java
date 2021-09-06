package com.example.kulimagoldapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kulimagoldapplication.Adapter.CartListAdapter;
import com.example.kulimagoldapplication.Databases.CartManagement;
import com.example.kulimagoldapplication.Interface.ChangeNumberItemsListener;
import com.example.kulimagoldapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CartListActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private com.example.kulimagoldapplication.Databases.CartManagement CartManagement;
    private TextView totalFeeTxt, taxTxt, deliveryTxt, totalTxt,emptyTxt;
    private double tax;
    private ScrollView scrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);
        CartManagement = new CartManagement(this);

        initView();
        initList();
        calculateCard();
        bottomNavigation();
    }
    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.card_btn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartListActivity.this,
                        CartListActivity.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartListActivity.this,
                        MainActivity.class));
            }
        });
    }
    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter(CartManagement.getListCard(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {

                calculateCard();
            }
        });

        recyclerViewList.setAdapter(adapter);
        if (CartManagement.getListCard().isEmpty()) {
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        } else {
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void calculateCard() {
        double percentTax = 0.02;
        double delivery = 10;

        tax = Math.round((CartManagement.getTotalFee() * percentTax) * 100.0) / 100.0;
        double total = Math.round((CartManagement.getTotalFee() + tax + delivery) * 100.0) / 100.0;
        double itemTotal = Math.round(CartManagement.getTotalFee() * 100.0) / 100.0;

        totalFeeTxt.setText("K" + itemTotal);
        taxTxt.setText("K" + tax);
        deliveryTxt.setText("K" + delivery);
        totalTxt.setText("K" + total);
    }             

    private void initView() {
        recyclerViewList = findViewById(R.id.recyclerview);
        totalFeeTxt = findViewById(R.id.totalFeeTxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        totalTxt = findViewById(R.id.totalTxt);
        emptyTxt = findViewById(R.id.emptyTxt);
        scrollView = findViewById(R.id.scrollView4);
    }
}
