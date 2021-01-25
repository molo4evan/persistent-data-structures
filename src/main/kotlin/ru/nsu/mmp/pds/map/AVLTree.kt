package ru.nsu.mmp.pds.map

data class Node<K, V>(
    override var key: K,
    override var value: V
) : Map.Entry<K, V> {
    var height: Int = 0
    var left: Node<K, V>? = null
    var right: Node<K, V>? = null

    fun copy() : Node<K, V>{
        val node = Node(key, value)
        node.left = left
        node.right = right
        node.height = height
        return node
    }
}

private fun <K, V> countBalanceFactor(node: Node<K, V>?): Int {
    val leftHeight = node?.left?.height ?: 0
    val rightHeight = node?.right?.height ?: 0
    return rightHeight - leftHeight
}

private fun <K, V> fixHeight(node: Node<K, V>?) {                               //node changing
    val leftHeight = node?.left?.height ?: 0
    val rightHeight = node?.right?.height ?: 0
    node?.height = if (leftHeight > rightHeight) {
        leftHeight
    } else {
        rightHeight
    } + 1
}

private fun <K, V> recountHeight(node: Node<K, V>?) : Int {                               //node changing
    val leftHeight = node?.left?.height ?: 0
    val rightHeight = node?.right?.height ?: 0
    return if (leftHeight > rightHeight) {
        leftHeight
    } else {
        rightHeight
    } + 1
}

private fun <K, V> rotateLeft(a: Node<K, V>?): Node<K, V>? {                           //node changing
    val newA = a?.copy()
    val newB = a?.right?.copy()
    val b = a?.right
    a?.right = b?.left
    b?.left = a
    fixHeight(a)
    if (b != null) {
        fixHeight(b)
    }
    return b
}

private fun <K, V> rotateRight(b: Node<K, V>?): Node<K, V>? {                          //node changing
    val a = b?.left
    b?.left = a?.right
    a?.right = b
    return a
}

private fun <K, V> rotateBigLeft(a: Node<K, V>): Node<K, V>? {
    a.right = rotateRight(a.right)
    return rotateLeft(a)
}

private fun <K, V> rotateBigRight(a: Node<K, V>): Node<K, V>? {
    a.left = rotateLeft(a.left)
    return rotateRight(a)
}

private fun <K, V> balance(node: Node<K, V>): Node<K, V>? {
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

fun <K, V> add(head: Node<K, V>?, key: K, value: V): Node<K, V>? {
    val node = Node(key, value)
    if (head == null) {
        return node
    }
    val k = key as Comparable<K>
    when {
        k < head.key -> {
            node.key = head.key
            node.value = head.value
            node.left = add(head.left, key, value)
            node.right = head.right
            node.height = recountHeight(node)
        }
        k > head.key -> {
            node.key = head.key
            node.value = head.value
            node.left = head.left
            node.right = add(head.right, key, value)
            node.height = recountHeight(node)
        }
        else -> {
            node.value = value
        }
    }
    return balance(node)
}

private fun <K, V> findMin(head: Node<K, V>): Node<K, V> {
    val leftBranch = head.left
    return if (leftBranch != null) {
        findMin(leftBranch)
    } else {
        head
    }
}

private fun <K, V> removeMin(head: Node<K, V>): Node<K, V>? {
    val leftBranch = head.left
    return if (leftBranch == null) {
        head.right
    } else {
        head.left = removeMin(leftBranch)
        balance(head)
    }
}

fun <K, V> remove(head: Node<K, V>?, key: K): Node<K, V>? {
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
