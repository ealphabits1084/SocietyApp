package com.example.societyapp

import java.util.regex.Pattern

/****************************************************************
 * Class Name - Validation
 * Description - For input validations.
 *********************************************************************/
object Validation {

    /*Phone number validation regex*/
    private val PHONE_NUMBER_PATTERN =
//        Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
        Pattern.compile("^[0-9]+\$")

    /* Method Name : isPhoneNoValid
    * Description : This method is used for validating phone number
    * @param phoneNumber
   */
    fun isPhoneNoValid(phoneNumber: String): Boolean {
        return PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches()
    }

}