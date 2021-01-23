package ru.nsu.mmp.pds.deque

interface Node<E> {
    fun toList(): List<E>

    companion object {
        fun <E> nodes(elements: List<E>): List<Node<E>> {
            if (elements.size < 2) {
                throw IllegalArgumentException("Not enough elements for nodes")
            }
            val result = mutableListOf<Node<E>>()
            for (i in elements.indices step 2) {
                if (i + 1 >= elements.size) {
                    result.removeLast()
                    result.add(Branch3(elements[i - 2], elements[i - 1], elements[i]))
                } else {
                    result.add(Branch2(elements[i], elements[i + 1]))
                }
            }
            return result
        }
    }
}

open class Branch2<E>(
    val a: Node<E>,
    val b: Node<E>
) : Node<E> {
    constructor(a: E, b: E) : this(Leaf(a), Leaf(b))

    override fun toList() = a.toList() + b.toList()
}

class Branch3<E>(a: Node<E>, b: Node<E>, val c: Node<E>) : Branch2<E>(a, b) {
    constructor(a: E, b: E, c: E) : this(Leaf(a), Leaf(b), Leaf(c))

    override fun toList() = a.toList() + b.toList() + c.toList()
}

class Leaf<E>(val value: E) : Node<E> {
    override fun toList() = listOf(value)
}

interface Affix<E> {
    fun pushFirst(value: E): Affix<E>
    fun pushLast(value: E): Affix<E>
    fun popFirst(): Pair<E, Affix<E>>
    fun popLast(): Pair<E, Affix<E>>
    fun toList(): List<E>

    companion object {
        fun <E> fromList(list: List<E>): Affix<E> {
            return when (list.size) {
                1 -> One(list[0])
                2 -> Two(list[0], list[1])
                3 -> Three(list[0], list[1], list[2])
                4 -> Four(list[0], list[1], list[2], list[3])
                else -> throw IllegalArgumentException("Incorrect size of list")
            }
        }
    }
}

open class One<E>(val a: E) : Affix<E> {
    override fun pushFirst(value: E): Affix<E> = Two(value, a)
    override fun pushLast(value: E): Affix<E> = Two(a, value)

    override fun popFirst(): Pair<E, Affix<E>> {
        throw IllegalStateException("One cannot be destructed")
    }

    override fun popLast(): Pair<E, Affix<E>> {
        throw IllegalStateException("One cannot be destructed")
    }

    override fun toList() = listOf(a)
}

open class Two<E>(a: E, val b: E) : One<E>(a) {
    override fun pushFirst(value: E): Affix<E> = Three(value, a, b)
    override fun pushLast(value: E): Affix<E> = Three(a, b, value)
    override fun popFirst() = Pair<E, Affix<E>>(a, One(b))
    override fun popLast() = Pair<E, Affix<E>>(b, One(a))
    override fun toList() = listOf(a, b)
}

open class Three<E>(a: E, b: E, val c: E) : Two<E>(a, b) {
    override fun pushFirst(value: E): Affix<E> = Four(value, a, b, c)
    override fun pushLast(value: E): Affix<E> = Four(a, b, c, value)
    override fun popFirst() = Pair<E, Affix<E>>(a, Two(b, c))
    override fun popLast() = Pair<E, Affix<E>>(c, Two(a, b))
    override fun toList() = listOf(a, b, c)
}

class Four<E>(a: E, b: E, c: E, val d: E) : Three<E>(a, b, c) {
    override fun pushFirst(value: E): Affix<E> {
        throw IllegalStateException("Four cannot be expanded")
    }

    override fun pushLast(value: E): Affix<E> {
        throw IllegalStateException("Four cannot be expanded")
    }

    override fun popFirst() = Pair<E, Affix<E>>(a, Three(b, c, d))
    override fun popLast() = Pair<E, Affix<E>>(d, Three(a, b, c))
    override fun toList() = listOf(a, b, c, d)
}

interface FingerTree<E> {
    fun pushFirst(value: E): FingerTree<E>
    fun pushLast(value: E): FingerTree<E>

    fun popFirst(): Pair<E, FingerTree<E>>?
    fun popLast(): Pair<E, FingerTree<E>>?

    fun concat(other: FingerTree<E>): FingerTree<E> = concatWithMiddle(listOf(), other)
    fun concatWithMiddle(middle: List<E>, other: FingerTree<E>): FingerTree<E>
}

class Empty<E> : FingerTree<E> {
    override fun pushFirst(value: E) = Single(value)
    override fun pushLast(value: E) = Single(value)
    override fun popFirst(): Pair<E, FingerTree<E>>? = null
    override fun popLast(): Pair<E, FingerTree<E>>? = null

    override fun concatWithMiddle(middle: List<E>, other: FingerTree<E>): FingerTree<E> {
        return if (middle.isEmpty()) {
            other
        } else {
            concatWithMiddle(middle.subList(1, middle.size), other).pushFirst(middle.first())
        }
    }
}

class Single<E>(val element: E) : FingerTree<E> {
    override fun pushFirst(value: E) = Deep(One(element), Empty(), One(value))
    override fun pushLast(value: E) = Deep(One(value), Empty(), One(element))
    override fun popFirst() = Pair<E, FingerTree<E>>(element, Empty())
    override fun popLast() = Pair<E, FingerTree<E>>(element, Empty())

    override fun concatWithMiddle(middle: List<E>, other: FingerTree<E>): FingerTree<E> {
        return if (middle.isEmpty() && other is Empty) this
        else Empty<E>().concatWithMiddle(middle, other).pushFirst(element)
    }
}

class Deep<E>(
    val prefix: Affix<E>,
    val deeper: FingerTree<Node<E>>,
    val suffix: Affix<E>
) : FingerTree<E> {
    override fun pushFirst(value: E): FingerTree<E> {
        return if (prefix is Four) {
            Deep(
                Two(value, prefix.a),
                deeper.pushFirst(Branch3(prefix.b, prefix.c, prefix.d)),
                suffix
            )
        } else {
            Deep(prefix.pushFirst(value), deeper, suffix)
        }
    }

    override fun pushLast(value: E): FingerTree<E> {
        return if (suffix is Four) {
            Deep(
                prefix,
                deeper.pushLast(Branch3(suffix.a, suffix.b, suffix.c)),
                Two(suffix.d, value)
            )
        } else {
            Deep(prefix, deeper, suffix.pushLast(value))
        }
    }

    override fun popFirst(): Pair<E, FingerTree<E>> {
        val list = prefix.toList()
        val value = list.first()
        return if (list.size == 1) {
            val node = deeper.popFirst()
            if (node == null) {
                if (suffix is One) {
                    Pair(value, Single(suffix.a))
                } else {
                    val (newSuffix, newPrefix) = suffix.popLast()
                    Pair(value, Deep(newPrefix, Empty(), One(newSuffix)))
                }
            } else {
                val newPrefix = Affix.fromList(node.first.toList())
                val newDeeper = node.second
                Pair(value, Deep(newPrefix, newDeeper, suffix))
            }
        } else {
            Pair(value, Deep(Affix.fromList(list.subList(1, list.size)), deeper, suffix))
        }
    }

    override fun popLast(): Pair<E, FingerTree<E>>? {
        val list = suffix.toList()
        val value = list.last()
        return if (list.size == 1) {
            val node = deeper.popLast()
            if (node == null) {
                if (prefix is One) {
                    Pair(value, Single(prefix.a))
                } else {
                    val (newPrefix, newSuffix) = prefix.popFirst()
                    Pair(value, Deep(One(newPrefix), Empty(), newSuffix))
                }
            } else {
                val newSuffix = Affix.fromList(node.first.toList())
                val newDeeper = node.second
                Pair(value, Deep(prefix, newDeeper, newSuffix))
            }
        } else {
            Pair(value, Deep(prefix, deeper, Affix.fromList(list.subList(0, list.size - 1))))
        }
    }

    override fun concatWithMiddle(middle: List<E>, other: FingerTree<E>): FingerTree<E> {
        return when (other) {
            is Empty -> {
                if (middle.isEmpty()) this
                else concatWithMiddle(middle.subList(0, middle.size - 1), Empty())
                    .pushLast(middle.last())
            }
            is Single -> concatWithMiddle(middle, Empty()).pushLast(other.element)
            is Deep -> {
                val newMiddle = Node.nodes(suffix.toList() + middle + other.prefix.toList())
                val newDeeper = deeper.concatWithMiddle(newMiddle, other.deeper)
                Deep(prefix, newDeeper, other.suffix)
            }
            else -> throw IllegalStateException("Unexpected type of finger tree")
        }
    }
}