package uz.juo.currerapp.utils


interface ItemTouchHalperAdapter {
    fun onItemMove(fromPosition:Int,toPosition:Int)
    fun onItemDismiss(position:Int)
}