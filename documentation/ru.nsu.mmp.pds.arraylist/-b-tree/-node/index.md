//[persistent-data-structures](../../../index.md)/[ru.nsu.mmp.pds.arraylist](../../index.md)/[BTree](../index.md)/[Node](index.md)



# Node  
 [jvm] abstract class [Node](index.md)<[E](index.md)>(**factor**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **capacity**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))   


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Node/atIndex/#kotlin.Int#kotlin.Int/PointingToDeclaration/"></a>[atIndex](at-index.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Node/atIndex/#kotlin.Int#kotlin.Int/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [atIndex](at-index.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), layer: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [E](index.md)  <br><br><br>
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Node/copy/#/PointingToDeclaration/"></a>[copy](copy.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Node/copy/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [copy](copy.md)(): [BTree.Node](index.md)<[E](index.md)>  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1858318713)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1858318713)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1858318713)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1858318713)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1858318713)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1858318713)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Node/updateAt/#kotlin.Int#kotlin.Int#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[updateAt](update-at.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Node/updateAt/#kotlin.Int#kotlin.Int#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [updateAt](update-at.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), layer: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), value: [E](index.md)): [BTree.Node](index.md)<[E](index.md)>  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Node/capacity/#/PointingToDeclaration/"></a>[capacity](capacity.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Node/capacity/#/PointingToDeclaration/"></a> [jvm] val [capacity](capacity.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Node/factor/#/PointingToDeclaration/"></a>[factor](factor.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Node/factor/#/PointingToDeclaration/"></a> [jvm] open val [factor](factor.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>


## Inheritors  
  
|  Name| 
|---|
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Branch///PointingToDeclaration/"></a>[BTree](../-branch/index.md)
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Leaf///PointingToDeclaration/"></a>[BTree](../-leaf/index.md)

