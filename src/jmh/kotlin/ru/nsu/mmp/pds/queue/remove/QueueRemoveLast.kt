package ru.nsu.mmp.pds.queue.remove

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.infra.Blackhole
import ru.nsu.mmp.pds.queue.states.PreFilledQueueState

open class QueueRemoveLast {

    @Benchmark
    fun custom(blackhole: Blackhole, state: PreFilledQueueState) {
        var deque = state.custom
        for (i in 0 until state.size) {
            deque = deque.removeLast()?.second ?: throw IllegalStateException()
        }
        blackhole.consume(deque)
    }

    @Benchmark
    fun baseline(state: PreFilledQueueState) {
        for (i in 0 until state.size) {
            state.baseline.removeLast()
        }
    }

    @Benchmark
    fun functionalQueue(blackhole: Blackhole, state: PreFilledQueueState) {
        var queue = state.functionalQueue
        for (i in 0 until state.size) {
            queue = queue.dequeue()
        }
        blackhole.consume(queue)
    }
}