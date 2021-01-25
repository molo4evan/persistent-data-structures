package ru.nsu.mmp.pds.queue.states

import fj.data.List
import fj.data.PriorityQueue
import io.github.gdejohn.procrastination.Sequence
import org.openjdk.jmh.annotations.Level
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import ru.nsu.mmp.pds.BaseState
import ru.nsu.mmp.pds.deque.FingerTreeDeque
import ru.nsu.mmp.pds.deque.PersistentDeque
import java.util.*

@State(Scope.Benchmark)
open class PreInitQueueState: BaseState() {

    lateinit var custom: PersistentDeque<String>
    lateinit var baseline: Deque<String>
    lateinit var functionalQueue: PriorityQueue<Int, String>
    lateinit var functionalList: List<String>
    lateinit var procrastination: Sequence<String>

    @Setup(Level.Invocation)
    override fun setup() {
        custom = FingerTreeDeque()
        baseline = ArrayDeque()
        functionalQueue = PriorityQueue.emptyInt()
        functionalList = List.nil()
        procrastination = Sequence.empty()
    }
}