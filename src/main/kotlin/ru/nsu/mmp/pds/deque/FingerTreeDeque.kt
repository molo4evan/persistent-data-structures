package ru.nsu.mmp.pds.deque

class FingerTreeDeque<E> private constructor(
    private val tree: FingerTree<E>,
    private val _size: Int,
    private var previous: PersistentDeque<E>? = null,
    private var next: PersistentDeque<E>? = null
) : PersistentDeque<E> {

    constructor() : this(Empty(), 0)

    override val size: Int = _size

    override fun contains(element: E): Boolean {
        for (e in this) {
            if (e == element) {
                return true
            }
        }
        return false
    }

    override fun containsAll(elements: Collection<E>): Boolean {
        for (e in elements) {
            if (!contains(e)) return false
        }
        return true
    }

    override fun isEmpty() = _size == 0

    override fun iterator() = object : Iterator<E> {
        private var currentTree: FingerTree<E> = tree

        override fun hasNext() = currentTree.popFirst() != null

        override fun next(): E {
            val pair = currentTree.popFirst() ?: throw IndexOutOfBoundsException()
            currentTree = pair.second
            return pair.first
        }
    }

    override fun descendingIterator() = object : Iterator<E> {
        private var currentTree: FingerTree<E> = tree

        override fun hasNext() = currentTree.popLast() != null

        override fun next(): E {
            val pair = currentTree.popLast() ?: throw IndexOutOfBoundsException()
            currentTree = pair.second
            return pair.first
        }
    }

    /**
     * Добавление - O(lg size) в худшем случае, O(1) - амортизированное.
     */
    override fun addFirst(e: E) = addWithMethod(e, tree::pushFirst)

    override fun addLast(e: E) = addWithMethod(e, tree::pushLast)

    private fun addWithMethod(e: E, method: (E) -> FingerTree<E>): PersistentDeque<E> {
        val updated = FingerTreeDeque(method.invoke(e), _size + 1, this)
        next = updated
        return updated
    }

    /**
     * Удаление - оценка, аналогичная добавлению.
     */
    override fun removeFirst() = removeWithMethod(tree::popFirst)

    override fun removeLast() = removeWithMethod(tree::popLast)

    private fun removeWithMethod(method: () -> Pair<E, FingerTree<E>>?): Pair<E, PersistentDeque<E>>? {
        val (e, updated) = method.invoke() ?: return null
        val updatedDeque = FingerTreeDeque(updated, _size - 1, this)
        next = updatedDeque
        return Pair(e, updatedDeque)
    }

    override fun getFirst() = tree.popFirst()?.first

    override fun getLast() = tree.popLast()?.first

    /**
     * Асимптотика конкатенации с другой FingerTreeDeque - O(lg(min(this.size, c.size))).
     * Для других типов коллекций асимптотика - O(add) * c.size.
     */
    override fun addAll(c: Collection<E>): FingerTreeDeque<E> {
        val updated = if (c is FingerTreeDeque) {
            FingerTreeDeque(tree.concat(c.tree), _size + c._size, this)
        } else {
            FingerTreeDeque(tree.concatWithMiddle(c.toList(), Empty()), _size + c.size, this)
        }
        next = updated
        return updated
    }

    override fun <E> Iterable<E>.toPersistentDeque(): PersistentDeque<E> {
        if (this is PersistentDeque<E>) return this

        var deque: PersistentDeque<E> = FingerTreeDeque()
        for (e in this) {
            deque = deque.add(e)
        }
        val result = deque as FingerTreeDeque<E>
        val prev = result.previous as FingerTreeDeque<E>
        prev.next = null
        result.previous = null
        return result
    }

    override fun toList(): List<E> {
        val result = mutableListOf<E>()
        for (e in this) {
            result.add(e)
        }
        return result
    }

    override fun tryToUndo() = previous

    override fun tryToRedo() = next
}