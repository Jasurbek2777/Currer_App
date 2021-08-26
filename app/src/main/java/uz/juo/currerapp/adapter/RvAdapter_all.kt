package uz.juo.currerapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.juo.currerapp.databinding.RvItemBinding
import uz.juo.currerapp.models.Order
import com.chauthai.swipereveallayout.ViewBinderHelper
import android.os.Bundle

class RvAdapter_all(var list: ArrayList<Order>) : RecyclerView.Adapter<RvAdapter_all.Vh>() {
    var viewBinderHelper = ViewBinderHelper()

    inner class Vh(var item: RvItemBinding) : RecyclerView.ViewHolder(item.root) {


        fun onBind(order: Order, position: Int) {
//            item.name.setText("${position + 1}. ${order.firstName} ${order.secondName}")
//            item.seria.setText("${order.seria}")
//            item.root.setOnClickListener {
//                itemClick.itemClick(order, position)
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh = Vh(
        RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)

    }


    override fun getItemCount(): Int = list.size

    interface itemOnCLick {
        fun itemClick(order: Order, position: Int)
    }
}