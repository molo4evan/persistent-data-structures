package ru.nsu.mmp.pds.arraylist

import fj.data.Array
import fj.data.List
import io.github.gdejohn.procrastination.Sequence
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.infra.Blackhole
import ru.nsu.mmp.pds.WideBenchState

open class ArrayCreate {

    @Benchmark
    fun custom(blackhole: Blackhole, state: WideBenchState) {
        blackhole.consume(BTreeArrayList<String>(state.size))
    }

    @Benchmark
    fun baseline(blackhole: Blackhole, state: WideBenchState) {
        blackhole.consume(ArrayList<String>(state.size))
    }

    @Benchmark
    fun functionalArray(blackhole: Blackhole, state: WideBenchState) {
        blackhole.consume(Array.iterableArray(state.elements))
    }

    @Benchmark
    fun functionalList(blackhole: Blackhole, state: WideBenchState) {
        blackhole.consume(List.fromIterator(state.elements.iterator()))
    }

    @Benchmark
    fun procrastination(blackhole: Blackhole, state: WideBenchState) {
        blackhole.consume(Sequence.from(state.elements).eager())
    }
}