package ru.nsu.mmp.pds

/**
 * Implementations of update functions must update previous and next versions as needed.
 */
abstract class PersistentMap<K, V> : Map<K, V> {

    protected var previousVersion: PersistentMap<K, V>? = null

    protected var nextVersion: PersistentMap<K, V>? = null

    fun undo() = previousVersion

    fun redo() = nextVersion

    override fun isEmpty() = size == 0

    override fun containsKey(key: K) = entries.firstOrNull { it.key == key } != null

    override fun containsValue(value: V) = entries.any { it.value == value }

    abstract fun put(key: K, value: V): PersistentMap<K, V>

    abstract fun remove(key: K): PersistentMap<K, V>

    abstract fun putAll(from: Map<out K, V>): PersistentMap<K, V>

    abstract fun clear(): PersistentMap<K, V>
}