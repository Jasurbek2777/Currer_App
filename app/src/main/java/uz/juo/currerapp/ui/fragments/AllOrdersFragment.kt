package uz.juo.currerapp.ui.fragments

import android.location.Location
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.juo.currerapp.adapter.RvAdapter_all
import uz.juo.currerapp.databinding.FragmentInnerBinding
import uz.juo.currerapp.models.Curier
import uz.juo.currerapp.models.Order

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AllOrderFragment : Fragment() {
    private var param1: String? = null
    lateinit var list: ArrayList<Order>
    lateinit var adapter: RvAdapter_all
    private var param2: String? = null
    lateinit var binding: FragmentInnerBinding
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
        binding = FragmentInnerBinding.inflate(inflater, container, false)
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
        adapter = RvAdapter_all(list)
        binding.rv.adapter = adapter
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AllOrderFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}