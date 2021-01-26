//[persistent-data-structures](../../index.md)/[ru.nsu.mmp.pds.deque](../index.md)/[FingerTree](index.md)



# FingerTree  
 [jvm] interface [FingerTree](index.md)<[E](index.md)>   


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="ru.nsu.mmp.pds.deque/FingerTree.Affix///PointingToDeclaration/"></a>[Affix](-affix/index.md)| <a name="ru.nsu.mmp.pds.deque/FingerTree.Affix///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>interface [Affix](-affix/index.md)<[E](-affix/index.md)>  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/FingerTree.Branch2///PointingToDeclaration/"></a>[Branch2](-branch2/index.md)| <a name="ru.nsu.mmp.pds.deque/FingerTree.Branch2///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open class [Branch2](-branch2/index.md)<[E](-branch2/index.md)>(**a**: [FingerTree.Node](-node/index.md)<[E](-branch2/index.md)>, **b**: [FingerTree.Node](-node/index.md)<[E](-branch2/index.md)>) : [FingerTree.Node](-node/index.md)<[E](-branch2/index.md)>   <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/FingerTree.Branch3///PointingToDeclaration/"></a>[Branch3](-branch3/index.md)| <a name="ru.nsu.mmp.pds.deque/FingerTree.Branch3///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Branch3](-branch3/index.md)<[E](-branch3/index.md)>(**a**: [FingerTree.Node](-node/index.md)<[E](-branch3/index.md)>, **b**: [FingerTree.Node](-node/index.md)<[E](-branch3/index.md)>, **c**: [FingerTree.Node](-node/index.md)<[E](-branch3/index.md)>) : [FingerTree.Branch2](-branch2/index.md)<[E](-branch3/index.md)>   <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/FingerTree.Four///PointingToDeclaration/"></a>[Four](-four/index.md)| <a name="ru.nsu.mmp.pds.deque/FingerTree.Four///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Four](-four/index.md)<[E](-four/index.md)>(**a**: [E](-four/index.md), **b**: [E](-four/index.md), **c**: [E](-four/index.md), **d**: [E](-four/index.md)) : [FingerTree.Three](-three/index.md)<[E](-four/index.md)>   <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/FingerTree.Leaf///PointingToDeclaration/"></a>[Leaf](-leaf/index.md)| <a name="ru.nsu.mmp.pds.deque/FingerTree.Leaf///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>class [Leaf](-leaf/index.md)<[E](-leaf/index.md)>(**value**: [E](-leaf/index.md)) : [FingerTree.Node](-node/index.md)<[E](-leaf/index.md)>   <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/FingerTree.Node///PointingToDeclaration/"></a>[Node](-node/index.md)| <a name="ru.nsu.mmp.pds.deque/FingerTree.Node///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>interface [Node](-node/index.md)<[E](-node/index.md)>  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/FingerTree.One///PointingToDeclaration/"></a>[One](-one/index.md)| <a name="ru.nsu.mmp.pds.deque/FingerTree.One///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open class [One](-one/index.md)<[E](-one/index.md)>(**a**: [E](-one/index.md)) : [FingerTree.Affix](-affix/index.md)<[E](-one/index.md)>   <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/FingerTree.Three///PointingToDeclaration/"></a>[Three](-three/index.md)| <a name="ru.nsu.mmp.pds.deque/FingerTree.Three///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open class [Three](-three/index.md)<[E](-three/index.md)>(**a**: [E](-three/index.md), **b**: [E](-three/index.md), **c**: [E](-three/index.md)) : [FingerTree.Two](-two/index.md)<[E](-three/index.md)>   <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/FingerTree.Two///PointingToDeclaration/"></a>[Two](-two/index.md)| <a name="ru.nsu.mmp.pds.deque/FingerTree.Two///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open class [Two](-two/index.md)<[E](-two/index.md)>(**a**: [E](-two/index.md), **b**: [E](-two/index.md)) : [FingerTree.One](-one/index.md)<[E](-two/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="ru.nsu.mmp.pds.deque/FingerTree/concat/#ru.nsu.mmp.pds.deque.FingerTree[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[concat](concat.md)| <a name="ru.nsu.mmp.pds.deque/FingerTree/concat/#ru.nsu.mmp.pds.deque.FingerTree[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [concat](concat.md)(other: [FingerTree](index.md)<[E](index.md)>): [FingerTree](index.md)<[E](index.md)>  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/FingerTree/concatWithMiddle/#kotlin.collections.List[TypeParam(bounds=[kotlin.Any?])]#ru.nsu.mmp.pds.deque.FingerTree[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[concatWithMiddle](concat-with-middle.md)| <a name="ru.nsu.mmp.pds.deque/FingerTree/concatWithMiddle/#kotlin.collections.List[TypeParam(bounds=[kotlin.Any?])]#ru.nsu.mmp.pds.deque.FingerTree[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [concatWithMiddle](concat-with-middle.md)(middle: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[E](index.md)>, other: [FingerTree](index.md)<[E](index.md)>): [FingerTree](index.md)<[E](index.md)>  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1228172417)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1228172417)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1228172417)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1228172417)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/FingerTree/popFirst/#/PointingToDeclaration/"></a>[popFirst](pop-first.md)| <a name="ru.nsu.mmp.pds.deque/FingerTree/popFirst/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [popFirst](pop-first.md)(): [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)<[E](index.md), [FingerTree](index.md)<[E](index.md)>>?  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/FingerTree/popLast/#/PointingToDeclaration/"></a>[popLast](pop-last.md)| <a name="ru.nsu.mmp.pds.deque/FingerTree/popLast/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [popLast](pop-last.md)(): [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)<[E](index.md), [FingerTree](index.md)<[E](index.md)>>?  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/FingerTree/pushFirst/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[pushFirst](push-first.md)| <a name="ru.nsu.mmp.pds.deque/FingerTree/pushFirst/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [pushFirst](push-first.md)(value: [E](index.md)): [FingerTree](index.md)<[E](index.md)>  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/FingerTree/pushLast/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[pushLast](push-last.md)| <a name="ru.nsu.mmp.pds.deque/FingerTree/pushLast/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>abstract fun [pushLast](push-last.md)(value: [E](index.md)): [FingerTree](index.md)<[E](index.md)>  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1228172417)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1228172417)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Inheritors  
  
|  Name| 
|---|
| <a name="ru.nsu.mmp.pds.deque/Empty///PointingToDeclaration/"></a>[Empty](../-empty/index.md)
| <a name="ru.nsu.mmp.pds.deque/Single///PointingToDeclaration/"></a>[Single](../-single/index.md)
| <a name="ru.nsu.mmp.pds.deque/Deep///PointingToDeclaration/"></a>[Deep](../-deep/index.md)

