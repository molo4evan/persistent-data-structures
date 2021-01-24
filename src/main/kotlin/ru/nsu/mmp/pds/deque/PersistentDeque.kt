package ru.nsu.mmp.pds.deque

import ru.nsu.mmp.pds.PersistentDataStructure

/**
 * Персистентный двусвязный список (аналогичный последовательностям в ФЯП).
 * Аналогичен двусторонней очереди в Java.
 * Не наследует стандартных коллекций, так как отличаются сигнатуры методов,
 * в Java нет неизменяемых очередей.
 */
interface PersistentDeque<E>: Collection<E>, PersistentDataStructure<PersistentDeque<E>> {

    /**
     * Adds element at the start of deque.
     * @param e element to add
     * @return updated deque
     */
    fun addFirst(e: E): PersistentDeque<E>

    /**
     * Adds element at the end of deque.
     * @param e element to add
     * @return updated deque
     */
    fun addLast(e: E): PersistentDeque<E>

    /**
     * Adds element to deque.
     * By default adds element at the start.
     * @param e element to add
     * @return updated deque
     */
    fun add(e: E): PersistentDeque<E> = addLast(e)

    /**
     * Removes element from the start of deque.
     * @return pair of removed element and updated deque or null if deque is empty
     */
    fun removeFirst(): Pair<E, PersistentDeque<E>>?

    /**
     * Removes element from the end of deque.
     * @return pair of removed element and updated deque or null if deque is empty
     */
    fun removeLast(): Pair<E, PersistentDeque<E>>?

    /**
     * Removes element from deque.
     * By default removes from the end.
     * @return pair of removed element and updated deque or null if deque is empty
     */
    fun remove(): Pair<E, PersistentDeque<E>>? = removeLast()

    /**
     * Gets first element from deque.
     * @return element or null if deque is empty
     */
    fun getFirst(): E?

    /**
     * Gets last element from deque.
     * @return element or null if deque is empty
     */
    fun getLast(): E?

    /**
     * Gets element from deque.
     * By default gets the last element
     * @return element or null if deque is empty
     */
    fun get(): E? = getLast()

    /**
     * Stack operation: push element to stack (add to the start of deque).
     * @param e element to push
     * @return updated deque
     */
    fun push(e: E): PersistentDeque<E> = addFirst(e)

    /**
     * Stack operation: pop element from stack (remove from start of deque).
     * @return pair of removed element and updated deque or null if deque is empty
     */
    fun pop(): Pair<E, PersistentDeque<E>>? = removeFirst()

    /**
     * Stack operation: peek element from top of stack (get from start of deque).
     * @return element or null if deque is empty
     */
    fun peek(): E? = getFirst()

    /**
     * Gets descending iterator for deque (from end to start).
     * @return iterator for deque
     */
    fun descendingIterator(): Iterator<E>

    /**
     * Adds elements from other collection to deque.
     * @return updated deque
     */
    fun addAll(c: Collection<E>): FingerTreeDeque<E>

    /**
     * Converts iterable to persistent deque.
     * @return created deque containing elements of iterable in the order of iteration
     */
    fun <E> Iterable<E>.toPersistentDeque(): PersistentDeque<E>

    /**
     * Converts deque to list.
     * @return created list containing elements of deque in the same order
     */
    fun toList(): List<E>
}