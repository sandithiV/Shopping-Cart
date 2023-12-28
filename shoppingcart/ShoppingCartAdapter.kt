package com.example.shoppingcart

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingcart.database.ItemList
import com.example.shoppingcart.database.ItemListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ShoppingCartAdapter(items:List<ItemList>, repository:ItemListRepository
,viewModel: MainActivityData):Adapter<ShoppingCartViewHolder>() {

    lateinit var context: Context
    val items = items
    val repository = repository
    val viewModel =viewModel

  fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCartViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item,parent,:false)
      context = parent.context
      return ShoppingCartViewHolder(view)

      return ShoppingCartViewHolder(view)
  }


    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: ShoppingCartViewHolder, position: Int) {

        holder.cbSelectItem.text = items.get(position).item
        holder.dltItem.setOnClickListner {
          val isChecked = holder.cbSelectItem.isChecked

            if(isChecked){
                CoroutineScope(Dispatchers.IO).launch {
                    repository.delete(items.get(position))
                    val data = repository.getAllItemListItems()
                    withContext(Dispatchers.Main){
                        viewModel.setData(items)
                    }
                }

            }else{
                Toast.makeText(context,"Hello from Button $position",Toast.LENGTH_LONG).show()
            }

        }
    }

}