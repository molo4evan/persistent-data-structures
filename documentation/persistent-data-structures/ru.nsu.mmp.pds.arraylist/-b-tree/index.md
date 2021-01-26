//[persistent-data-structures](../../index.md)/[ru.nsu.mmp.pds.arraylist](../index.md)/[BTree](index.md)



# BTree  
 [jvm] class [BTree](index.md)<[E](index.md)>   


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="ru.nsu.mmp.pds.arraylist/BTree/BTree/#kotlin.Int#kotlin.Int#kotlin.Function0[TypeParam(bounds=[kotlin.Any?])]?/PointingToDeclaration/"></a>[BTree](-b-tree.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree/BTree/#kotlin.Int#kotlin.Int#kotlin.Function0[TypeParam(bounds=[kotlin.Any?])]?/PointingToDeclaration/"></a> [jvm] fun <[E](index.md)> [BTree](-b-tree.md)(size: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), factor: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 3, elementProvider: () -> [E](index.md)? = null)   <br>


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Branch///PointingToDeclaration/"></a>[Branch](-branch/index.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Branch///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>data class [Branch](-branch/index.md)<[E](-branch/index.md)>(**children**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[BTree.Node](-node/index.md)<[E](-branch/index.md)>>, **factor**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [BTree.Node](-node/index.md)<[E](-branch/index.md)>   <br><br><br>
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Leaf///PointingToDeclaration/"></a>[Leaf](-leaf/index.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Leaf///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>data class [Leaf](-leaf/index.md)<[E](-leaf/index.md)>(**elements**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[E](-leaf/index.md)>, **factor**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [BTree.Node](-node/index.md)<[E](-leaf/index.md)>   <br><br><br>
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Node///PointingToDeclaration/"></a>[Node](-node/index.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Node///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract class [Node](-node/index.md)<[E](-node/index.md)>(**factor**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **capacity**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="ru.nsu.mmp.pds.arraylist/BTree/atIndex/#kotlin.Int/PointingToDeclaration/"></a>[atIndex](at-index.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree/atIndex/#kotlin.Int/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [atIndex](at-index.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [E](index.md)  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-205164566)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-205164566)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-205164566)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-205164566)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-205164566)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-205164566)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| <a name="ru.nsu.mmp.pds.arraylist/BTree/updateAt/#kotlin.Int#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[updateAt](update-at.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree/updateAt/#kotlin.Int#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [updateAt](update-at.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), value: [E](index.md)): [BTree](index.md)<[E](index.md)>  <br><br><br>

