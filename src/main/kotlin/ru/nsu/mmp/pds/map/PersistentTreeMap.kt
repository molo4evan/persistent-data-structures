package ru.nsu.mmp.pds.map

class PersistentTreeMap<K, V> : PersistentMap<K, V>() {
    override val entries: Set<Map.Entry<K, V>>
        get() = TODO("Not yet implemented")
    override val keys: Set<K>
        get() = TODO("Not yet implemented")
    override val size: Int
        get() = TODO("Not yet implemented")
    override val values: Collection<V>
        get() = TODO("Not yet implemented")

    override fun get(key: K): V? {
        TODO("Not yet implemented")
    }

    override fun tryToUndo(): PersistentMap<K, V>? {
        TODO("Not yet implemented")
    }

    override fun tryToRedo(): PersistentMap<K, V>? {
        TODO("Not yet implemented")
    }

    override fun put(key: K, value: V): PersistentMap<K, V> {
        TODO("Not yet implemented")
    }

    override fun remove(key: K): PersistentMap<K, V> {
        TODO("Not yet implemented")
    }

    override fun putAll(from: Map<out K, V>): PersistentMap<K, V> {
        TODO("Not yet implemented")
    }

    override fun clear(): PersistentMap<K, V> {
        TODO("Not yet implemented")
    }
}