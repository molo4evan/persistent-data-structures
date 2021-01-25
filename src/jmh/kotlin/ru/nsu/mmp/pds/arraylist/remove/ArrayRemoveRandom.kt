package ru.nsu.mmp.pds.arraylist.remove

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.infra.Blackhole
import ru.nsu.mmp.pds.arraylist.states.PreFilledArrayState
import kotlin.random.Random

open class ArrayRemoveRandom {
    @Benchmark
    fun custom(blackhole: Blackhole, state: PreFilledArrayState) {
        var arr = state.custom
        for (i in 1..state.size) {
            arr = arr.remove(randomIndex(arr.size))
        }
        blackhole.consume(arr)
    }

    @Benchmark
    fun baseline(state: PreFilledArrayState) {
        for (i in 1..state.size) {
            state.baseline.removeAt(randomIndex(state.baseline.size))
        }
    }

    @Benchmark
    fun procrastination(blackhole: Blackhole, state: PreFilledArrayState) {
        var arr = state.procrastination
        for (i in 1..state.size) {
            arr = arr.delete(randomIndex(state.size - i + 1).toLong())
        }
        blackhole.consume(arr)
    }

    private fun randomIndex(size: Int) = Random.Default.nextInt(size)
}