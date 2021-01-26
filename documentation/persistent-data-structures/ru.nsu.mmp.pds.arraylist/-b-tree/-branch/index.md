//[persistent-data-structures](../../../index.md)/[ru.nsu.mmp.pds.arraylist](../../index.md)/[BTree](../index.md)/[Branch](index.md)



# Branch  
 [jvm] data class [Branch](index.md)<[E](index.md)>(**children**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[BTree.Node](../-node/index.md)<[E](index.md)>>, **factor**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [BTree.Node](../-node/index.md)<[E](index.md)>    


## Constructors  
  
|  Name|  Summary| 
|---|---|
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Branch/Branch/#kotlin.Int#kotlin.Array[ru.nsu.mmp.pds.arraylist.BTree.Node[TypeParam(bounds=[kotlin.Any?])]]/PointingToDeclaration/"></a>[Branch](-branch.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Branch/Branch/#kotlin.Int#kotlin.Array[ru.nsu.mmp.pds.arraylist.BTree.Node[TypeParam(bounds=[kotlin.Any?])]]/PointingToDeclaration/"></a> [jvm] fun <[E](index.md)> [Branch](-branch.md)(factor: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), vararg children: [BTree.Node](../-node/index.md)<[E](index.md)>)   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Branch/atIndex/#kotlin.Int#kotlin.Int/PointingToDeclaration/"></a>[atIndex](at-index.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Branch/atIndex/#kotlin.Int#kotlin.Int/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [atIndex](at-index.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), layer: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [E](index.md)  <br><br><br>
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Branch/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Branch/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[BTree.Node](../-node/index.md)<[E](index.md)>>  <br><br><br>
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Branch/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Branch/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Branch/copy/#/PointingToDeclaration/"></a>[copy](copy.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Branch/copy/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [copy](copy.md)(): [BTree.Branch](index.md)<[E](index.md)>  <br>fun [copy](copy.md)(children: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[BTree.Node](../-node/index.md)<[E](index.md)>>, factor: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [BTree.Branch](index.md)<[E](index.md)>  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1889759830)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1889759830)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1889759830)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1889759830)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1889759830)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1889759830)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Branch/updateAt/#kotlin.Int#kotlin.Int#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[updateAt](update-at.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Branch/updateAt/#kotlin.Int#kotlin.Int#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [updateAt](update-at.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), layer: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), value: [E](index.md)): [BTree.Node](../-node/index.md)<[E](index.md)>  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Branch/capacity/#/PointingToDeclaration/"></a>[capacity](index.md#%5Bru.nsu.mmp.pds.arraylist%2FBTree.Branch%2Fcapacity%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1889759830)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Branch/capacity/#/PointingToDeclaration/"></a> [jvm] val [capacity](index.md#%5Bru.nsu.mmp.pds.arraylist%2FBTree.Branch%2Fcapacity%2F%23%2FPointingToDeclaration%2F%5D%2FProperties%2F-1889759830): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Branch/children/#/PointingToDeclaration/"></a>[children](children.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Branch/children/#/PointingToDeclaration/"></a> [jvm] val [children](children.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[BTree.Node](../-node/index.md)<[E](index.md)>>   <br>
| <a name="ru.nsu.mmp.pds.arraylist/BTree.Branch/factor/#/PointingToDeclaration/"></a>[factor](factor.md)| <a name="ru.nsu.mmp.pds.arraylist/BTree.Branch/factor/#/PointingToDeclaration/"></a> [jvm] open override val [factor](factor.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)   <br>

