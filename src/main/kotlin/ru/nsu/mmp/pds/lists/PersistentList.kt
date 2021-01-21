package ru.nsu.mmp.pds.lists

import ru.nsu.mmp.pds.PersistentDataStructure
import java.util.*
import kotlin.NoSuchElementException
import kotlin.collections.RandomAccess

abstract class PersistentList<T> : PersistentDataStructure(), MutableList<T> {

    //region Defaults of MutableList
    override val size: Int
        get() = size(currentStamp)

    override fun contains(element: T) = contains(element, currentStamp)

    override fun containsAll(elements: Collection<T>) = containsAll(elements, currentStamp)

    override fun get(index: Int) = get(index, currentStamp)

    override fun indexOf(element: T) = indexOf(element, currentStamp)

    override fun isEmpty() = isEmpty(currentStamp)

    override fun iterator() = iterator(currentStamp)

    override fun lastIndexOf(element: T) = lastIndexOf(element, currentStamp)

    override fun add(element: T) = add(element, currentStamp)

    override fun add(index: Int, element: T) = add(index, element, currentStamp)

    override fun addAll(index: Int, elements: Collection<T>) = addAll(index, elements, currentStamp)

    override fun addAll(elements: Collection<T>) = addAll(elements, currentStamp)

    override fun clear() = clear(currentStamp)

    override fun listIterator() = listIterator(currentStamp)

    override fun listIterator(index: Int) = listIterator(index, currentStamp)

    override fun remove(element: T) = remove(element, currentStamp)

    override fun removeAll(elements: Collection<T>) = removeAll(elements, currentStamp)

    override fun removeAt(index: Int) = removeAt(index, currentStamp)

    override fun retainAll(elements: Collection<T>) = retainAll(elements, currentStamp)

    override fun set(index: Int, element: T) = set(index, element, currentStamp)

    override fun subList(fromIndex: Int, toIndex: Int) = subList(fromIndex, toIndex, currentStamp)
    //endregion

    //region Default stamp methods
    open fun indexOf(element: T, stamp: Long): Int {
        val iterator = listIterator(stamp)
        while (iterator.hasNext()) {
            if (iterator.next() == element) {
                return iterator.previousIndex()
            }
        }
        return -1
    }

    open fun lastIndexOf(element: T, stamp: Long): Int {
        val iterator = listIterator(size(stamp), stamp)
        while (iterator.hasPrevious()) {
            if (iterator.previous() == element) {
                return iterator.nextIndex()
            }
        }
        return -1
    }

    open fun add(element: T, stamp: Long): Boolean {
        add(size(stamp), element, stamp)
        return true
    }

    open fun listIterator(stamp: Long): MutableListIterator<T> {
        return listIterator(0, stamp)
    }

    open fun addAll(elements: Collection<T>, stamp: Long): Boolean {
        return addAll(size(stamp), elements, stamp)
    }

    open fun containsAll(elements: Collection<T>, stamp: Long): Boolean {
        for (e in elements) {
            if (!contains(e, stamp)) {
                return false
            }
        }
        return true
    }

    open fun isEmpty(stamp: Long): Boolean {
        return size(stamp) == 0
    }

    open fun removeAll(elements: Collection<T>, stamp: Long): Boolean {
        var modified = false
        for (e in elements) {
            if (remove(e, stamp)) {
                modified = true
            }
        }
        return modified
    }

    open fun retainAll(elements: Collection<T>, stamp: Long): Boolean {
        val it = listIterator(stamp)
        var modified = false
        for (i in 0 until size(stamp)) {
            val e = it.next()
            if (!elements.contains(e)) {
                it.remove()
                modified = true
            }
        }
        return modified
    }

    open fun remove(element: T, stamp: Long): Boolean {
        val index = indexOf(element, stamp)
        return if (index < 0) {
            false
        } else {
            removeAt(index, stamp)
            true
        }
    }

    open fun clear(stamp: Long) {
        val it = listIterator(stamp)
        for (i in 0 until size(stamp)) {
            it.next()
            it.remove()
        }
    }

    open fun addAll(index: Int, elements: Collection<T>, stamp: Long): Boolean {
        val size = size(stamp)
        if (index < 0 || index > size)
            throw IndexOutOfBoundsException("Index: $index, Size: $size")

        var modified = false
        var i = index
        for (e in elements) {
            add(i++, e)
            modified = true
        }
        return modified
    }

    open fun iterator(stamp: Long): MutableIterator<T> = PLIterator(stamp)

    open fun listIterator(index: Int, stamp: Long): MutableListIterator<T> = PLListIterator(index, stamp)

    open fun subList(fromIndex: Int, toIndex: Int, stamp: Long): MutableList<T> {
        subListRangeCheck(fromIndex, toIndex, size(stamp))
        return if (this is RandomAccess) {
            RandomAccessPLSubList(this, fromIndex, toIndex)
        } else {
            PLSubList(this, fromIndex, toIndex)
        }
    }

    private open inner class PLIterator(protected val stamp: Long) : MutableIterator<T> {
        protected var cursor = 0

        protected var lastRet = -1

        override fun hasNext() = cursor != size(stamp)

        override fun next() = try {
            val i = cursor
            val next: T = get(i, stamp)
            lastRet = i
            cursor = i + 1
            next
        } catch (e: IndexOutOfBoundsException) {
            throw NoSuchElementException(e)
        }

        override fun remove() {
            check(lastRet >= 0)

            this@PersistentList.removeAt(lastRet, stamp)
            if (lastRet < cursor) cursor--
            lastRet = -1
        }
    }

    private inner class PLListIterator(index: Int, stamp: Long) : PLIterator(stamp), MutableListIterator<T> {
        init {
            cursor = index
        }

        override fun hasPrevious() = cursor != 0

        override fun nextIndex() = cursor

        override fun previous() = try {
            val i = cursor - 1
            val previous = get(i, stamp)
            cursor = i
            lastRet = cursor
            previous
        } catch (e: IndexOutOfBoundsException) {
            throw NoSuchElementException(e)
        }

        override fun previousIndex() = cursor - 1

        override fun add(element: T) {
            val i = cursor
            this@PersistentList.add(i, element, stamp)
            lastRet = -1
            cursor = i + 1
        }

        override fun set(element: T) {
            check(lastRet >= 0)

            this@PersistentList.set(lastRet, element, stamp)
        }
    }

    companion object {
        private open class PLSubList<T>(
            protected val root: PersistentList<T>,
            fromIndex: Int,
            toIndex: Int,
            protected val parent: PLSubList<T>? = null
        ) : PersistentList<T>() {
            protected val offset = fromIndex
            protected var listSize = toIndex - offset

            protected constructor(parent: PLSubList<T>, fromIndex: Int, toIndex: Int) :
                    this(parent.root, parent.offset + fromIndex, toIndex, parent)

            override fun size(stamp: Long) = listSize

            override fun contains(element: T, stamp: Long): Boolean {
                return if (!root.contains(element, stamp)) {
                    false
                } else {
                    val index = root.indexOf(element, stamp)
                    index >= offset && index < offset + listSize
                }
            }

            override fun get(index: Int, stamp: Long): T {
                Objects.checkIndex(index, listSize)
                return root.get(offset + index, stamp)
            }

            override fun add(index: Int, element: T, stamp: Long) {
                rangeCheckForAdd(index)

                root.add(offset + index, element)
                updateSize(1)
            }

            override fun removeAt(index: Int, stamp: Long): T {
                Objects.checkIndex(index, listSize)

                val result: T = root.removeAt(offset + index)
                updateSize(-1)
                return result
            }

            override fun set(index: Int, element: T, stamp: Long): T {
                Objects.checkIndex(index, listSize)
                return root.set(offset + index, element, stamp)
            }

            override fun subList(fromIndex: Int, toIndex: Int, stamp: Long): MutableList<T> {
                subListRangeCheck(fromIndex, toIndex, listSize)
                return PLSubList(this, fromIndex, toIndex)
            }

            override fun addAll(elements: Collection<T>, stamp: Long) = addAll(listSize, elements, stamp)

            override fun addAll(index: Int, elements: Collection<T>, stamp: Long): Boolean {
                rangeCheckForAdd(index)
                val collSize = elements.size
                if (collSize == 0) return false
                root.addAll(offset + index, elements, stamp)
                updateSize(collSize)
                return true
            }

            override fun iterator(stamp: Long) = listIterator(stamp)

            override fun listIterator(index: Int, stamp: Long): MutableListIterator<T> {
                rangeCheckForAdd(index)

                return object : MutableListIterator<T> {
                    private val i = root.listIterator(offset + index)

                    override fun hasPrevious() = previousIndex() >= 0

                    override fun nextIndex() = i.nextIndex() - offset

                    override fun previous(): T =
                        if (hasPrevious())
                            i.previous()
                        else throw NoSuchElementException()

                    override fun previousIndex() = i.previousIndex() - offset

                    override fun add(element: T) {
                        i.add(element)
                        updateSize(1)
                    }

                    override fun hasNext() = nextIndex() < listSize

                    override fun next(): T =
                        if (hasNext())
                            i.next()
                        else throw NoSuchElementException()

                    override fun remove() {
                        i.remove()
                        updateSize(-1)
                    }

                    override fun set(element: T) {
                        i.set(element)
                    }

                }
            }

            private fun updateSize(sizeChange: Int) {
                var slist: PLSubList<T>? = this
                while (slist != null) {
                    slist.listSize += sizeChange
                    slist = slist.parent
                }
            }

            private fun rangeCheckForAdd(index: Int) {
                if (index < 0 || index > listSize)
                    throw IndexOutOfBoundsException("Index: $index, Size: $listSize")
            }
        }

        private class RandomAccessPLSubList<T>(
            root: PersistentList<T>,
            fromIndex: Int,
            toIndex: Int,
            parent: RandomAccessPLSubList<T>? = null
        ) : PLSubList<T>(root, fromIndex, toIndex, parent), RandomAccess {

            constructor(parent: RandomAccessPLSubList<T>, fromIndex: Int, toIndex: Int) :
                    this(parent.root, parent.offset + fromIndex, toIndex, parent)

            override fun subList(fromIndex: Int, toIndex: Int, stamp: Long): MutableList<T> {
                subListRangeCheck(fromIndex, toIndex, listSize)
                return RandomAccessPLSubList(this, fromIndex, toIndex)
            }
        }

        fun subListRangeCheck(fromIndex: Int, toIndex: Int, size: Int) {
            if (fromIndex < 0) throw IndexOutOfBoundsException("fromIndex = $fromIndex")
            if (toIndex > size) throw IndexOutOfBoundsException("toIndex = $toIndex")
            require(fromIndex <= toIndex) { "fromIndex($fromIndex) > toIndex($toIndex)" }
        }
    }
    //endregion

    //region Abstract stamp methods
    abstract fun size(stamp: Long): Int

    abstract fun contains(element: T, stamp: Long): Boolean

    abstract fun get(index: Int, stamp: Long): T

    abstract fun add(index: Int, element: T, stamp: Long)

    abstract fun removeAt(index: Int, stamp: Long): T

    abstract fun set(index: Int, element: T, stamp: Long): T
    //endregion
}