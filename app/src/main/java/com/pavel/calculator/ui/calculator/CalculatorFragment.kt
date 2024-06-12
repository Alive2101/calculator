package com.pavel.calculator.ui.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pavel.calculator.databinding.FragmentCalculatorBinding


class CalculatorFragment : Fragment() {

    private var binding: FragmentCalculatorBinding? = null

    private val viewModel: CalculatorViewModel by viewModels()

    private var isNew: Boolean = false

    private var operation: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculatorBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.run {
            oneButton.setOnClickListener {
                writeSymbol(oneButton.text.toString())
                answerTextView.text = ""
            }
            twoButton.setOnClickListener {
                writeSymbol(twoButton.text.toString())
                answerTextView.text = ""
            }
            threeButton.setOnClickListener {
                writeSymbol(threeButton.text.toString())
                answerTextView.text = ""
            }
            fourButton.setOnClickListener {
                writeSymbol(fourButton.text.toString())
                answerTextView.text = ""
            }
            fiveButton.setOnClickListener {
                writeSymbol(fiveButton.text.toString())
                answerTextView.text = ""
            }
            sixButton.setOnClickListener {
                writeSymbol(sixButton.text.toString())
                answerTextView.text = ""
            }
            sevenButton.setOnClickListener {
                writeSymbol(sevenButton.text.toString())
                answerTextView.text = ""
            }
            eightButton.setOnClickListener {
                writeSymbol(eightButton.text.toString())
                answerTextView.text = ""
            }
            nineButton.setOnClickListener {
                writeSymbol(nineButton.text.toString())
                answerTextView.text = ""
            }
            zeroButton.setOnClickListener {
                writeSymbol(zeroButton.text.toString())
                answerTextView.text = ""
            }
            plusAndMinusButton.setOnClickListener {
                viewModel.sign()
                writeTextView.text = viewModel.expression
            }
            pointButton.setOnClickListener {
                writeSymbol(pointButton.text.toString())
            }

            percentButton.setOnClickListener {
                viewModel.oldNumber = writeTextView.text.toString()
                writeSymbol(percentButton.text.toString())
                if (operation.isEmpty()) {
                    operation = percentButton.text.toString()
                }
                isNew = true
            }
            divideButton.setOnClickListener {
                viewModel.oldNumber = viewModel.expression
                writeSymbol(divideButton.text.toString())
                if (operation.isEmpty()) {
                    operation = divideButton.text.toString()
                }
                isNew = true
            }
            multiplyButton.setOnClickListener {
                viewModel.oldNumber = viewModel.expression
                writeSymbol(multiplyButton.text.toString())
                if (operation.isEmpty()) {
                    operation = multiplyButton.text.toString()
                }
                isNew = true
            }
            minusButton.setOnClickListener {
                viewModel.oldNumber = viewModel.expression
                writeSymbol(minusButton.text.toString())
                if (operation.isEmpty()) {
                    operation = minusButton.text.toString()
                }
                isNew = true
            }
            plusButton.setOnClickListener {
                viewModel.oldNumber = viewModel.expression
                writeSymbol(plusButton.text.toString())
                if (operation.isEmpty()) {
                    operation = plusButton.text.toString()
                }
                isNew = true
            }
            clearButton.setOnClickListener {
                viewModel.delete()
                writeTextView.text = viewModel.expression
                answerTextView.text = ""
                operation = ""
            }
            equallyButton.setOnClickListener {
                viewModel.operation(operation)
                answerTextView.text = viewModel.result.toString()
                isNew = false
            }
        }
    }

    private fun writeSymbol(number: String) {
        viewModel.write(number)
        binding?.writeTextView?.text = viewModel.expression
        if (isNew) {
            viewModel.writeNewNumber(number)
        }
    }

}