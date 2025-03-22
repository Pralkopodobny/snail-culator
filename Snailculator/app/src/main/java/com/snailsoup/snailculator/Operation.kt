package com.snailsoup.snailculator

import com.snailsoup.snailculator.DigitPart.Dot
import com.snailsoup.snailculator.DigitPart.Eight
import com.snailsoup.snailculator.DigitPart.Five
import com.snailsoup.snailculator.DigitPart.Four
import com.snailsoup.snailculator.DigitPart.Nine
import com.snailsoup.snailculator.DigitPart.One
import com.snailsoup.snailculator.DigitPart.Seven
import com.snailsoup.snailculator.DigitPart.Six
import com.snailsoup.snailculator.DigitPart.Three
import com.snailsoup.snailculator.DigitPart.Two
import com.snailsoup.snailculator.DigitPart.Zero

enum class FlowOperator {
    Clear,
    AllClear,
    Next,
    Calculate
}

enum class NumericOperator {
    Addition,
    Subtraction,
    Division,
    Multiplication
}

enum class DigitPart {
    Zero,
    One,
    Two,
    Three,
    Four,
    Five,
    Six,
    Seven,
    Eight,
    Nine,
    Dot
}

sealed class Operation {
    data class NumericOperation(val operator: NumericOperator) : Operation()
    data class Operand(val parts: List<DigitPart>, val isNegative: Boolean) : Operation() {
        fun tryAdd(part: DigitPart): Operand {
            return when (part) {
                Dot -> if (parts.contains(Dot)) this else Operand(parts + part, isNegative)
                Zero -> if (parts.size == 1 && parts[0] == Dot) this else Operand(
                    parts + part,
                    isNegative
                )

                One, Two, Three, Four, Five, Six, Seven, Eight, Nine -> Operand(
                    parts + part,
                    isNegative
                )
            }
        }

        fun negate(): Operand {
            return Operand(parts, !isNegative)
        }

        fun isValid(): Boolean {
            return parts.last() != Dot
        }

        override fun toString(): String {
            val builder = parts.fold(StringBuilder(parts.size + 1)) { acc, digitPart ->
                when (digitPart) {
                    Zero -> acc.append('0')
                    One -> acc.append('1')
                    Two -> acc.append('2')
                    Three -> acc.append('3')
                    Four -> acc.append('4')
                    Five -> acc.append('5')
                    Six -> acc.append('6')
                    Seven -> acc.append('7')
                    Eight -> acc.append('8')
                    Nine -> acc.append('9')
                    Dot -> acc.append('.')
                }
            }

            return if (isNegative) builder.insert(0, '-').toString() else builder.toString()
        }
    }

    data object None : Operation()
}