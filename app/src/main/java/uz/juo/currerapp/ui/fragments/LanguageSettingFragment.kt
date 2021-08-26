package uz.juo.currerapp.ui.fragments

import android.os.Bundle
import android.provider.DocumentsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import uz.juo.currerapp.R
import uz.juo.currerapp.databinding.FragmentLanguageSettingBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LanguageSettingFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentLanguageSettingBinding
    lateinit var root: ConstraintLayout
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
        binding = FragmentLanguageSettingBinding.inflate(inflater, container, false)
        root = binding.root
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        binding.checkUz.setOnCheckedChangeListener { buttonView, isChecked ->
            binding.checkRu.isChecked = false
        }
        binding.checkRu.setOnCheckedChangeListener { buttonView, isChecked ->
            binding.checkUz.isChecked = false
        }
        binding.save.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.image.setOnClickListener {
            findNavController().popBackStack(R.id.nav_home,true)
        }
        return root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LanguageSettingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
//        findNavController().popBackStack(R.id.nav_home,true)
    }
}