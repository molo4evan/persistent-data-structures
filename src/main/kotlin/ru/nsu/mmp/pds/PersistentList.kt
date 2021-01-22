package ru.nsu.mmp.pds

/**
 * Implementations of update functions must update previous and next versions as needed.
 */
abstract class PersistentList<E>: List<E> {

    protected var previousVersion: AbstractList<E>? = null

    protected var nextVersion: AbstractList<E>? = null

    fun undo() = previousVersion

    fun redo() = nextVersion

    override fun containsAll(elements: Collection<E>): Boolean {
        for (e in elements) {
            if (!contains(e)) return false
        }
        return true
    }

    override fun isEmpty() = size == 0

    override fun indexOf(element: E) = indexOfFirst { it == element }

    override fun lastIndexOf(element: E) = indexOfLast { it == element }

    override fun listIterator() = listIterator(0)

    abstract fun add(element: E, index: Int): Boolean

    abstract fun remove(index: Int): Boolean

    abstract fun set(element: E, index: Int): Boolean
}
