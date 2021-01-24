package ru.nsu.mmp.pds.map

import ru.nsu.mmp.pds.PersistentDataStructure

/**
 * Implementations of update functions must update previous and next versions as needed.
 */
abstract class PersistentMap<K, V> : Map<K, V>, PersistentDataStructure<PersistentMap<K, V>> {

    override fun isEmpty() = size == 0

    override fun containsKey(key: K) = entries.firstOrNull { it.key == key } != null

    override fun containsValue(value: V) = entries.any { it.value == value }

    abstract fun put(key: K, value: V): PersistentMap<K, V>

    abstract fun remove(key: K): PersistentMap<K, V>

    abstract fun putAll(from: Map<out K, V>): PersistentMap<K, V>

    abstract fun clear(): PersistentMap<K, V>
}