//[persistent-data-structures](../../../index.md)/[ru.nsu.mmp.pds.arraylist](../../index.md)/[BTree](../index.md)/[Leaf](index.md)



# Leaf  
 [jvm] data class [Leaf](index.md)<[E](index.md)>(**elements**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[E](index.md)>, **factor**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [BTree.Node](../-node/index.md)<[E](index.md)>    


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Leaf/Leaf/#kotlin.Int#kotlin.Array[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[Leaf](-leaf.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Leaf/Leaf/#kotlin.Int#kotlin.Array[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a> [jvm] fun <[E](index.md)> [Leaf](-leaf.md)(factor: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), vararg elements: [E](index.md))   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Leaf/atIndex/#kotlin.Int#kotlin.Int/PointingToDeclaration/"></a>[atIndex](at-index.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Leaf/atIndex/#kotlin.Int#kotlin.Int/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [atIndex](at-index.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), layer: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [E](index.md)  <br><br><br>
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Leaf/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Leaf/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[E](index.md)>  <br><br><br>
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Leaf/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Leaf/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Leaf/copy/#/PointingToDeclaration/"></a>[copy](copy.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Leaf/copy/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [copy](copy.md)(): [BTree.Leaf](index.md)<[E](index.md)>  <br>fun [copy](copy.md)(elements: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[E](index.md)>, factor: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [BTree.Leaf](index.md)<[E](index.md)>  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-546294518)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Leaf/updateAt/#kotlin.Int#kotlin.Int#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[updateAt](update-at.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Leaf/updateAt/#kotlin.Int#kotlin.Int#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [updateAt](update-at.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), layer: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), value: [E](index.md)): [BTree.Node](../-node/index.md)<[E](index.md)>  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Leaf/capacity/#/PointingToDeclaration/"></a>[capacity](index.md#%5Bru.nsu.mmp.pds.arraylist%2FBTree.Leaf%2Fcapacity%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-546294518)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Leaf/capacity/#/PointingToDeclaration/"></a> [jvm] val [capacity](index.md#%5Bru.nsu.mmp.pds.arraylist%2FBTree.Leaf%2Fcapacity%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-546294518): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Leaf/elements/#/PointingToDeclaration/"></a>[elements](elements.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Leaf/elements/#/PointingToDeclaration/"></a> [jvm] val [elements](elements.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[E](index.md)>   <br>
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Leaf/factor/#/PointingToDeclaration/"></a>[factor](factor.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Leaf/factor/#/PointingToDeclaration/"></a> [jvm] open override val [factor](factor.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>

