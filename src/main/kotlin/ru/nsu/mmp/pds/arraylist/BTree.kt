package ru.nsu.mmp.pds.arraylist

import ru.nsu.mmp.pds.arraylist.BTree.*
import java.util.stream.Collectors
import kotlin.math.pow

class BTree<E: Any?> private constructor(
    private val factor: Int,
    private var levels: Int,
    private var root: Node<E>?
) {
    private val nodeCapacity = 2.0.pow(factor).toInt()

    private val capacity: Int
        get() = nodeCapacity.toDouble().pow(levels + 1).toInt()

    @Suppress("UNCHECKED_CAST")
    constructor(size: Int, factor: Int = 3, elementProvider: (() -> E)? = null) : this(factor, 0, root = null) {
        val (levels, root) = build(0, size, Leaf(List(nodeCapacity) { elementProvider?.invoke() as E }, factor))
        this.levels = levels
        this.root = root
    }

    private fun build(layers: Int, size: Int, root: Node<E>): Pair<Int, Node<E>> {
        return if (size <= nodeCapacity shl (factor * layers)) {
            Pair(layers, root)
        } else {
            build(layers + 1, size, Branch(List(nodeCapacity) { root.copy() }, factor))
        }
    }

    private fun assertIndex(index: Int) {
        if (index < 0 || index >= capacity) {
            throw ArrayIndexOutOfBoundsException()
        }
    }

    fun atIndex(index: Int): E {
        assertIndex(index)
        return root!!.atIndex(index, levels)
    }

    fun updateAt(index: Int, value: E): BTree<E> {
        val tree = if (index >= capacity) {
            expand()
        } else this

        val updated = tree.root!!.updateAt(index, tree.levels, value)
        if (updated === this) return this
        return BTree(factor, tree.levels, updated)
    }

    private fun expand(): BTree<E> {
        val newRoot = Branch(List(nodeCapacity) { i ->
            if (i == 0) {
                root!!.copy()
            } else {
                val neighbour = BTree<E>(capacity, factor)
                val newBranch = neighbour.root!!
                neighbour.root = null
                newBranch
            }
        }, factor)

        return BTree(factor, levels + 1, newRoot)
    }

    abstract class Node<E>(
        open val factor: Int,
        val capacity: Int = 2.0.pow(factor).toInt()
    ) {
        protected val mask = capacity - 1

        protected fun assertChildrenSize(size: Int) {
            if (size > capacity) {
                throw IllegalArgumentException("Incorrect number of children for $capacity-tree: $size")
            }
        }

        protected fun assertIndex(index: Int) {
            if (index < 0 || index >= capacity) {
                throw IllegalArgumentException("Incorrect index $index for $capacity-tree node")
            }
        }

        abstract fun atIndex(index: Int, layer: Int): E

        abstract fun updateAt(index: Int, layer: Int, value: E): Node<E>

        abstract fun copy(): Node<E>
    }

    data class Branch<E>(
        val children: List<Node<E>>,
        override val factor: Int
    ) : Node<E>(factor) {
        init {
            assertChildrenSize(children.size)
        }

        constructor(factor: Int, vararg children: Node<E>) : this(children.asList(), factor)

        override fun atIndex(index: Int, layer: Int): E {
            if (layer < 1) throw IllegalArgumentException("Incorrect layers count in tree!")
            val childIndex = getChildIndex(index, layer)
            return children[childIndex].atIndex(index, layer - 1)
        }

        override fun updateAt(index: Int, layer: Int, value: E): Node<E> {
            if (layer < 1) throw IllegalArgumentException("Incorrect layers count in tree!")
            val childIndex = getChildIndex(index, layer)
            val child = children[childIndex].updateAt(index, layer - 1, value)
            if (children[childIndex] === child) return this
            val copy = children.toMutableList()
            copy[childIndex] = child
            return Branch(copy, factor)
        }

        private fun getChildIndex(index: Int, layer: Int) = (index shr factor * layer) and mask

        override fun copy() = Branch(
            children.stream()
                .map(Node<E>::copy)
                .collect(Collectors.toList()),
            factor
        )
    }

    data class Leaf<E>(
        val elements: List<E>,
        override val factor: Int
    ) : Node<E>(factor) {
        init {
            assertChildrenSize(elements.size)
        }

        constructor(factor: Int, vararg elements: E) : this(elements.asList(), factor)

        override fun atIndex(index: Int, layer: Int): E {
            if (layer != 0) throw IllegalArgumentException("Incorrect layers count in tree!")
            val localIndex = index and mask
            assertIndex(localIndex)
            return elements[localIndex]
        }

        override fun updateAt(index: Int, layer: Int, value: E): Node<E> {
            if (layer != 0) throw IllegalArgumentException("Incorrect layers count in tree!")
            val localIndex = index and mask
            assertIndex(localIndex)
            if (elements[localIndex] == value) return this
            val copy = elements.toMutableList()
            copy[localIndex] = value
            return Leaf(copy, factor)
        }

        override fun copy() = Leaf(elements.toMutableList(), factor)
    }
}