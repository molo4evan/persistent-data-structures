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

fun <K, V> fixHeight(node: Node<K, V>?) {                               //node changing
    val leftHeight = node?.left?.height ?: 0
    val rightHeight = node?.right?.height ?: 0
    node?.height = if (leftHeight > rightHeight) {
        leftHeight
    } else {
        rightHeight
    } + 1
}

fun <K, V> rotateLeft(a: Node<K, V>?): Node<K, V>? {                           //node changing
    val newA = a?.copy()
    val newB = a?.right?.copy()
    newA?.right = newB?.left
    newB?.left = newA
    fixHeight(newA)
    if (newB != null) {
        fixHeight(newB)
    }
    return newB
}

fun <K, V> rotateRight(b: Node<K, V>?): Node<K, V>? {                          //node changing
    val newB = b?.copy()
    val newA = b?.left?.copy()
    newB?.left = newA?.right
    newA?.right = newB
    fixHeight(newB)
    if (newA != null) {
        fixHeight(newA)
    }
    return newA
}

fun <K, V> rotateBigLeft(a: Node<K, V>): Node<K, V>? {
    val newA = a.copy()
    newA.right = rotateRight(newA.right)
    return rotateLeft(newA)
}

fun <K, V> rotateBigRight(a: Node<K, V>): Node<K, V>? {
    val newA = a.copy()
    newA.left = rotateLeft(newA.left)
    return rotateRight(newA)
}

private fun <K, V> balance(node: Node<K, V>): Node<K, V>? {
    //fixHeight(node)
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

fun <K, V> addNode(head: Node<K, V>?, key: K, value: V): Node<K, V>? {
    val node = Node(key, value)
    if (head == null) {
        return node
    }
    val k = key as Comparable<K>
    when {
        k < head.key -> {
            node.key = head.key
            node.value = head.value
            node.left = addNode(head.left, key, value)
            node.right = head.right
            fixHeight(node)
        }
        k > head.key -> {
            node.key = head.key
            node.value = head.value
            node.left = head.left
            node.right = addNode(head.right, key, value)
            fixHeight(node)
        }
        else -> {
            node.value = value
        }
    }
    return balance(node)
}

fun <K, V> findMin(head: Node<K, V>): Node<K, V> {
    val leftBranch = head.left
    return if (leftBranch != null) {
        findMin(leftBranch)
    } else {
        head
    }
}

fun <K, V> removeMin(head: Node<K, V>): Node<K, V>? {
    val leftBranch = head.left
    return if (leftBranch == null) {
        head.right
    } else {
        val node = Node(head.key, head.value)
        node.left = removeMin(leftBranch)
        balance(node)
    }
}

fun <K, V> removeNode(head: Node<K, V>?, key: K): Node<K, V>? {
    if (head == null) {
        return null
    }
    val k = key as Comparable<K>
    val node = Node(head.key, head.value)
    when {
        k < head.key -> {
            node.left = removeNode(head.left, key)
            node.right = head.right
            fixHeight(node)
        }
        k > head.key -> {
            node.left = head.left
            node.right = removeNode(head.right, key)
            fixHeight(node)
        }
        else -> {
            val leftNodeBranch = head.left
            val rightNodeBranch = head.right ?: return leftNodeBranch
            val min = findMin(rightNodeBranch).copy()
            min.right = removeMin(rightNodeBranch)
            min.left = leftNodeBranch
            return balance(min)
        }
    }
    return balance(node)
}

fun <K, V> findNode(head: Node<K, V>?, key: K): Node<K, V>? {
    if (head == null) {
        return null
    }
    val k = key as Comparable<K>
    return when {
        k < head.key -> {
            findNode(head.left, key)
        }
        k > head.key -> {
            findNode(head.right, key)
        }
        else -> {
            head
        }
    }
}

fun <K, V> traverse(head: Node<K, V>, f : (node: Node<K, V>) -> Unit) {
    val leftBranch = head.left
    val rightBranch = head.right
    if(leftBranch != null) {
        traverse(leftBranch, f)
    }
    f(head)
    if(rightBranch != null) {
        traverse(rightBranch, f)
    }
}