package ru.nsu.mmp.pds.arraylist.add

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.infra.Blackhole
import ru.nsu.mmp.pds.BaseState
import ru.nsu.mmp.pds.arraylist.states.SingleFilledArrayState
import kotlin.random.Random

open class ArrayAddRandom {
    @Benchmark
    fun custom(blackhole: Blackhole, state: SingleFilledArrayState) {
        val index = randomIndex(state)
        blackhole.consume(state.custom.add(state.element, index))
    }

    @Benchmark
    fun baseline(state: SingleFilledArrayState) {
        state.baseline.add(randomIndex(state), state.element)
    }

    @Benchmark
    fun procrastination(blackhole: Blackhole, state: SingleFilledArrayState) {
        blackhole.consume(state.procrastination.insert(randomIndex(state).toLong(), state.element))
    }

    private fun randomIndex(state: BaseState) = Random.Default.nextInt(state.size)
}