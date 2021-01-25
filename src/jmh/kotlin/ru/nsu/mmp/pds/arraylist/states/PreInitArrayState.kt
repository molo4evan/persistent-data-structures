package ru.nsu.mmp.pds.arraylist.states

import fj.data.Array
import io.github.gdejohn.procrastination.Sequence
import org.openjdk.jmh.annotations.Level
import org.openjdk.jmh.annotations.Setup
import ru.nsu.mmp.pds.BaseState
import ru.nsu.mmp.pds.arraylist.BTreeArrayList
import ru.nsu.mmp.pds.arraylist.PersistentList

open class PreInitArrayState: BaseState() {
    lateinit var custom: PersistentList<String>
    lateinit var baseline: ArrayList<String>
    lateinit var functionalArray: Array<String>
    lateinit var functionalList: fj.data.List<String>
    lateinit var procrastination: Sequence<String>

    @Setup(Level.Invocation)
    override fun setup() {
        super.setup()
        custom = BTreeArrayList()
        baseline = ArrayList()
        functionalArray = Array.empty()
        functionalList = fj.data.List.nil()
        procrastination = Sequence.empty()
    }
}