package ru.nsu.mmp.pds.arraylist

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.infra.Blackhole
import ru.nsu.mmp.pds.BaseState
import ru.nsu.mmp.pds.arraylist.states.SingleFilledArrayState
import kotlin.random.Random

open class ArrayGet {

    @Benchmark
    fun custom(blackhole: Blackhole, state: SingleFilledArrayState) {
        blackhole.consume(state.custom[randomIndex(state)])
    }

    @Benchmark
    fun baseline(blackhole: Blackhole, state: SingleFilledArrayState) {
        blackhole.consume(state.baseline[randomIndex(state)])
    }

    @Benchmark
    fun functionalArray(blackhole: Blackhole, state: SingleFilledArrayState) {
        blackhole.consume(state.functionalArray[randomIndex(state)])
    }

    @Benchmark
    fun functionalList(blackhole: Blackhole, state: SingleFilledArrayState) {
        blackhole.consume(state.functionalList.index(randomIndex(state)))
    }

    @Benchmark
    fun procrastination(blackhole: Blackhole, state: SingleFilledArrayState) {
        blackhole.consume(state.procrastination.element(randomIndex(state).toLong()))
    }

    private fun randomIndex(state: BaseState) = Random.Default.nextInt(state.size)
}