package ru.nsu.mmp.pds.queue.add

import fj.data.List
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.infra.Blackhole
import ru.nsu.mmp.pds.queue.states.PreInitQueueState

open class QueueAddFirst {

    @Benchmark
    fun custom(blackhole: Blackhole, state: PreInitQueueState) {
        var deque = state.custom
        for (i in 0 until state.size) {
            deque = deque.addFirst(state.element)
        }
        blackhole.consume(deque)
    }

    @Benchmark
    fun baseline(state: PreInitQueueState) {
        for (i in 0 until state.size) {
            state.baseline.addFirst(state.element)
        }
    }

    @Benchmark
    fun functionalQueue(blackhole: Blackhole, state: PreInitQueueState) {
        var queue = state.functionalQueue
        for (i in 0 until state.size) {
            queue = queue.enqueue(1, state.element)
        }
        blackhole.consume(queue)
    }

    @Benchmark
    fun functionalList(blackhole: Blackhole, state: PreInitQueueState) {
        var list = state.functionalList
        for (i in 0 until state.size) {
            list = List.cons(state.element, list)
        }
        blackhole.consume(list)
    }

    @Benchmark
    fun procrastination(blackhole: Blackhole, state: PreInitQueueState) {
        var seq = state.procrastination
        for (i in 0 until state.size) {
            seq = seq.insert(0, state.element).eager()
        }
        blackhole.consume(seq)
    }
}