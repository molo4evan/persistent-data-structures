package ru.nsu.mmp.pds.arraylist

import ru.nsu.mmp.pds.PersistentDataStructure

/**
 * Implementations of update functions must update previous and next versions as needed.
 */
interface PersistentList<E>: List<E>, PersistentDataStructure<PersistentList<E>> {
    override fun containsAll(elements: Collection<E>): Boolean {
        for (e in elements) {
            if (!contains(e)) return false
        }

        return true
    }

    override fun contains(element: E): Boolean {
        for (e in this) {
            if (e == element) return true
        }
        return false
    }

    override fun isEmpty() = size == 0

    override fun indexOf(element: E) = indexOfFirst { it == element }

    override fun lastIndexOf(element: E) = indexOfLast { it == element }

    override fun listIterator() = listIterator(0)

    fun add(element: E, index: Int): PersistentList<E>

    fun add(element: E): PersistentList<E> = add(element, size)

    fun remove(index: Int): PersistentList<E>

    fun set(element: E, index: Int): PersistentList<E>
}
