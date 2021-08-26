package uz.juo.currerapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.juo.currerapp.models.Order
import com.chauthai.swipereveallayout.ViewBinderHelper
import uz.juo.currerapp.databinding.SwiperLayout2Binding

class RvAdapter_ready(var list: ArrayList<Order>) : RecyclerView.Adapter<RvAdapter_ready.Vh>() {
    var viewBinderHelper = ViewBinderHelper()

    inner class Vh(var item: SwiperLayout2Binding) : RecyclerView.ViewHolder(item.root) {
        init {
            viewBinderHelper.setOpenOnlyOne(true)
        }

        fun onBind(order: Order, position: Int) {
            viewBinderHelper.bind(item.swiperLayout, position.toString())
//            item.name.setText("${position + 1}. ${order.firstName} ${order.secondName}")
//            item.seria.setText("${order.seria}")
//            item.root.setOnClickListener {
//                itemClick.itemClick(order, position)
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh = Vh(
        SwiperLayout2Binding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)

    }


    override fun getItemCount(): Int = list.size

    interface itemOnCLick {
        fun itemClick(order: Order, position: Int)
    }
}