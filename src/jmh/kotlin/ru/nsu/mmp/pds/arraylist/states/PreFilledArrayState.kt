package ru.nsu.mmp.pds.arraylist.states

import fj.data.Array
import io.github.gdejohn.procrastination.Sequence
import org.openjdk.jmh.annotations.Level
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import ru.nsu.mmp.pds.arraylist.BTreeArrayList

@State(Scope.Benchmark)
open class PreFilledArrayState: PreInitArrayState() {

    @Setup(Level.Invocation)
    override fun setup() {
        super.setup()
        custom = BTreeArrayList(size, elementProvider = { element })
        baseline = ArrayList(elements)
        functionalArray = Array.iterableArray(elements)
        functionalList = fj.data.List.iterableList(elements)
        procrastination = Sequence.from(elements)
    }
}