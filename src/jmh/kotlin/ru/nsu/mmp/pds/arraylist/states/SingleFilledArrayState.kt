package ru.nsu.mmp.pds.arraylist.states

import org.openjdk.jmh.annotations.Level
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State

@State(Scope.Benchmark)
open class SingleFilledArrayState: PreFilledArrayState() {

    @Setup(Level.Trial)
    override fun setup() {
        super.setup()
    }
}