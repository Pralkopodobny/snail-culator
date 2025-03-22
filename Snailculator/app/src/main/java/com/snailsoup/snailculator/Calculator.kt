package com.snailsoup.snailculator

import com.snailsoup.snailculator.DigitPart.*

class Calculator {
    private val statement: List<Operation> = emptyList()
    private var actOperation : Operation = Operation.None

    fun onOperand(part : DigitPart){
        when(actOperation){
            Operation.None -> TODO()
            is Operation.NumericOperation -> TODO()
            is Operation.Operand -> TODO()
        }
    }

    fun addPart(operand: Operation.Operand, part: DigitPart){

    }
}

