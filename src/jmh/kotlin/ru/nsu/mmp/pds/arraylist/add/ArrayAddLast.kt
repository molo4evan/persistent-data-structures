package ru.nsu.mmp.pds.arraylist.add

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.infra.Blackhole
import ru.nsu.mmp.pds.arraylist.states.PreInitArrayState

open class ArrayAddLast {

    @Benchmark
    fun custom(blackhole: Blackhole, state: PreInitArrayState) {
        var arr = state.custom
        for (i in 1..state.size) {
            arr = arr.add(state.element)
        }
        blackhole.consume(arr)
    }

    @Benchmark
    fun baseline(state: PreInitArrayState) {
        for (i in 1..state.size) {
            state.baseline.add(state.element)
        }
    }

    @Benchmark
    fun procrastination(blackhole: Blackhole, state: PreInitArrayState) {
        var arr = state.procrastination
        for (i in 1..state.size) {
            arr = arr.append(state.element).eager()
        }
        blackhole.consume(arr)
    }
}