package com.example.kulimagoldapplication.Databases;

import android.content.Context;
import android.widget.Toast;

import com.example.kulimagoldapplication.Domain.ProductDomain;
import com.example.kulimagoldapplication.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class CartManagement  {
    private Context context;
    private ItemDB itemDB;
    public CartManagement (Context context) {
        this.context = context;
        this.itemDB = new ItemDB(context);
    }

    public void insertProduct(ProductDomain item) {
        ArrayList<ProductDomain> listProduct = getListCard();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getTitle().equals(item.getTitle())) {
                existAlready = true;
                n = i;
                break;
            }
        }

        if (existAlready) {
            listProduct.get(n).setNumberIncard(item.getNumberIncard());
        } else {
            listProduct.add(item);
        }
        ItemDB.putListObject("CardList", listProduct);
        Toast.makeText(context, "Added To Your Card", Toast.LENGTH_SHORT).show();

    }

    public ArrayList<ProductDomain> getListCard() {

        return itemDB.getListObject("CardList");
    }

    public void plusNumberProduct(ArrayList<ProductDomain> listproduct, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listproduct.get(position).setNumberIncard(listproduct.get(position).getNumberIncard() + 1);
        ItemDB.putListObject("CardList", listproduct);
        changeNumberItemsListener.changed();
    }

    public void MinusNumerProduct(ArrayList<ProductDomain> listproduct, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        if (listproduct.get(position).getNumberIncard() == 1) {
            listproduct.remove(position);
        } else {
            listproduct.get(position).setNumberIncard(listproduct.get(position).getNumberIncard() - 1);
        }
        ItemDB.putListObject("CardList", listproduct);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee() {
        ArrayList<ProductDomain> listProduct2 = getListCard();
        double fee = 0;
        for (int i = 0; i < listProduct2.size(); i++) {
            fee = fee + (listProduct2.get(i).getFee() * listProduct2.get(i).getNumberIncard());
        }
        return fee;
    }

}
