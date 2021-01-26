//[persistent-data-structures](../../index.md)/[ru.nsu.mmp.pds.map](../index.md)/[Node](index.md)



# Node  
 [jvm] data class [Node](index.md)<[K](index.md), [V](index.md)>(**key**: [K](index.md), **value**: [V](index.md)) : [Map.Entry](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/-entry/index.html)<[K](index.md), [V](index.md)>    


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="ru.nsu.mmp.pds.map/Node/component1/#/PointingToDeclaration/"></a>[component1](component1.md)| <a name="ru.nsu.mmp.pds.map/Node/component1/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [K](index.md)  <br><br><br>
| <a name="ru.nsu.mmp.pds.map/Node/component2/#/PointingToDeclaration/"></a>[component2](component2.md)| <a name="ru.nsu.mmp.pds.map/Node/component2/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>operator fun [component2](component2.md)(): [V](index.md)  <br><br><br>
| <a name="ru.nsu.mmp.pds.map/Node/copy/#/PointingToDeclaration/"></a>[copy](copy.md)| <a name="ru.nsu.mmp.pds.map/Node/copy/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>fun [copy](copy.md)(): [Node](index.md)<[K](index.md), [V](index.md)>  <br>fun [copy](copy.md)(key: [K](index.md), value: [V](index.md)): [Node](index.md)<[K](index.md), [V](index.md)>  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../-persistent-tree-map/-entry/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1014395654)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator override fun [equals](../-persistent-tree-map/-entry/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1014395654)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../-persistent-tree-map/-entry/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1014395654)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [hashCode](../-persistent-tree-map/-entry/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1014395654)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../-persistent-tree-map/-entry/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1014395654)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [toString](../-persistent-tree-map/-entry/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1014395654)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="ru.nsu.mmp.pds.map/Node/height/#/PointingToDeclaration/"></a>[height](height.md)| <a name="ru.nsu.mmp.pds.map/Node/height/#/PointingToDeclaration/"></a> [jvm] var [height](height.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0   <br>
| <a name="ru.nsu.mmp.pds.map/Node/key/#/PointingToDeclaration/"></a>[key](key.md)| <a name="ru.nsu.mmp.pds.map/Node/key/#/PointingToDeclaration/"></a> [jvm] open override var [key](key.md): [K](index.md)   <br>
| <a name="ru.nsu.mmp.pds.map/Node/left/#/PointingToDeclaration/"></a>[left](left.md)| <a name="ru.nsu.mmp.pds.map/Node/left/#/PointingToDeclaration/"></a> [jvm] var [left](left.md): [Node](index.md)<[K](index.md), [V](index.md)>? = null   <br>
| <a name="ru.nsu.mmp.pds.map/Node/right/#/PointingToDeclaration/"></a>[right](right.md)| <a name="ru.nsu.mmp.pds.map/Node/right/#/PointingToDeclaration/"></a> [jvm] var [right](right.md): [Node](index.md)<[K](index.md), [V](index.md)>? = null   <br>
| <a name="ru.nsu.mmp.pds.map/Node/value/#/PointingToDeclaration/"></a>[value](value.md)| <a name="ru.nsu.mmp.pds.map/Node/value/#/PointingToDeclaration/"></a> [jvm] open override var [value](value.md): [V](index.md)   <br>

