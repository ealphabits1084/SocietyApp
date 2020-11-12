package com.example.societyapp

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.societyapp.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    val TAG: String = LoginActivity::class.java.getSimpleName()

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)


        setSupportActionBar(binding.toolbar);
        getSupportActionBar()!!.setTitle("Login");

        uiListeners()
    }

    /*****************************************************************
     * Method Name : uiListeners
     * Description : This method is used for handling click UI
     * listeners
     *****************************************************************/
    private fun uiListeners() {
        binding.btnGetOtp.setOnClickListener(callGetOtpAPI);
        textWatcherInputFields()
//        textInputFocusListener()
    }

    private fun textInputFocusListener() {
        binding.etMobileNumber.setOnFocusChangeListener { v, hasFocus ->
            when {

            }
        }
    }

    /*****************************************************************
     * Method Name : textWatcherInputFields
     * Description : This method is used for handling text changes
     *****************************************************************/
    private fun textWatcherInputFields() {

        binding.etMobileNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                when {
                    TextUtils.isEmpty(s.toString().trim()) -> Log.e(
                        "TAG", getString(R.string.phone_number_cnt_blank)
                    )

                    s.toString().trim().length < 10 ||
                            s.toString().trim().length > 15 ->
                        Log.e(
                            "TAG", getString(R.string.phone_number_length)
                        )

                    !Validation.isPhoneNoValid(
                        s.toString().trim()
                    ) ->
                        Log.e(
                            "TAG", getString(R.string.enter_a_valid_phone_no)
                        )

                    else ->
                        Log.e(
                            "TAG", "No Error"
                        )
                }
            }

            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //nothing to do
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //nothing to do
            }
        })
    }


    /*****************************************************************
     * Method Name : handleGetOtpButtonClick
     * Description : This method is used for handling validations.
     *****************************************************************/
    private fun handleGetOtpButtonClick() {
        val phoneNumber = binding.etMobileNumber.text.toString().trim()

        if (TextUtils.isEmpty(phoneNumber)) {
            Log.e(TAG, R.string.phone_number_cnt_blank.toString())
            binding.etMobileNumber.setError(getString(R.string.phone_number_cnt_blank))
        } else if (phoneNumber.length < 10 ||
            phoneNumber.length > 15
        ) {
            binding.etMobileNumber.setError(getString(R.string.phone_number_length))
            Log.e(TAG, getString(R.string.phone_number_length))


        } else if (!Validation.isPhoneNoValid(phoneNumber)) {
            binding.etMobileNumber.setError(getString(R.string.enter_a_valid_phone_no))
            Log.e(TAG, getString(R.string.enter_a_valid_phone_no))


        } else {
            //TODO
            Log.e(
                TAG, "No Error"
            )
        }
    }

    /*****************************************************************
     * Method Name : callGetOtpAPI
     * Description : This method is used for calling get OTP API.
     *****************************************************************/
    val callGetOtpAPI =
        View.OnClickListener({
            Log.e(TAG, "Click")
            handleGetOtpButtonClick()
        })
}

