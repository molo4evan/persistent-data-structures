package ru.nsu.mmp.pds.map

class PersistentTreeMap<K, V> private constructor(
    private var root: Node<K, V>?,
    private var _size: Int,
    private var previous: PersistentTreeMap<K, V>? = null,
    private var next: PersistentTreeMap<K, V>? = null
) : PersistentMap<K, V>() {

    constructor() : this(null, 0)

    override val entries: Set<Map.Entry<K, V>>
        get() = entries()
    override val keys: Set<K>
        get() = keys()
    override val size: Int = _size
    override val values: Collection<V>
        get() = values()

    override fun get(key: K): V? {
        return findNode(root, key)?.value
    }

    override fun tryToUndo(): PersistentMap<K, V>? = previous

    override fun tryToRedo(): PersistentMap<K, V>? = next

    override fun put(key: K, value: V): PersistentMap<K, V> {
        val updated = PersistentTreeMap(addNode(root, key, value), ++_size, this)
        next = updated
        return updated
    }

    override fun remove(key: K): PersistentMap<K, V> {
        val updated = PersistentTreeMap(removeNode(root, key), --_size, this)
        next = updated
        return updated
    }

    override fun putAll(from: Map<out K, V>): PersistentMap<K, V> {
        var resultTree = root
        from.forEach { (key, value) ->
            resultTree = addNode(resultTree, key, value)
        }
        val updated = PersistentTreeMap(resultTree, _size + from.size, this)
        next = updated
        return updated
    }

    override fun clear(): PersistentMap<K, V> {
        return PersistentTreeMap(null, 0, previous, next)
    }

    private fun entries(): Set<Map.Entry<K, V>> {
        val set = mutableSetOf<Map.Entry<K, V>>()
        val head = root ?: return set
        traverse(head) { node ->
            set.add(Entry(node.key, node.value))
        }
        return set
    }

    private fun keys(): Set<K> {
        val set = mutableSetOf<K>()
        val head = root ?: return set
        traverse(head) { node ->
            set.add(node.key)
        }
        return set
    }

    private fun values(): Set<V> {
        val set = mutableSetOf<V>()
        val head = root ?: return set
        traverse(head) { node ->
            set.add(node.value)
        }
        return set
    }

    data class Entry<K, V>(override val key: K,
                            override val value: V)
        : Map.Entry<K, V>
}