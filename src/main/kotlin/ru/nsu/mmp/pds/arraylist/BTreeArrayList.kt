package ru.nsu.mmp.pds.arraylist

open class BTreeArrayList<E: Any?> private constructor(
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
    ) : this(BTree(initialCapacity, factor, elementProvider), size, previous = previous, next = next)

    override fun tryToUndo() = previous

    override fun tryToRedo() = next

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
        val newList = BTreeArrayList(updated, size, this)
        next = newList
        return newList
    }

    override fun iterator(): Iterator<E> = BTAIterator()

    override fun listIterator(index: Int): ListIterator<E> = BTAListIterator()

    override fun subList(fromIndex: Int, toIndex: Int): List<E> = BTASubList(this, fromIndex, toIndex)

    private open inner class BTAIterator : Iterator<E> {
        protected var index = 0

        override fun hasNext() = index < size

        override fun next(): E {
            if (!hasNext()) throw NoSuchElementException()
            return get(index++)
        }
    }

    private inner class BTAListIterator : BTAIterator(), ListIterator<E> {
        override fun hasPrevious() = index > 0

        override fun nextIndex() = index + 1

        override fun previous(): E {
            if (!hasPrevious()) throw NoSuchElementException()
            return get(index--)
        }

        override fun previousIndex() = index - 1

    }

    private inner class BTASubList(private val list: BTreeArrayList<E>, private val fromIndex: Int, toIndex: Int) :
        BTreeArrayList<E>(tree, toIndex - fromIndex) {

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

        override fun remove(index: Int): PersistentList<E> {
            return list.remove(index + fromIndex)
        }

        override fun set(element: E, index: Int): PersistentList<E> {
            return list.set(element, index + fromIndex)
        }

        override fun add(element: E, index: Int): PersistentList<E> {
            return list.add(element, index + fromIndex)
        }
    }
}