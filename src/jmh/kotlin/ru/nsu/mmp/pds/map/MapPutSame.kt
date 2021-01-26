package ru.nsu.mmp.pds.map

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.infra.Blackhole
import ru.nsu.mmp.pds.BaseState
import ru.nsu.mmp.pds.map.states.SingleFilledMapState
import kotlin.random.Random

open class MapPutSame {

    @Benchmark
    fun baseline(state: SingleFilledMapState) {
        state.baseline[randomIndex(state)*2] = state.element
    }

    @Benchmark
    fun custom(blackhole: Blackhole, state: SingleFilledMapState) {
        blackhole.consume(state.custom.put(randomIndex(state)*2, state.element))
    }

    @Benchmark
    fun functional(blackhole: Blackhole, state: SingleFilledMapState) {
        blackhole.consume(state.functional.update(randomIndex(state)*2, { state.element }, state.element))
    }

    private fun randomIndex(state: BaseState) = Random.Default.nextInt(state.size)
}