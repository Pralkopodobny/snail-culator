package com.snailsoup.snailculator

import org.junit.Test

import org.junit.Assert.*
import java.util.Stack

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun infixToRPN_isCorrect() {
        assertEquals("1 3 3 / + 2 -", infixToRPN("1+3/3-2"))
        assertEquals("1 3 3 2 - / +", infixToRPN("1+3/(3-2)"))
        assertEquals("1 3 3 2 - / + 1 +", infixToRPN("1+3/(3-2) + 1"))
        assertEquals("1 3 3 ^ 3 2 - / + 1 +", infixToRPN("1+3^3/(3-2) + 1"))
        assertEquals("12 14 + 3 -", infixToRPN("12+14-3"))
        assertEquals("12 14 + 3 -", infixToRPN("1 2+ 1 4-3"))
    }

    fun precedence(op: Char): Int {
        return when (op) {
            '+', '-' -> 1
            '*', '/' -> 2
            '^' -> 3
            else -> -1
        }
    }

    fun infixToRPN(expression: String): String {
        val output = StringBuilder()
        val operators = Stack<Char>()

        for (token in expression.replace(" ", "")) {
            when {
                token.isDigit() -> output.append(token)
                token == '(' -> operators.push(token)
                token == ')' -> {
                    while (operators.isNotEmpty() && operators.peek() != '(') {
                        output.append(' ').append(operators.pop())
                    }
                    operators.pop()
                }
                token in "+-*/^" -> {
                    output.append(' ')
                    while (operators.isNotEmpty() && precedence(operators.peek()) >= precedence(token)) {
                        output.append(operators.pop()).append(' ')
                    }
                    operators.push(token)
                }
            }
        }

        while (operators.isNotEmpty()) {
            output.append(' ').append(operators.pop())
        }

        return output.toString()
    }
}