package com.thisisit.passwordvalidator

class Checker {

    companion object {

        fun passwordLengthChecker(password: String): Boolean {
            var decision = false
            if (password.length >= 8) {
                decision = true
            }
            return decision
        }

        fun containsUppercaseLetterChecker(password: String): Boolean {
            val char = password.toCharArray()
            var decision = false
            for (i in char) {
                if (i.isUpperCase()) {
                    decision = true
                    break
                }
            }
            return decision
        }

        fun containsLowercaseLetterChecker(password: String): Boolean {
            val char = password.toCharArray()
            var decision = false
            for (i in char) {
                if (i.isLowerCase()) {
                    decision = true
                    break
                }
            }
            return decision
        }

        fun containsNumberChecker(password: String): Boolean {
            val char = password.toCharArray()
            var decision = false
            for (i in char) {
                if (i.isDigit()) {
                    decision = true
                    break
                }
            }
            return decision
        }

        fun containsSpecialCharacterChecker(password: String): Boolean {
            val char = password.toCharArray()
            var decision = false
            for (i in char) {
                if (i !in 'A'..'Z' && i !in 'a'..'z' && !i.isDigit()) {
                    decision = true
                    break
                }
            }
            return decision
        }
    }
}