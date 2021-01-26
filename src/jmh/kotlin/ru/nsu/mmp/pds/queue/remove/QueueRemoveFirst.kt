package ru.nsu.mmp.pds.queue.remove

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.infra.Blackhole
import ru.nsu.mmp.pds.queue.states.PreFilledQueueState

open class QueueRemoveFirst {

    @Benchmark
    fun custom(blackhole: Blackhole, state: PreFilledQueueState) {
        var deque = state.custom
        for (i in 0 until state.size) {
            deque = deque.removeFirst()?.second ?: throw IllegalStateException()
        }
        blackhole.consume(deque)
    }

    @Benchmark
    fun baseline(state: PreFilledQueueState) {
        for (i in 0 until state.size) {
            state.baseline.removeFirst()
        }
    }

    @Benchmark
    fun functionalList(blackhole: Blackhole, state: PreFilledQueueState) {
        var list = state.functionalList
        for (i in 0 until state.size) {
            list = list.tail()
        }
        blackhole.consume(list)
    }

    @Benchmark
    fun procrastination(blackhole: Blackhole, state: PreFilledQueueState) {
        var seq = state.procrastination
        for (i in 0 until state.size) {
            seq = seq.tail().eager().orThrow()
        }
        blackhole.consume(seq)
    }
}