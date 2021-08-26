package uz.juo.currerapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.juo.currerapp.databinding.RvItemBinding
import uz.juo.currerapp.models.Order
import com.chauthai.swipereveallayout.ViewBinderHelper
import android.os.Bundle
import android.view.AbsSavedState
import uz.juo.currerapp.databinding.SwiperLayoutBinding

class RvAdapter(var list: ArrayList<Order>, var itemClick: itemOnCLick) :
    RecyclerView.Adapter<RvAdapter.Vh>() {
    var viewBinderHelper = ViewBinderHelper()

    inner class Vh(var item: SwiperLayoutBinding) : RecyclerView.ViewHolder(item.root) {
        init {
            viewBinderHelper.setOpenOnlyOne(true)
        }

        fun onBind(order: Order, position: Int) {
            viewBinderHelper.bind(item.swiperLayout, position.toString())
//            item.name.setText("${position + 1}. ${order.firstName} ${order.secondName}")
//            item.seria.setText("${order.seria}")
            item.root.setOnClickListener {
                itemClick.itemClick(order, position)
            }
            item.loacationCard.setOnClickListener {
                itemClick.locationClick(order, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh = Vh(
        SwiperLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)

    }


    override fun getItemCount(): Int = list.size

    interface itemOnCLick {
        fun itemClick(order: Order, position: Int)
        fun locationClick(order: Order, position: Int)
    }
}