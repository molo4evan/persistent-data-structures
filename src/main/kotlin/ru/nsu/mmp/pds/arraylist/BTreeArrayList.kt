package ru.nsu.mmp.pds.arraylist

import kotlin.math.max

open class BTreeArrayList<E : Any?> private constructor(
    private val tree: BTree<E>,
    override val size: Int = 0,
    private var previous: PersistentList<E>? = null,
    private var next: PersistentList<E>? = null
) : PersistentList<E> {

    constructor(
        size: Int = 0,
        initialCapacity: Int = 64,
        factor: Int = 3,
        elementProvider: (() -> E)? = null,
        previous: PersistentList<E>? = null,
        next: PersistentList<E>? = null
    ) : this(BTree(max(initialCapacity, size), factor, elementProvider), size, previous = previous, next = next)

    override fun tryToUndo() = previous

    override fun tryToRedo() = next

    companion object {
        fun <E> fromList(collection: Collection<E>): BTreeArrayList<E> {
            val empty = BTreeArrayList<E>()
            val tree = empty.addAll(collection) as BTreeArrayList<E>
            empty.next = null
            tree.previous = null
            return tree
        }
    }

    /**
     * O(log b (size))
     */
    override fun get(index: Int): E {
        if (index < 0 || index >= size) throw ArrayIndexOutOfBoundsException()

        return tree.atIndex(index)
    }

    override fun add(element: E, index: Int): PersistentList<E> {
        if (index < 0 || index > size) throw ArrayIndexOutOfBoundsException()

        var tree = this.tree
        for (i in size - 1 downTo index) {
            tree = tree.updateAt(i + 1, tree.atIndex(i)!!)
        }
        tree = tree.updateAt(index, element)

        val newList = BTreeArrayList(tree, size + 1, this)
        next = newList
        return newList
    }

    override fun addAll(elements: Collection<E>): PersistentList<E> {
        var i = size
        var tree = this.tree
        for (e in elements) {
            tree = tree.updateAt(i++, e)
        }

        val newList = BTreeArrayList(tree, size + elements.size, this)
        next = newList
        return newList
    }

    override fun remove(index: Int): PersistentList<E> {
        if (index < 0 || index >= size) throw ArrayIndexOutOfBoundsException()

        var tree = this.tree
        for (i in index until size - 1) {
            tree = tree.updateAt(i, tree.atIndex(i + 1))
        }

        val newList = BTreeArrayList(tree, size - 1, this)
        next = newList
        return newList
    }

    /**
     * O(b * log b (size))
     */
    override fun set(element: E, index: Int): PersistentList<E> {
        if (index < 0 || index >= size) throw ArrayIndexOutOfBoundsException()

        val updated = tree.updateAt(index, element)
        if (updated === tree) return this
        val newList = BTreeArrayList(updated, size, this)
        next = newList
        return newList
    }

    override fun iterator(): Iterator<E> = BTAIterator()

    override fun listIterator(index: Int): ListIterator<E> = BTAListIterator(index)

    override fun subList(fromIndex: Int, toIndex: Int): List<E> = BTASubList(this, fromIndex, toIndex)

    private open inner class BTAIterator(
        protected var index: Int = 0
    ) : Iterator<E> {
        init {
            if (index < 0 || index >= this@BTreeArrayList.size) throw ArrayIndexOutOfBoundsException()
        }

        override fun hasNext() = index < size

        override fun next(): E {
            if (!hasNext()) throw NoSuchElementException()
            return get(index++)
        }
    }

    private inner class BTAListIterator(index: Int = 0) : BTAIterator(index), ListIterator<E> {
        override fun hasPrevious() = index > 0

        override fun nextIndex() = index + 1

        override fun previous(): E {
            if (!hasPrevious()) throw NoSuchElementException()
            return get(index--)
        }

        override fun previousIndex() = index - 1

    }

    private inner class BTASubList(private val list: BTreeArrayList<E>, private val fromIndex: Int, toIndex: Int) :
        List<E>, AbstractCollection<E>() {

        init {
            if (fromIndex < 0 || toIndex > list.size) {
                throw IndexOutOfBoundsException("fromIndex: $fromIndex, toIndex: $toIndex, size: ${list.size}")
            }
            if (fromIndex > toIndex) {
                throw IllegalArgumentException("fromIndex: $fromIndex > toIndex: $toIndex")
            }
        }

        override fun get(index: Int): E {
            return list[index + fromIndex]
        }

        override val size = toIndex - fromIndex

        override fun indexOf(element: E) = indexOfFirst { it == element }

        override fun lastIndexOf(element: E) = indexOfLast { it == element }

        override fun listIterator() = listIterator(0)

        override fun iterator(): Iterator<E> = object : Iterator<E> {
            var cursor = 0

            override fun hasNext() = cursor < this@BTASubList.size

            override fun next() = this@BTASubList[cursor++]

        }

        override fun listIterator(index: Int) = object : ListIterator<E> {
            var cursor = index

            override fun hasNext() = cursor < this@BTASubList.size

            override fun next() = this@BTASubList[cursor++]

            override fun hasPrevious() = cursor > 0

            override fun nextIndex() = cursor + 1

            override fun previous() = this@BTASubList[cursor--]

            override fun previousIndex() = cursor - 1
        }

        override fun subList(fromIndex: Int, toIndex: Int) =
            list.subList(this.fromIndex + fromIndex, this.fromIndex + toIndex)
    }
}