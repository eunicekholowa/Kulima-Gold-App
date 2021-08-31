package com.example.kulimagoldapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kulimagoldapplication.Adapter.CategoryAdapter;
import com.example.kulimagoldapplication.Adapter.AvailableStockSAdapter;
import com.example.kulimagoldapplication.Domain.CategoryDomain;
import com.example.kulimagoldapplication.Domain.ProductDomain;
import com.example.kulimagoldapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList,recyclerViewAvailableStockList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewAvailableStockList();
        bottomNavigation();
    }

    public void bottomNavigation(){
        FloatingActionButton floatingActionButton = findViewById(R.id.card_btn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
    }

    private void recyclerViewAvailableStockList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewAvailableStockList = findViewById(R.id.recyclerView2);
        recyclerViewAvailableStockList.setLayoutManager((linearLayoutManager));

        ArrayList<ProductDomain> productList=new ArrayList<>();
        productList.add(new ProductDomain( "Cooking Oil",  "kazinga",  " Tasty foods,good health. ",  2900.00));
        productList.add(new ProductDomain( "Soya beans",  "soyya",  "Early maturing with bumper harvest.", 600.00));
        productList.add(new ProductDomain( "Weevil Kill",  "pestea",  "treat weevils let your harvest be safe.", 20000.00));
        productList.add(new ProductDomain( "Sprayer",  "spulea",  "control weeds easily with our sprayers,1 year guarantee.",   15000.00));
        productList.add(new ProductDomain( "Iron sheets",  "ironsheets",  "10 inch plain color.",   5000.00));
        productList.add(new ProductDomain( "Cement",  "cement",  "build strong structures without regrets.",   7500.00));
        productList.add(new ProductDomain( "Polythene Plastics",  "blackroll",  "black rolls available.",   4500.00));
        adapter2 = new AvailableStockSAdapter(productList);
        recyclerViewAvailableStockList.setAdapter(adapter2);

    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList <CategoryDomain> categoryList=new ArrayList<>();
        categoryList.add(new CategoryDomain("FOOD ITEMS", "soyapiecess"));
        categoryList.add(new CategoryDomain("SEEDS", "sids"));
        categoryList.add(new CategoryDomain("PESTICIDES ", "pestea"));
        categoryList.add(new CategoryDomain("IMPLEMENTS", "sprayer"));
        categoryList.add(new CategoryDomain("IRONSHEETS ", "ironsheets"));
        categoryList.add(new CategoryDomain("CEMENT ", "cement"));
        categoryList.add(new CategoryDomain("PLASTICS ", "poly"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);




    }
}
