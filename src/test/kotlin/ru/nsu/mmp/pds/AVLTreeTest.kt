package ru.nsu.mmp.pds

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.nsu.mmp.pds.map.*

class AVLTreeTest {

    @Test
    fun `Left rotation`() {
        val a = Node(3, "гвоздика")
        val b = Node(8, "гиацинт")
        val p = Node(1, "мак")
        val q = Node(6, "ромашка")
        val r = Node(10, "роза")
        b.left = q
        b.right = r
        fixHeight(b)
        a.left = p
        a.right = b
        fixHeight(a)
        val rotateLeftResult = rotateLeft(a)
        assertEquals(b.key, rotateLeftResult?.key)
        assertEquals(a.key, rotateLeftResult?.left?.key)
    }

    @Test
    fun `Right rotation`() {
        val a = Node(3, "гвоздика")
        val b = Node(8, "гиацинт")
        val p = Node(1, "мак")
        val q = Node(6, "ромашка")
        val r = Node(10, "роза")
        a.left = p
        a.right = q
        fixHeight(a)
        b.left = a
        b.right = r
        val rotateRightResult = rotateRight(b)
        assertEquals(a.key, rotateRightResult?.key)
        assertEquals(b.key, rotateRightResult?.right?.key)
    }

    @Test
    fun `Left big rotation`() {
        val a = Node(3, "гвоздика")
        val b = Node(8, "гиацинт")
        val p = Node(1, "мак")
        val c = Node(6, "ромашка")
        val r = Node(7, "роза")
        val s = Node(10, "роза")
        val q = Node(4, "роза")
        c.left = q
        c.right = r
        fixHeight(c)
        b.left = c
        b.right = s
        fixHeight(c)
        a.left = p
        a.right = b
        fixHeight(a)

        val rotateLeftResult = rotateBigLeft(a)
        assertEquals(c.key, rotateLeftResult?.key)
        assertEquals(a.key, rotateLeftResult?.left?.key)
        assertEquals(b.key, rotateLeftResult?.right?.key)
    }

    @Test
    fun `Right big rotation`() {
        val b = Node(3, "гвоздика")
        val a = Node(8, "гиацинт")
        val l = Node(1, "мак")
        val c = Node(6, "ромашка")
        val n = Node(7, "роза")
        val r = Node(10, "лилия")
        val m = Node(4, "нарцисс")
        c.left = m
        c.right = n
        fixHeight(c)
        b.left = l
        b.right = c
        fixHeight(b)
        a.left = b
        a.right = r
        fixHeight(a)

        val rotateRightBigResult = rotateBigRight(a)
        assertEquals(c.key, rotateRightBigResult?.key)
        assertEquals(b.key, rotateRightBigResult?.left?.key)
        assertEquals(a.key, rotateRightBigResult?.right?.key)
    }

    @Test
    fun `Add node`() {
        val headKey = 3
        val leftKey = 1
        val rightKey = 8
        val resultNode = addNode(
            addNode(
                addNode(
                    null,
                    headKey, "гвоздика"
                ),
                rightKey, "гиацинт"
            ),
            leftKey, "мак"
        )
        assertEquals(headKey, resultNode?.key)
        assertEquals(leftKey, resultNode?.left?.key)
        assertEquals(rightKey, resultNode?.right?.key)
    }

    @Test
    fun `Add existed node`() {
        val headKey = 3
        val leftKey = 1
        val rightKey = 8
        val node = addNode(
            addNode(
                addNode(
                    null,
                    headKey, "гвоздика"
                ),
                rightKey, "гиацинт"
            ),
            leftKey, "мак"
        )
        val resultNode = addNode(node, 3, "хризантема")
        assertEquals(headKey, node?.key)
        assertEquals("гвоздика", node?.value)
        assertEquals(leftKey, node?.left?.key)
        assertEquals(rightKey, node?.right?.key)
        assertEquals("хризантема", resultNode?.value)
    }

    @Test
    fun `Add and balance test`() {
        val headKey = 6
        val leftKey = 3
        val rightKey = 8
        val resultNode = addNode(
            addNode(
                addNode(
                    addNode(
                        addNode(
                            addNode(
                                addNode(
                                    null,
                                    rightKey, "гвоздика"
                                ),
                                headKey, "гиацинт"
                            ),
                            leftKey, "мак"
                        ),
                        1, "мак"
                    ),
                    4, "нарцисс"
                ),
                10, "лилия"
            ),
            7, "роза"
        )
        assertEquals(headKey, resultNode?.key)
        assertEquals(leftKey, resultNode?.left?.key)
        assertEquals(rightKey, resultNode?.right?.key)
    }

    @Test
    fun `Remove minimum node`() {
        val a = Node(3, "гвоздика")
        val b = Node(8, "гиацинт")
        val p = Node(1, "мак")
        val q = Node(6, "ромашка")
        val r = Node(10, "роза")
        b.left = q
        b.right = r
        fixHeight(b)
        a.left = p
        a.right = b
        fixHeight(a)

        removeMin(a)?.let { removeMinResult ->
            assertEquals(a.key, findMin(removeMinResult).key)
            removeMin(removeMinResult)?.let {
                assertEquals(q.key, findMin(it).key)
                assertEquals(a.key, findMin(removeMinResult).key)
            }
        }
    }

    @Test
    fun `Remove node`() {
        val a = Node(3, "гвоздика")
        val b = Node(8, "гиацинт")
        val p = Node(1, "мак")
        val q = Node(6, "ромашка")
        val r = Node(10, "роза")
        b.left = q
        b.right = r
        fixHeight(b)
        a.left = p
        a.right = b
        fixHeight(a)

        val removeResult = removeNode(a, b.key)
        assertEquals(r.key, removeResult?.right?.key)
        assertEquals(b.key, a.right?.key)
    }

    @Test
    fun `Remove and balance node`() {
        val a = Node(3, "гвоздика")
        val b = Node(8, "гиацинт")
        val p = Node(1, "мак")
        val q = Node(6, "ромашка")
        val r = Node(10, "роза")
        b.left = q
        b.right = r
        fixHeight(b)
        a.left = p
        a.right = b
        fixHeight(a)

        val removeResult = removeNode(a, b.key)
        val addResult = addNode(removeResult, 4, "хризантема")
        assertEquals(r.key, removeResult?.right?.key)
        assertEquals(b.key, a.right?.key)
        assertEquals(q.key, addResult?.key)
    }

    @Test
    fun `Find node by key`() {
        val a = Node(3, "гвоздика")
        val b = Node(8, "гиацинт")
        val p = Node(1, "мак")
        val q = Node(6, "ромашка")
        val r = Node(10, "роза")
        b.left = q
        b.right = r
        fixHeight(b)
        a.left = p
        a.right = b
        fixHeight(a)

        val findResult = findNode(a, r.key)
        assertEquals(r, findResult)
    }

    @Test
    fun `Traverse tree`() {
        val a = Node(3, "гвоздика")
        val b = Node(8, "гиацинт")
        val p = Node(1, "мак")
        val q = Node(6, "ромашка")
        val r = Node(10, "роза")
        val nodeCount = 5
        b.left = q
        b.right = r
        fixHeight(b)
        a.left = p
        a.right = b
        fixHeight(a)

        val list = ArrayList<Pair<Int, String>>()
        traverse(a) { node ->
            list.add(Pair(node.key, node.value))
            println("(${node.key}, ${node.value})")
        }
        assertEquals(nodeCount, list.size)
    }
}