package com.example.shoppingcart

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ShoppingCartViewHolder(view:View):ViewHolder(view) {


    val cbSelectItem: CheckBox = view.findViewById(R.id.cbSelectItem)
    val dltItem:ImageView = view.findViewById(R.id.detItem)
}