package ru.nsu.mmp.pds

import org.openjdk.jmh.annotations.*

@State(Scope.Benchmark)
open class BaseState {
    val element = "Random string"

    lateinit var elements: List<String>

    @Param("10", "100", "1000", "10000")
    open var size: Int = 0

    @Setup(Level.Trial)
    open fun setup() {
        elements = (1..size).map { element }
    }
}