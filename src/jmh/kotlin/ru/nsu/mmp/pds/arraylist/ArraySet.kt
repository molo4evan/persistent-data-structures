package ru.nsu.mmp.pds.arraylist

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.infra.Blackhole
import ru.nsu.mmp.pds.BaseState
import ru.nsu.mmp.pds.arraylist.states.SingleFilledArrayState
import kotlin.random.Random

open class ArraySet {
    @Benchmark
    fun custom(blackhole: Blackhole, state: SingleFilledArrayState) {
        blackhole.consume(state.custom.set(state.element + Random.Default.nextInt().toString(), randomIndex(state)))
    }

    @Benchmark
    fun baseline(state: SingleFilledArrayState) {
        state.baseline[randomIndex(state)] = state.element
    }

    @Benchmark
    fun functionalArray(blackhole: Blackhole, state: SingleFilledArrayState) {
        blackhole.consume(state.functionalArray.set(randomIndex(state), state.element))
    }

    private fun randomIndex(state: BaseState) = Random.Default.nextInt(state.size)
}