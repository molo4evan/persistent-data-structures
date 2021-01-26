package ru.nsu.mmp.pds.queue.add

import fj.data.List
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.infra.Blackhole
import ru.nsu.mmp.pds.queue.states.PreInitQueueState

open class QueueAddLast {

    @Benchmark
    fun custom(blackhole: Blackhole, state: PreInitQueueState) {
        var deque = state.custom
        for (i in 0 until state.size) {
            deque = deque.addLast(state.element)
        }
        blackhole.consume(deque)
    }

    @Benchmark
    fun baseline(state: PreInitQueueState) {
        for (i in 0 until state.size) {
            state.baseline.addLast(state.element)
        }
    }

    @Benchmark
    fun functionalList(blackhole: Blackhole, state: PreInitQueueState) {
        var list = state.functionalList
        for (i in 0 until state.size) {
            list = list.append(List.list(state.element))
        }
        blackhole.consume(list)
    }

    @Benchmark
    fun procrastination(blackhole: Blackhole, state: PreInitQueueState) {
        var seq = state.procrastination
        for (i in 0 until state.size) {
            seq = seq.append(state.element).eager()
        }
        blackhole.consume(seq)
    }
}