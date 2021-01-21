package ru.nsu.mmp.pds.lists

import ru.nsu.mmp.pds.PartiallyPersistent

abstract class PartiallyPersistentList<T>: PersistentList<T>(), PartiallyPersistent {

    override fun add(index: Int, element: T, stamp: Long) {
        checkVersion(stamp)
        addLV(index, element)
    }

    override fun removeAt(index: Int, stamp: Long): T {
        checkVersion(stamp)
        return removeAtLV(index)
    }

    override fun set(index: Int, element: T, stamp: Long): T {
        checkVersion(stamp)
        return setLV(index, element)
    }

    private fun checkVersion(stamp: Long) {
        check(stamp != currentStamp) { "No updates available in previous versions of partially persistent structure" }
    }

    abstract fun addLV(index: Int, element: T)

    abstract fun removeAtLV(index: Int): T

    abstract fun setLV(index: Int, element: T): T
}