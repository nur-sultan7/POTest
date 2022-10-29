package com.example.potest.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.potest.R
import com.example.potest.databinding.FragmentProfileBinding
import com.squareup.picasso.Picasso

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding: FragmentProfileBinding
        get() = _binding ?: throw RuntimeException("FragmentProfileBinding is null")
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
        )[MainViewModel::class.java]
    }
    private lateinit var id: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        viewModel.getProfile(id)
    }

    private fun setObservers() {
        viewModel.profile.observe(viewLifecycleOwner) {
            with(binding) {
                setImg(it.avatar)
                tvName.text = checkIsEmpty(it.name)
                tvEmail.text = checkIsEmpty(it.email)
                tvCompanyName.text = checkIsEmpty(it.companyName)
                tvPhone.text = checkIsEmpty(it.phone)
                tvSections.text = checkIsEmpty(it.sections)
            }
        }
    }

    private fun checkIsEmpty(value: String): String {
        return value.ifEmpty { EMPTY_VALUE }
    }

    private fun setImg(img: String) {
        if (img.isEmpty())
            binding.ivProfile.setImageResource(R.drawable.penguin)
        else
            Picasso.get()
                .load(img)
                .placeholder(R.drawable.penguin)
                .into(binding.ivProfile)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    private fun parseArgs() {
        id = arguments?.getString(ID_KEY) ?: throw RuntimeException("Profile id is null")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(id: String): ProfileFragment {
            return ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ID_KEY, id)
                }
            }
        }

        private const val EMPTY_VALUE = "Unknown"
        private const val ID_KEY = "id"
    }
}