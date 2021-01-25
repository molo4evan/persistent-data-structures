package ru.nsu.mmp.pds.arraylist.remove

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.infra.Blackhole
import ru.nsu.mmp.pds.arraylist.states.PreFilledArrayState

open class ArrayRemoveFirst {

    @Benchmark
    fun custom(blackhole: Blackhole, state: PreFilledArrayState) {
        var arr = state.custom
        for (i in 1..state.size) {
            arr = arr.remove(0)
        }
        blackhole.consume(arr)
    }

    @Benchmark
    fun baseline(state: PreFilledArrayState) {
        for (i in 1..state.size) {
            state.baseline.removeAt(0)
        }
    }

    @Benchmark
    fun functionalList(blackhole: Blackhole, state: PreFilledArrayState) {
        var arr = state.functionalList
        for (i in 1..state.size) {
            arr = arr.tail()
        }
        blackhole.consume(arr)
    }

    @Benchmark
    fun procrastination(blackhole: Blackhole, state: PreFilledArrayState) {
        var arr = state.procrastination
        for (i in 1..state.size) {
            arr = arr.tail().orThrow()
        }
        blackhole.consume(arr)
    }
}