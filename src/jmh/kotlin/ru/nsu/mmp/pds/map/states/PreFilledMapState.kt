package ru.nsu.mmp.pds.map.states

import fj.Ord
import org.openjdk.jmh.annotations.Level
import org.openjdk.jmh.annotations.Setup
import ru.nsu.mmp.pds.map.PersistentMap
import ru.nsu.mmp.pds.map.PersistentTreeMap
import java.util.*

open class PreFilledMapState: PreInitMapState() {

    @Setup(Level.Invocation)
    override fun setup() {
        baseline = TreeMap()
        for (i in 1..size) {
            baseline[i*2] = element
        }
        val a: PersistentMap<Int, String> = PersistentTreeMap()
        custom = a.putAll(baseline)
        functional = fj.data.TreeMap.fromMutableMap(Ord.intOrd, baseline)
    }
}