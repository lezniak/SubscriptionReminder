package com.example.subscriptionreminder.ui.login

import android.R.attr
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.subscriptionreminder.databinding.LoginFragmentBinding

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import dagger.hilt.android.AndroidEntryPoint
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import androidx.annotation.NonNull

import android.R.attr.password
import androidx.navigation.fragment.findNavController
import com.example.subscriptionreminder.R
import com.example.subscriptionreminder.infrastructure.common.Validation
import com.google.android.material.snackbar.Snackbar


const val TAG = "LoginFragment"
class LoginFragment: Fragment() {
    private val viewModel by viewModels<LoginViewModel>()
    lateinit var binding : LoginFragmentBinding
    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val validation = Validation()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(layoutInflater)
        bindAction()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.msg.observe(viewLifecycleOwner) {
            Snackbar.make(view, it, Snackbar.LENGTH_SHORT)
                .show()
        }
    }

    fun createNewUser(email: String, password : String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity(),
                OnCompleteListener<AuthResult?> { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        val user = mAuth.currentUser
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            requireContext(), "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
    }

    fun logInUser(email: String,password: String){
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity(),
                OnCompleteListener<AuthResult?> { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        viewModel.setMessage("Logowanie pomyślnie")
                        val user = mAuth.currentUser
                        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure")

                        viewModel.setMessage("Logowanie niepomyślne")

                    }
                })
    }

    fun bindAction(){
        binding.register.setOnClickListener {
            binding.loginSection.visibility = View.GONE
            binding.registerSection.visibility = View.VISIBLE
        }

        binding.cancel.setOnClickListener {
            binding.loginSection.visibility = View.VISIBLE
            binding.registerSection.visibility = View.GONE
        }

        binding.login.setOnClickListener {
            val email = binding.emailLogin.text
            val password = binding.passwordLogin.text
            val validationResult = validation.validateEmail(email.toString())


            if(validationResult.getStatus() != 1){
                viewModel.setMessage(validationResult.getErrorMessage())
            }else{
                logInUser(email.toString(),password.toString())
            }
        }

        binding.signIn.setOnClickListener {
            val email = binding.emailRegister.text.toString()
            val password1 = binding.passwordRegister.text.toString()
            val password2 = binding.passwordRepeat.text.toString()
            val validationResult = validation.registerValid(email,password1,password2)

            if(validationResult.getStatus() != 1){
                viewModel.setMessage(validationResult.getErrorMessage())
            }else{
                createNewUser(email,password1)
            }
        }
    }
}