package com.hohoanghai.shoestore.fragment.instructions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hohoanghai.shoestore.R
import com.hohoanghai.shoestore.model.Instruction

class InstructionsViewModel : ViewModel() {
    val instructions =
        listOf(
            Instruction(
                R.string.instruction_1,
                R.string.instruction_subtitle,
                R.drawable.ic_instruction_1
            ),
            Instruction(
                R.string.instruction_2,
                R.string.instruction_subtitle,
                R.drawable.ic_instruction_2
            ),
            Instruction(
                R.string.instruction_3,
                R.string.instruction_subtitle,
                R.drawable.ic_instruction_3
            ),
            Instruction(
                R.string.instruction_4,
                R.string.instruction_subtitle,
                R.drawable.ic_instruction_4
            ),
            Instruction(
                R.string.instruction_5,
                R.string.instruction_subtitle,
                R.drawable.ic_instruction_5
            )
        )

    private val _index = MutableLiveData<Int>()
    val index: LiveData<Int> = _index

    private val _currentInstruction = MutableLiveData<Instruction>()
    val currentInstruction: LiveData<Instruction> = _currentInstruction

    private val _isFinish = MutableLiveData<Boolean>()
    val isFinish: LiveData<Boolean> = _isFinish

    init {
        _index.value = 0
        _isFinish.value = false
        updateCurrentInstruction()
    }

    fun next() {
        if (_index.value == instructions.size - 1) {
            _isFinish.value = true
            return
        }
        _index.value = _index.value?.plus(1)
        updateCurrentInstruction()
    }

    fun prev() {
        if (_index.value == 0) {
            return
        }
        _index.value = _index.value?.minus(1)
        updateCurrentInstruction()
    }

    private fun updateCurrentInstruction() {
        _currentInstruction.value = instructions[_index.value ?: 0]
    }
}