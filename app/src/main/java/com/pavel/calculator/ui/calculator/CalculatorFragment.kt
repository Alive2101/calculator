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

            //числа
            oneButton.setOnClickListener {
                writeSymbol(oneButton.text.toString())
            }
            twoButton.setOnClickListener {
                writeSymbol(twoButton.text.toString())
            }
            threeButton.setOnClickListener {
                writeSymbol(threeButton.text.toString())
            }
            fourButton.setOnClickListener {
                writeSymbol(fourButton.text.toString())
            }
            fiveButton.setOnClickListener {
                writeSymbol(fiveButton.text.toString())
            }
            sixButton.setOnClickListener {
                writeSymbol(sixButton.text.toString())
            }
            sevenButton.setOnClickListener {
                writeSymbol(sevenButton.text.toString())
            }
            eightButton.setOnClickListener {
                writeSymbol(eightButton.text.toString())
            }
            nineButton.setOnClickListener {
                writeSymbol(nineButton.text.toString())
            }
            zeroButton.setOnClickListener {
                writeSymbol(zeroButton.text.toString())
            }

            //действия
            plusAndMinusButton.setOnClickListener {
                //поменять знак
            }

            percentButton.setOnClickListener {
                //проценты
            }
            divideButton.setOnClickListener {
                //деление
            }
            multiplyButton.setOnClickListener {
                //умножить
            }
            minusButton.setOnClickListener {
                //отнять
            }
            plusButton.setOnClickListener {
                //прибавить
            }

            clearButton.setOnClickListener {
                //очистка
            }

            equallyButton.setOnClickListener {
                //равно
            }

            pointButton.setOnClickListener {
                writeSymbol(pointButton.text.toString())
                //точка
            }

        }
    }

    private fun writeSymbol(number: String) {
        viewModel.write(number)
        binding?.writeTextView?.text = viewModel.string
    }
}