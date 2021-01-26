package ru.nsu.mmp.pds.map.states

import fj.Ord
import org.openjdk.jmh.annotations.Level
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import ru.nsu.mmp.pds.BaseState
import ru.nsu.mmp.pds.map.PersistentMap
import ru.nsu.mmp.pds.map.PersistentTreeMap
import java.util.*

@State(Scope.Benchmark)
open class PreInitMapState: BaseState() {
    lateinit var baseline: TreeMap<Int, String>
    lateinit var custom: PersistentMap<Int, String>
    lateinit var functional: fj.data.TreeMap<Int, String>

    @Setup(Level.Invocation)
    override fun setup() {
        custom = PersistentTreeMap()
        baseline = TreeMap()
        functional = fj.data.TreeMap.empty(Ord.intOrd)
    }
}