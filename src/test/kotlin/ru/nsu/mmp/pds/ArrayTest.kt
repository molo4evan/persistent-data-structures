package ru.nsu.mmp.pds

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import ru.nsu.mmp.pds.arraylist.BTreeArrayList
import ru.nsu.mmp.pds.arraylist.PersistentList

class ArrayTest {

    @Test
    fun `Create array`() {
        val arrayList = BTreeArrayList(5, 30, 3, { "123" })
        assertEquals(arrayList.size, 5)
    }

    @Test
    fun `Add elements to array`() {
        var array: PersistentList<String> = BTreeArrayList()
        array = array.add("123")
        array = array.add("234")
        array = array.add("345", 1)
        assertArrayEquals(array.toTypedArray(), arrayOf("123", "345", "234"))
    }

    @Test
    fun `Array batch add`() {
        var array: PersistentList<String> = BTreeArrayList(initialCapacity = 8)
        val list = (1..100).map(Int::toString)
        array = array.addAll(list)
        assertArrayEquals(array.toTypedArray(), list.toTypedArray())
    }

    @Test
    fun `Create array from collection`() {
        val list = (1..30).map(Int::toString)
        val array = BTreeArrayList.fromList(list)
        assertArrayEquals(array.toTypedArray(), list.toTypedArray())
    }

    @Test
    fun `Get array element`() {
        val list = (1..30).map(Int::toString)
        val array = BTreeArrayList.fromList(list)
        assertEquals("5", array[4])
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            array[-1]
        }
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            array[array.size]
        }
    }

    @Test
    fun `Set array element`() {
        val list = (1..5).map(Int::toString)
        var array: PersistentList<String> = BTreeArrayList.fromList(list)
        array = array.set("9", 2)
        assertArrayEquals(array.toTypedArray(), arrayOf("1", "2", "9", "4", "5"))
    }

    @Test
    fun `Remove array element`() {
        val list = (1..5).map(Int::toString)
        var array: PersistentList<String> = BTreeArrayList.fromList(list)
        array = array.remove(2)
        assertArrayEquals(array.toTypedArray(), arrayOf("1", "2", "4", "5"))
    }

    @Test
    fun `Iterate over array`() {
        val list = (1..100).map(Int::toString)
        val array: PersistentList<String> = BTreeArrayList.fromList(list)
        var i = 0
        for (e in array) {
            assertEquals(list[i++], e)
        }

        val listIterator = array.listIterator()
        while (listIterator.hasPrevious()) {
            assertEquals(list[i--], listIterator.previous())
        }
    }

    @Test
    fun `Get array sublist`() {
        val list = (1..5).map(Int::toString)
        val array: PersistentList<String> = BTreeArrayList.fromList(list)
        val sublist = array.subList(1, 3)
        assertEquals(sublist[1], "3")
    }

    @Test
    fun `Undo-Redo mechanism`() {
        val list = listOf("123", "234", "345")
        val array = BTreeArrayList.fromList(list)

        val updated = array.add("777")
        assertEquals(array.toList(), updated.undo().toList())
        assertEquals(updated.toList(), array.redo().toList())

        val anotherUpdate = array.add("333")
        assertEquals(array.toList(), updated.undo().toList())
        assertEquals(array.toList(), anotherUpdate.undo().toList())
        assertEquals(anotherUpdate.toList(), array.redo().toList())
    }
}