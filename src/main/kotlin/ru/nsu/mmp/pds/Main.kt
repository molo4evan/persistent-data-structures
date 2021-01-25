package ru.nsu.mmp.pds

import ru.nsu.mmp.pds.arraylist.BTreeArrayList
import ru.nsu.mmp.pds.arraylist.PersistentList
import ru.nsu.mmp.pds.deque.FingerTreeDeque
import ru.nsu.mmp.pds.deque.PersistentDeque

fun main(args: Array<String>) {
    var a: PersistentList<String> = BTreeArrayList()
    a = a.add("123", 0)
    a = a.add("123", 0)
    a = a.add("123", 0)
    a = a.add("123", 0)
    a = a.add("123", 0)
    a = a.add("123", 0)
    a = a.add("123", 0)



    a = a.add("123")
    a = a.add("345")
    a = a.add("456")
    for (e in a) {
        println(e)
    }
    println()
    a = a.set("111", 1)
    for (e in a) {
        println(e)
    }
    println()
    a = a.add("777", 0)
    for (e in a) {
        println(e)
    }
    println()
    a = a.remove(0)
    for (e in a) {
        println(e)
    }
    println()
    a = a.undo()
    for (e in a) {
        println(e)
    }
    println()
    a = a.redo()
    for (e in a) {
        println(e)
    }
    println()

    var b: PersistentDeque<String> = FingerTreeDeque()
    b = b.add("123")
    b = b.add("234")
    b = b.addFirst("345")
    for (e in b) {
        println(e)
    }
    println()
    var remove = b.remove() ?: throw RuntimeException("What?!")
    b = remove.second
    println("Removed ${remove.first}")
    remove = b.removeFirst() ?: throw RuntimeException("What?!")
    b = remove.second
    println("Removed ${remove.first}")
    for (e in b) {
        println(e)
    }
    println("Ahaha")
    b = b.undo()
    for (e in b) {
        println(e)
    }
    println()
    b = b.redo()
    for (e in b) {
        println(e)
    }
}