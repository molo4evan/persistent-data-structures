package ru.nsu.mmp.pds.map.states

import org.openjdk.jmh.annotations.Level
import org.openjdk.jmh.annotations.Setup

open class SingleFilledMapState: PreFilledMapState() {

    @Setup(Level.Trial)
    override fun setup() {
        super.setup()
    }
}