package ru.nsu.mmp.pds

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.infra.Blackhole
import ru.nsu.mmp.pds.arraylist.states.PreInitArrayState
import ru.nsu.mmp.pds.arraylist.states.SingleFilledArrayState

open class ArrayAddFirst {

    @Benchmark
    fun custom(blackhole: Blackhole, state: PreInitArrayState) {
        var arr = state.custom
        for (i in 1..state.size) {
            arr = arr.add(state.element, 0)
        }
        blackhole.consume(arr)
    }

    @Benchmark
    fun baseline(state: SingleFilledArrayState) {
        state.baseline.add(0, state.element)
    }

    @Benchmark
    fun functionalList(blackhole: Blackhole, state: SingleFilledArrayState) {
        var arr = state.functionalList
        for (i in 1..state.size) {
            arr = arr.cons(state.element)
        }
        blackhole.consume(arr)
    }
}