package ru.nsu.mmp.pds

import org.openjdk.jmh.annotations.Param
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State

@State(Scope.Benchmark)
open class WideBenchState : BaseState() {
    @Param("100", "1000", "10000", "100000", "1000000")
    override var size: Int = 0
}