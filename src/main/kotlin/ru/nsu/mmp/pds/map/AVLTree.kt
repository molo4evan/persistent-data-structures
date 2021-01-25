package ru.nsu.mmp.pds.map

class AVLTree<K, V> {
    data class Node<K, V>(
        override val key: K,
        override var value: V
    ) : Map.Entry<K, V> {
        var height: Int = 0
        var left: Node<K, V>? = null
        var right: Node<K, V>? = null
    }

    private fun countBalanceFactor(node: Node<K, V>?): Int {
        val leftHeight = node?.left?.height ?: 0
        val rightHeight = node?.right?.height ?: 0
        return rightHeight - leftHeight
    }

    private fun fixHeight(node: Node<K, V>?) {                               //node changing
        val leftHeight = node?.left?.height ?: 0
        val rightHeight = node?.right?.height ?: 0
        node?.height = if (leftHeight > rightHeight) {
            leftHeight
        } else {
            rightHeight
        } + 1
    }

    private fun rotateLeft(a: Node<K, V>?): Node<K, V>? {                           //node changing
        val b = a?.right
        a?.right = b?.left
        b?.left = a
        fixHeight(a)
        if (b != null) {
            fixHeight(b)
        }
        return b
    }

    private fun rotateRight(b: Node<K, V>?): Node<K, V>? {                          //node changing
        val a = b?.left
        b?.left = a?.right
        a?.right = b
        return a
    }

    private fun rotateBigLeft(a: Node<K, V>): Node<K, V>? {
        a.right = rotateRight(a.right)
        return rotateLeft(a)
    }

    private fun rotateBigRight(a: Node<K, V>): Node<K, V>? {
        a.left = rotateLeft(a.left)
        return rotateRight(a)
    }

    private fun balance(node: Node<K, V>): Node<K, V>? {
        fixHeight(node)
        if (countBalanceFactor(node) == 2) {
            val rightBalanceFactor = countBalanceFactor(node.right)
            return if (rightBalanceFactor >= 0) {
                rotateLeft(node)
            } else {
                rotateBigLeft(node)
            }
        } else {
            if (countBalanceFactor(node) == -2) {
                val leftBalanceFactor = countBalanceFactor(node.left)
                return if (leftBalanceFactor <= 0) {
                    rotateRight(node)
                } else {
                    rotateBigRight(node)
                }
            }
        }
        return node
    }

    fun add(head: Node<K, V>?, key: K, value: V): Node<K, V>? {
        if (head == null) {
            return Node(key, value)
        }
        val k = key as Comparable<K>
        when {
            k < head.key -> {
                head.left = add(head.left, key, value)
            }
            k > head.key -> {
                head.right = add(head.right, key, value)
            }
            else -> {
                head.value = value
            }
        }
        return balance(head)
    }

    private fun findMin(head: Node<K, V>): Node<K, V> {
        val leftBranch = head.left
        return if (leftBranch != null) {
            findMin(leftBranch)
        } else {
            head
        }
    }

    private fun removeMin(head: Node<K, V>): Node<K, V>? {
        val leftBranch = head.left
        return if (leftBranch == null) {
            head.right
        } else {
            head.left = removeMin(leftBranch)
            balance(head)
        }
    }

    fun remove(head: Node<K, V>?, key: K): Node<K, V>? {
        if (head == null) {
            return null
        }
        val k = key as Comparable<K>
        when {
            k < head.key -> {
                head.left = remove(head.left, key)
            }
            k > head.key -> {
                head.right = remove(head.right, key)
            }
            else -> {
                val leftNodeBranch = head.left
                val rightNodeBranch = head.right ?: return leftNodeBranch
                val min = findMin(rightNodeBranch)
                min.right = removeMin(rightNodeBranch)
                min.left = leftNodeBranch
                return balance(min)
            }
        }
        return balance(head)
    }
}
