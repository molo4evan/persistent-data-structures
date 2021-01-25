package ru.nsu.mmp.pds.queue.states

import fj.P
import fj.data.List
import fj.data.PriorityQueue
import io.github.gdejohn.procrastination.Sequence
import org.openjdk.jmh.annotations.Level
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import ru.nsu.mmp.pds.deque.FingerTreeDeque
import java.util.*

@State(Scope.Benchmark)
open class PreFilledQueueState: PreInitQueueState() {

    @Setup(Level.Invocation)
    override fun setup() {
        val elements = (1..size).map { element }
        custom = FingerTreeDeque.fromIterable(elements)
        baseline = ArrayDeque(elements)
        functionalQueue = PriorityQueue.emptyInt<String>()
            .enqueue((1..size).map { P.p(1, element) })
        functionalList = List.fromIterator(elements.iterator())
        procrastination = Sequence.from(elements)
    }
}