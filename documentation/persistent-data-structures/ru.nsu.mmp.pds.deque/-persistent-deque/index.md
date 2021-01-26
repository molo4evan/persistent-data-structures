//[persistent-data-structures](../../index.md)/[ru.nsu.mmp.pds.deque](../index.md)/[PersistentDeque](index.md)



# PersistentDeque  
 [jvm] interface [PersistentDeque](index.md)<[E](index.md)> : [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[E](index.md)> , [PersistentDataStructure](../../ru.nsu.mmp.pds/-persistent-data-structure/index.md)<[PersistentDeque](index.md)<[E](index.md)>> 

Персистентный двусвязный список (аналогичный последовательностям в ФЯП). Аналогичен двусторонней очереди в Java. Не наследует стандартных коллекций, так как отличаются сигнатуры методов, в Java нет неизменяемых очередей.

   


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/add/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[add](add.md)| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/add/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [add](add.md)(e: [E](index.md)): [PersistentDeque](index.md)<[E](index.md)>  <br>More info  <br>Adds element to deque.  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/addAll/#kotlin.collections.Collection[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[addAll](add-all.md)| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/addAll/#kotlin.collections.Collection[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [addAll](add-all.md)(c: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[E](index.md)>): [FingerTreeDeque](../-finger-tree-deque/index.md)<[E](index.md)>  <br>More info  <br>Adds elements from other collection to deque.  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/addFirst/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[addFirst](add-first.md)| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/addFirst/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [addFirst](add-first.md)(e: [E](index.md)): [PersistentDeque](index.md)<[E](index.md)>  <br>More info  <br>Adds element at the start of deque.  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/addLast/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[addLast](add-last.md)| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/addLast/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [addLast](add-last.md)(e: [E](index.md)): [PersistentDeque](index.md)<[E](index.md)>  <br>More info  <br>Adds element at the end of deque.  <br><br><br>
| <a name="kotlin.collections/Collection/contains/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[contains](index.md#%5Bkotlin.collections%2FCollection%2Fcontains%2F%23TypeParam%28bounds%3D%5Bkotlin.Any%3F%5D%29%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)| <a name="kotlin.collections/Collection/contains/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract operator fun [contains](index.md#%5Bkotlin.collections%2FCollection%2Fcontains%2F%23TypeParam%28bounds%3D%5Bkotlin.Any%3F%5D%29%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)(element: [E](index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin.collections/Collection/containsAll/#kotlin.collections.Collection[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[containsAll](index.md#%5Bkotlin.collections%2FCollection%2FcontainsAll%2F%23kotlin.collections.Collection%5BTypeParam%28bounds%3D%5Bkotlin.Any%3F%5D%29%5D%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)| <a name="kotlin.collections/Collection/containsAll/#kotlin.collections.Collection[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [containsAll](index.md#%5Bkotlin.collections%2FCollection%2FcontainsAll%2F%23kotlin.collections.Collection%5BTypeParam%28bounds%3D%5Bkotlin.Any%3F%5D%29%5D%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)(elements: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[E](index.md)>): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/descendingIterator/#/PointingToDeclaration/"></a>[descendingIterator](descending-iterator.md)| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/descendingIterator/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [descendingIterator](descending-iterator.md)(): [Iterator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterator/index.html)<[E](index.md)>  <br>More info  <br>Gets descending iterator for deque (from end to start).  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin.collections/Iterable/forEach/#java.util.function.Consumer[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[forEach](index.md#%5Bkotlin.collections%2FIterable%2FforEach%2F%23java.util.function.Consumer%5BTypeParam%28bounds%3D%5Bkotlin.Any%3F%5D%29%5D%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)| <a name="kotlin.collections/Iterable/forEach/#java.util.function.Consumer[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [forEach](index.md#%5Bkotlin.collections%2FIterable%2FforEach%2F%23java.util.function.Consumer%5BTypeParam%28bounds%3D%5Bkotlin.Any%3F%5D%29%5D%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)(p0: [Consumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)<in [E](index.md)>)  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/get/#/PointingToDeclaration/"></a>[get](get.md)| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/get/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [get](get.md)(): [E](index.md)?  <br>More info  <br>Gets element from deque.  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/getFirst/#/PointingToDeclaration/"></a>[getFirst](get-first.md)| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/getFirst/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [getFirst](get-first.md)(): [E](index.md)?  <br>More info  <br>Gets first element from deque.  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/getLast/#/PointingToDeclaration/"></a>[getLast](get-last.md)| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/getLast/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [getLast](get-last.md)(): [E](index.md)?  <br>More info  <br>Gets last element from deque.  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin.collections/Collection/isEmpty/#/PointingToDeclaration/"></a>[isEmpty](index.md#%5Bkotlin.collections%2FCollection%2FisEmpty%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)| <a name="kotlin.collections/Collection/isEmpty/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [isEmpty](index.md#%5Bkotlin.collections%2FCollection%2FisEmpty%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin.collections/Collection/iterator/#/PointingToDeclaration/"></a>[iterator](index.md#%5Bkotlin.collections%2FCollection%2Fiterator%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)| <a name="kotlin.collections/Collection/iterator/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract operator override fun [iterator](index.md#%5Bkotlin.collections%2FCollection%2Fiterator%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)(): [Iterator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterator/index.html)<[E](index.md)>  <br><br><br>
| <a name="kotlin.collections/Collection/parallelStream/#/PointingToDeclaration/"></a>[parallelStream](index.md#%5Bkotlin.collections%2FCollection%2FparallelStream%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)| <a name="kotlin.collections/Collection/parallelStream/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [parallelStream](index.md#%5Bkotlin.collections%2FCollection%2FparallelStream%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)(): [Stream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)<[E](index.md)>  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/peek/#/PointingToDeclaration/"></a>[peek](peek.md)| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/peek/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [peek](peek.md)(): [E](index.md)?  <br>More info  <br>Stack operation: peek element from top of stack (get from start of deque).  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/pop/#/PointingToDeclaration/"></a>[pop](pop.md)| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/pop/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [pop](pop.md)(): [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)<[E](index.md), [PersistentDeque](index.md)<[E](index.md)>>?  <br>More info  <br>Stack operation: pop element from stack (remove from start of deque).  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/push/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[push](push.md)| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/push/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [push](push.md)(e: [E](index.md)): [PersistentDeque](index.md)<[E](index.md)>  <br>More info  <br>Stack operation: push element to stack (add to the start of deque).  <br><br><br>
| <a name="ru.nsu.mmp.pds/PersistentDataStructure/redo/#/PointingToDeclaration/"></a>[redo](../../ru.nsu.mmp.pds/-persistent-data-structure/redo.md)| <a name="ru.nsu.mmp.pds/PersistentDataStructure/redo/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [redo](../../ru.nsu.mmp.pds/-persistent-data-structure/redo.md)(): [PersistentDeque](index.md)<[E](index.md)>  <br>More info  <br>UNDO/REDO mechanism.  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/remove/#/PointingToDeclaration/"></a>[remove](remove.md)| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/remove/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [remove](remove.md)(): [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)<[E](index.md), [PersistentDeque](index.md)<[E](index.md)>>?  <br>More info  <br>Removes element from deque.  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/removeFirst/#/PointingToDeclaration/"></a>[removeFirst](remove-first.md)| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/removeFirst/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [removeFirst](remove-first.md)(): [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)<[E](index.md), [PersistentDeque](index.md)<[E](index.md)>>?  <br>More info  <br>Removes element from the start of deque.  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/removeLast/#/PointingToDeclaration/"></a>[removeLast](remove-last.md)| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/removeLast/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [removeLast](remove-last.md)(): [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)<[E](index.md), [PersistentDeque](index.md)<[E](index.md)>>?  <br>More info  <br>Removes element from the end of deque.  <br><br><br>
| <a name="kotlin.collections/Collection/spliterator/#/PointingToDeclaration/"></a>[spliterator](index.md#%5Bkotlin.collections%2FCollection%2Fspliterator%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)| <a name="kotlin.collections/Collection/spliterator/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [spliterator](index.md#%5Bkotlin.collections%2FCollection%2Fspliterator%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)(): [Spliterator](https://docs.oracle.com/javase/8/docs/api/java/util/Spliterator.html)<[E](index.md)>  <br><br><br>
| <a name="kotlin.collections/Collection/stream/#/PointingToDeclaration/"></a>[stream](index.md#%5Bkotlin.collections%2FCollection%2Fstream%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)| <a name="kotlin.collections/Collection/stream/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [stream](index.md#%5Bkotlin.collections%2FCollection%2Fstream%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)(): [Stream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)<[E](index.md)>  <br><br><br>
| <a name="kotlin.collections/Collection/toArray/#java.util.function.IntFunction[kotlin.Array[TypeParam(bounds=[kotlin.Any])]]/PointingToDeclaration/"></a>[toArray](index.md#%5Bkotlin.collections%2FCollection%2FtoArray%2F%23java.util.function.IntFunction%5Bkotlin.Array%5BTypeParam%28bounds%3D%5Bkotlin.Any%5D%29%5D%5D%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)| <a name="kotlin.collections/Collection/toArray/#java.util.function.IntFunction[kotlin.Array[TypeParam(bounds=[kotlin.Any])]]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>~~open~~ ~~fun~~ ~~<~~[T](index.md#%5Bkotlin.collections%2FCollection%2FtoArray%2F%23java.util.function.IntFunction%5Bkotlin.Array%5BTypeParam%28bounds%3D%5Bkotlin.Any%5D%29%5D%5D%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)~~>~~ [~~toArray~~](index.md#%5Bkotlin.collections%2FCollection%2FtoArray%2F%23java.util.function.IntFunction%5Bkotlin.Array%5BTypeParam%28bounds%3D%5Bkotlin.Any%5D%29%5D%5D%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)~~(~~~~p0~~~~:~~ [IntFunction](https://docs.oracle.com/javase/8/docs/api/java/util/function/IntFunction.html)<[Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[T](index.md#%5Bkotlin.collections%2FCollection%2FtoArray%2F%23java.util.function.IntFunction%5Bkotlin.Array%5BTypeParam%28bounds%3D%5Bkotlin.Any%5D%29%5D%5D%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)>>~~)~~~~:~~ [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[T](index.md#%5Bkotlin.collections%2FCollection%2FtoArray%2F%23java.util.function.IntFunction%5Bkotlin.Array%5BTypeParam%28bounds%3D%5Bkotlin.Any%5D%29%5D%5D%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)>  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/toList/#/PointingToDeclaration/"></a>[toList](to-list.md)| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/toList/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [toList](to-list.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[E](index.md)>  <br>More info  <br>Converts deque to list.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| <a name="ru.nsu.mmp.pds/PersistentDataStructure/tryToRedo/#/PointingToDeclaration/"></a>[tryToRedo](../../ru.nsu.mmp.pds/-persistent-data-structure/try-to-redo.md)| <a name="ru.nsu.mmp.pds/PersistentDataStructure/tryToRedo/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [tryToRedo](../../ru.nsu.mmp.pds/-persistent-data-structure/try-to-redo.md)(): [PersistentDeque](index.md)<[E](index.md)>?  <br><br><br>
| <a name="ru.nsu.mmp.pds/PersistentDataStructure/tryToUndo/#/PointingToDeclaration/"></a>[tryToUndo](../../ru.nsu.mmp.pds/-persistent-data-structure/try-to-undo.md)| <a name="ru.nsu.mmp.pds/PersistentDataStructure/tryToUndo/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [tryToUndo](../../ru.nsu.mmp.pds/-persistent-data-structure/try-to-undo.md)(): [PersistentDeque](index.md)<[E](index.md)>?  <br><br><br>
| <a name="ru.nsu.mmp.pds/PersistentDataStructure/undo/#/PointingToDeclaration/"></a>[undo](../../ru.nsu.mmp.pds/-persistent-data-structure/undo.md)| <a name="ru.nsu.mmp.pds/PersistentDataStructure/undo/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [undo](../../ru.nsu.mmp.pds/-persistent-data-structure/undo.md)(): [PersistentDeque](index.md)<[E](index.md)>  <br>More info  <br>UNDO/REDO mechanism.  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/size/#/PointingToDeclaration/"></a>[size](index.md#%5Bru.nsu.mmp.pds.deque%2FPersistentDeque%2Fsize%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-546294518)| <a name="ru.nsu.mmp.pds.deque/PersistentDeque/size/#/PointingToDeclaration/"></a> [jvm] abstract val [size](index.md#%5Bru.nsu.mmp.pds.deque%2FPersistentDeque%2Fsize%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-546294518): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>


## Inheritors  
  
|  Name| 
|---|
| <a name="ru.nsu.mmp.pds.deque/FingerTreeDeque///PointingToDeclaration/"></a>[FingerTreeDeque](../-finger-tree-deque/index.md)
