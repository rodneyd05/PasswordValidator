package com.thisisit.passwordvalidator

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.thisisit.passwordvalidator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainBinding.passwordEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                val inputPassword = mainBinding.passwordEditText.text.toString()

                passwordLength(inputPassword,mainBinding, resources)
                lowercaseUppercase(inputPassword,mainBinding, resources)
                containsNumber(inputPassword,mainBinding, resources)
                containsSpecialCharacter(inputPassword,mainBinding, resources)

            }

            override fun afterTextChanged(s: Editable?) {

            }

        })


    }
}

private fun passwordLength(password: String, mainBinding: ActivityMainBinding, resources: Resources) {
    if (Checker.passwordLengthChecker(password)) {
        mainBinding.criteriaLength.setTextColor(resources.getColor(R.color.green,null))
    } else {
        mainBinding.criteriaLength.setTextColor(resources.getColor(R.color.red,null))
    }
}

private fun lowercaseUppercase(password: String, mainBinding: ActivityMainBinding, resources: Resources) {
    if (Checker.containsLowercaseLetterChecker(password) && Checker.containsUppercaseLetterChecker(password)) {
        mainBinding.criteriaLowerUppercase.setTextColor(resources.getColor(R.color.green,null))
    } else {
        mainBinding.criteriaLowerUppercase.setTextColor(resources.getColor(R.color.red,null))
    }
}

private fun containsNumber(password: String, mainBinding: ActivityMainBinding, resources: Resources) {
    if (Checker.containsNumberChecker(password)) {
        mainBinding.criteriaNumbers.setTextColor(resources.getColor(R.color.green,null))
    } else {
        mainBinding.criteriaNumbers.setTextColor(resources.getColor(R.color.red,null))
    }
}

private fun containsSpecialCharacter(password: String, mainBinding: ActivityMainBinding, resources: Resources) {
    if (Checker.containsSpecialCharacterChecker(password)) {
        mainBinding.criteriaSpecialCharacters.setTextColor(resources.getColor(R.color.green,null))
    } else {
        mainBinding.criteriaSpecialCharacters.setTextColor(resources.getColor(R.color.red,null))
    }
}