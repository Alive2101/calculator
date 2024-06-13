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
        initView()
        observeViewModel()
    }

    private fun observeViewModel() = viewModel.run {
        expressionLiveData.observe(viewLifecycleOwner) {
            binding?.writeTextView?.text = it
        }
        resultLiveData.observe(viewLifecycleOwner) {
            binding?.answerTextView?.text = it?.toString() ?: ""
        }
    }

    private fun initView() = binding?.run {
        oneButton.setOnClickListener {
            viewModel.inputSymbols(oneButton.text.toString())
        }

        twoButton.setOnClickListener {
            viewModel.inputSymbols(twoButton.text.toString())
        }

        threeButton.setOnClickListener {
            viewModel.inputSymbols(threeButton.text.toString())
        }

        fourButton.setOnClickListener {
            viewModel.inputSymbols(fourButton.text.toString())
        }

        fiveButton.setOnClickListener {
            viewModel.inputSymbols(fiveButton.text.toString())
        }

        sixButton.setOnClickListener {
            viewModel.inputSymbols(sixButton.text.toString())
        }

        sevenButton.setOnClickListener {
            viewModel.inputSymbols(sevenButton.text.toString())
        }

        eightButton.setOnClickListener {
            viewModel.inputSymbols(eightButton.text.toString())
        }

        nineButton.setOnClickListener {
            viewModel.inputSymbols(nineButton.text.toString())
        }

        zeroButton.setOnClickListener {
            viewModel.inputSymbols(zeroButton.text.toString())
        }

        plusAndMinusButton.setOnClickListener {
            viewModel.changeSign()
        }

        pointButton.setOnClickListener {
            viewModel.inputSymbols(pointButton.text.toString())
        }

        percentButton.setOnClickListener {
            viewModel.addOperation(percentButton.text.toString())
        }

        divideButton.setOnClickListener {
            viewModel.addOperation(divideButton.text.toString())
        }

        multiplyButton.setOnClickListener {
            viewModel.addOperation(multiplyButton.text.toString())
        }

        minusButton.setOnClickListener {
            viewModel.addOperation(minusButton.text.toString())
        }

        plusButton.setOnClickListener {
            viewModel.addOperation(plusButton.text.toString())
        }

        clearButton.setOnClickListener {
            viewModel.clearValues()
        }

        equallyButton.setOnClickListener {
            viewModel.solveOperation()
        }
    }
}