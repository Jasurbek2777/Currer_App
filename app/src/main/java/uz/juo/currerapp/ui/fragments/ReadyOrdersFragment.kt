package uz.juo.currerapp.ui.fragments

import android.location.Location
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.juo.currerapp.R
import uz.juo.currerapp.adapter.RvAdapter
import uz.juo.currerapp.adapter.RvAdapter_ready
import uz.juo.currerapp.databinding.FragmentReadyOrdersBinding
import uz.juo.currerapp.models.Curier
import uz.juo.currerapp.models.Order

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ReadyOrdersFragment : Fragment() {
    lateinit var binding: FragmentReadyOrdersBinding
    lateinit var adapter: RvAdapter_ready
    lateinit var list: ArrayList<Order>
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReadyOrdersBinding.inflate(inflater, container, false)
        list = ArrayList()
        for (i in 1 until 100) {
            list.add(
                Order(
                    i,
                    "Max Way Xadra",
                    "PDP IT Academy",
                    Curier(i, "Jasurbel", "+998973142777"),
                    "$i 8,500",
                    "${i + i},300",
                    Location("PDP"),
                    false
                )
            )
        }
        adapter = RvAdapter_ready(list)
        binding.rv.adapter = adapter

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ReadyOrdersFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}