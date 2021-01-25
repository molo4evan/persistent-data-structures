package ru.nsu.mmp.pds

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import ru.nsu.mmp.pds.deque.FingerTreeDeque
import ru.nsu.mmp.pds.deque.PersistentDeque

class DequeTest {

    @Test
    fun `Create deque`() {
        FingerTreeDeque<String>()
    }

    @Test
    fun `Add element to deque`() {
        val deque = FingerTreeDeque<String>()

        val updated = deque.addFirst("123")
        assertEquals(deque.toList(), listOf<String>())
        assertEquals(updated.toList(), listOf("123"))

        val anotherUpdate = deque.addLast("234")
        assertEquals(deque.toList(), listOf<String>())
        assertEquals(updated.toList(), listOf("123"))
        assertEquals(anotherUpdate.toList(), listOf("234"))
    }

    @Test
    fun `Multiple operations`() {
        val deque = FingerTreeDeque<String>()
        val range = 0..30

        var a: PersistentDeque<String> = deque
        for (i in range) {
            a = a.addFirst(i.toString())
        }
        assertEquals(range.map(Int::toString).reversed(), a.toList())
        for (i in range) {
            a = a.removeFirst()!!.second
        }
        assertEquals(a.toList(), deque.toList())

        var b: PersistentDeque<String> = deque
        for (i in range) {
            b = b.addLast(i.toString())
        }
        assertEquals(range.map(Int::toString), b.toList())
        for (i in range) {
            b = b.removeLast()!!.second
        }
        assertEquals(b.toList(), deque.toList())
    }

    @Test
    fun `Concatenate two dequeues`() {
        val list1 = listOf("123", "234", "345")
        val deque1 = FingerTreeDeque.fromIterable(list1)

        val list2 = listOf("456", "567", "789", "890")
        val deque2 = FingerTreeDeque.fromIterable(list2)

        val deque = deque1.addAll(deque2)
        assertEquals(deque.toList(), list1 + list2)
    }

    @Test
    fun `Add list`() {
        val list1 = listOf("123", "234", "345")
        val deque1 = FingerTreeDeque.fromIterable(list1)

        val list2 = listOf("456", "567", "789", "890")

        val deque = deque1.addAll(list2)
        assertEquals(deque.toList(), list1 + list2)
    }

    @Test
    fun `Remove element from deque`() {
        val list = listOf("123", "234", "345")
        val deque = FingerTreeDeque.fromIterable(list)

        val updated = deque.removeFirst()
        assertEquals(deque.toList(), list)
        assertNotNull(updated)
        assertEquals(updated!!.first, list.first())
        assertEquals(updated.second.toList(), list.drop(1))

        val anotherUpdate = deque.removeLast()
        assertEquals(deque.toList(), list)
        assertNotNull(anotherUpdate)
        assertEquals(anotherUpdate!!.first, list.last())
        assertEquals(updated.second.toList(), list.drop(1))
        assertEquals(anotherUpdate.second.toList(), list.dropLast(1))
    }

    @Test
    fun `Undo-Redo mechanism`() {
        val list = listOf("123", "234", "345")
        val deque = FingerTreeDeque.fromIterable(list)

        val updated = deque.add("777")
        assertEquals(deque.toList(), updated.undo().toList())
        assertEquals(updated.toList(), deque.redo().toList())

        val anotherUpdate = deque.add("333")
        assertEquals(deque.toList(), updated.undo().toList())
        assertEquals(deque.toList(), anotherUpdate.undo().toList())
        assertEquals(anotherUpdate.toList(), deque.redo().toList())
    }
}