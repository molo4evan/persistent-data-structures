package ru.nsu.mmp.pds.arraylist.remove

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.infra.Blackhole
import ru.nsu.mmp.pds.arraylist.states.PreFilledArrayState

open class ArrayRemoveLast {
    @Benchmark
    fun custom(blackhole: Blackhole, state: PreFilledArrayState) {
        var arr = state.custom
        for (i in 1..state.size) {
            arr = arr.remove(arr.size - 1)
        }
        blackhole.consume(arr)
    }

    @Benchmark
    fun baseline(state: PreFilledArrayState) {
        for (i in 1..state.size) {
            state.baseline.removeLast()
        }
    }

    @Benchmark
    fun procrastination(blackhole: Blackhole, state: PreFilledArrayState) {
        var arr = state.procrastination
        for (i in 1..state.size) {
            arr = arr.delete((state.size - i).toLong())
        }
        blackhole.consume(arr)
    }
}