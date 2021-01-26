package ru.nsu.mmp.pds.map

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.infra.Blackhole
import ru.nsu.mmp.pds.map.states.PreFilledMapState
import kotlin.random.Random

open class MapRemove {

    @Benchmark
    fun baseline(state: PreFilledMapState) {
        for (i in 0 until state.size) {
            state.baseline.remove(randomIndex(state.size - i)*2)
        }
    }

    @Benchmark
    fun custom(blackhole: Blackhole, state: PreFilledMapState) {
        var m = state.custom
        for (i in 0 until state.size) {
            m = m.remove(randomIndex(state.size - i)*2)
        }
        blackhole.consume(m)
    }

    @Benchmark
    fun functional(blackhole: Blackhole, state: PreFilledMapState) {
        var m = state.functional
        for (i in 0 until state.size) {
            m = m.delete(randomIndex(state.size - i)*2)
        }
        blackhole.consume(m)
    }

    private fun randomIndex(size: Int) = Random.Default.nextInt(size)
}