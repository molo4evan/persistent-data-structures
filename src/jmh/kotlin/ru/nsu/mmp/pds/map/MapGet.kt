package ru.nsu.mmp.pds.map

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.infra.Blackhole
import ru.nsu.mmp.pds.BaseState
import ru.nsu.mmp.pds.map.states.SingleFilledMapState
import kotlin.random.Random

open class MapGet {

    @Benchmark
    fun baseline(blackhole: Blackhole, state: SingleFilledMapState) {
        blackhole.consume(state.baseline[randomIndex(state)*2])
    }

    @Benchmark
    fun custom(blackhole: Blackhole, state: SingleFilledMapState) {
        blackhole.consume(state.custom[randomIndex(state)*2])
    }

    @Benchmark
    fun functional(blackhole: Blackhole, state: SingleFilledMapState) {
        blackhole.consume(state.functional[randomIndex(state)*2])
    }

    private fun randomIndex(state: BaseState) = Random.Default.nextInt(state.size)
}