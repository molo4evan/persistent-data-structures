package ru.nsu.mmp.pds

/**
 * Marks class as persistent data structure and adds UNDO/REDO semantics.
 */
interface PersistentDataStructure<T: PersistentDataStructure<T>> {

    /**
     * UNDO/REDO mechanism.
     * Go to the previous state of deque.
     * @return previous state of deque
     * @throws IllegalStateException if no previous state found
     */
    fun undo(): T = tryToUndo() ?: throw IllegalStateException("No previous state")

    /**
     * @return previous state of deque or null if current state is the first
     */
    fun tryToUndo(): T?

    /**
     * UNDO/REDO mechanism.
     * Go to the next state of deque.
     * @return next state of deque
     * @throws IllegalStateException if no next state found
     */
    fun redo(): T = tryToRedo() ?: throw IllegalStateException("No next state")

    /**
     * @return next state of deque or null if current state is the last
     */
    fun tryToRedo(): T?
}