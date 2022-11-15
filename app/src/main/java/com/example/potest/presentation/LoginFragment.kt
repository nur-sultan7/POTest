package com.example.potest.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.potest.POTestApp
import com.example.potest.R
import com.example.potest.databinding.FragmentLoginBinding
import javax.inject.Inject

class LoginFragment : Fragment() {

    private val component by lazy {
        (requireActivity().application as POTestApp).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding
        get() = _binding ?: throw RuntimeException("FragmentLoginBinding is null")
    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(
            this,
            viewModelFactory
        )[LoginViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnclickListeners()
        setObservers()

    }

    private fun setObservers() {
        viewModel.isAuthorized.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG)
                    .show()
                binding.btnLogin.isEnabled = true
            } else {
                viewModel.loadProfile()
            }
        }
        viewModel.isProfileLoaded.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG)
                    .show()
            } else {
                launchProfileFragment()
            }
            binding.btnLogin.isEnabled = true
        }
    }

    private fun launchProfileFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, ProfileFragment.newInstance())
            .commit()
    }

    private fun setOnclickListeners() {
        binding.btnLogin.setOnClickListener {
            it.isEnabled = false
            val email = binding.edEmailAddress.text.toString()
            val password = binding.edPassword.text.toString()
            viewModel.authUser(email, password)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }
}