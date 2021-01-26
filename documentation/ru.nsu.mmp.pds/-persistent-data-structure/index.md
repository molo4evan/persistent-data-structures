//[persistent-data-structures](../../index.md)/[ru.nsu.mmp.pds](../index.md)/[PersistentDataStructure](index.md)



# PersistentDataStructure  
 [jvm] interface [PersistentDataStructure](index.md)<[T](index.md) : [PersistentDataStructure](index.md)<[T](index.md)>>

Marks class as persistent data structure and adds UNDO/REDO semantics.

   


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1858318713)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1858318713)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1858318713)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1858318713)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="ru.nsu.mmp.pds/PersistentDataStructure/redo/#/PointingToDeclaration/"></a>[redo](redo.md)| <a name="ru.nsu.mmp.pds/PersistentDataStructure/redo/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [redo](redo.md)(): [T](index.md)  <br>More info  <br>UNDO/REDO mechanism.  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1858318713)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1858318713)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| <a name="ru.nsu.mmp.pds/PersistentDataStructure/tryToRedo/#/PointingToDeclaration/"></a>[tryToRedo](try-to-redo.md)| <a name="ru.nsu.mmp.pds/PersistentDataStructure/tryToRedo/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [tryToRedo](try-to-redo.md)(): [T](index.md)?  <br><br><br>
| <a name="ru.nsu.mmp.pds/PersistentDataStructure/tryToUndo/#/PointingToDeclaration/"></a>[tryToUndo](try-to-undo.md)| <a name="ru.nsu.mmp.pds/PersistentDataStructure/tryToUndo/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [tryToUndo](try-to-undo.md)(): [T](index.md)?  <br><br><br>
| <a name="ru.nsu.mmp.pds/PersistentDataStructure/undo/#/PointingToDeclaration/"></a>[undo](undo.md)| <a name="ru.nsu.mmp.pds/PersistentDataStructure/undo/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [undo](undo.md)(): [T](index.md)  <br>More info  <br>UNDO/REDO mechanism.  <br><br><br>


## Inheritors  
  
|  Name| 
|---|
| <a name="ru.nsu.mmp.pds.arraylist/PersistentList///PointingToDeclaration/"></a>[PersistentList](../../ru.nsu.mmp.pds.arraylist/-persistent-list/index.md)
| <a name="ru.nsu.mmp.pds.deque/PersistentDeque///PointingToDeclaration/"></a>[PersistentDeque](../../ru.nsu.mmp.pds.deque/-persistent-deque/index.md)
| <a name="ru.nsu.mmp.pds.map/PersistentMap///PointingToDeclaration/"></a>[PersistentMap](../../ru.nsu.mmp.pds.map/-persistent-map/index.md)

