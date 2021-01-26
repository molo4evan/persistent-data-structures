//[persistent-data-structures](../../index.md)/[ru.nsu.mmp.pds.deque](../index.md)/[Deep](index.md)



# Deep  
 [jvm] class [Deep](index.md)<[E](index.md)>(**prefix**: [FingerTree.Affix](../-finger-tree/-affix/index.md)<[E](index.md)>, **deeper**: [FingerTree](../-finger-tree/index.md)<[FingerTree.Node](../-finger-tree/-node/index.md)<[E](index.md)>>, **suffix**: [FingerTree.Affix](../-finger-tree/-affix/index.md)<[E](index.md)>) : [FingerTree](../-finger-tree/index.md)<[E](index.md)>    


## Functions  
  
|  Name|  Summary| 
|---|---|
| <a name="ru.nsu.mmp.pds.deque/FingerTree/concat/#ru.nsu.mmp.pds.deque.FingerTree[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[concat](../-finger-tree/concat.md)| <a name="ru.nsu.mmp.pds.deque/FingerTree/concat/#ru.nsu.mmp.pds.deque.FingerTree[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [concat](../-finger-tree/concat.md)(other: [FingerTree](../-finger-tree/index.md)<[E](index.md)>): [FingerTree](../-finger-tree/index.md)<[E](index.md)>  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/Deep/concatWithMiddle/#kotlin.collections.List[TypeParam(bounds=[kotlin.Any?])]#ru.nsu.mmp.pds.deque.FingerTree[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[concatWithMiddle](concat-with-middle.md)| <a name="ru.nsu.mmp.pds.deque/Deep/concatWithMiddle/#kotlin.collections.List[TypeParam(bounds=[kotlin.Any?])]#ru.nsu.mmp.pds.deque.FingerTree[TypeParam(bounds=[kotlin.Any?])]/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [concatWithMiddle](concat-with-middle.md)(middle: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[E](index.md)>, other: [FingerTree](../-finger-tree/index.md)<[E](index.md)>): [FingerTree](../-finger-tree/index.md)<[E](index.md)>  <br><br><br>
| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[equals](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1507622200)| <a name="kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open operator fun [equals](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2Fequals%2F%23kotlin.Any%3F%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1507622200)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[hashCode](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1507622200)| <a name="kotlin/Any/hashCode/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [hashCode](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FhashCode%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1507622200)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/Deep/popFirst/#/PointingToDeclaration/"></a>[popFirst](pop-first.md)| <a name="ru.nsu.mmp.pds.deque/Deep/popFirst/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [popFirst](pop-first.md)(): [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)<[E](index.md), [FingerTree](../-finger-tree/index.md)<[E](index.md)>>  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/Deep/popLast/#/PointingToDeclaration/"></a>[popLast](pop-last.md)| <a name="ru.nsu.mmp.pds.deque/Deep/popLast/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [popLast](pop-last.md)(): [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)<[E](index.md), [FingerTree](../-finger-tree/index.md)<[E](index.md)>>  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/Deep/pushFirst/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[pushFirst](push-first.md)| <a name="ru.nsu.mmp.pds.deque/Deep/pushFirst/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [pushFirst](push-first.md)(value: [E](index.md)): [FingerTree](../-finger-tree/index.md)<[E](index.md)>  <br><br><br>
| <a name="ru.nsu.mmp.pds.deque/Deep/pushLast/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[pushLast](push-last.md)| <a name="ru.nsu.mmp.pds.deque/Deep/pushLast/#TypeParam(bounds=[kotlin.Any?])/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open override fun [pushLast](push-last.md)(value: [E](index.md)): [FingerTree](../-finger-tree/index.md)<[E](index.md)>  <br><br><br>
| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[toString](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1507622200)| <a name="kotlin/Any/toString/#/PointingToDeclaration/"></a>[jvm]  <br>Content  <br>open fun [toString](../../ru.nsu.mmp.pds.map/-persistent-map/index.md#%5Bkotlin%2FAny%2FtoString%2F%23%2FPointingToDeclaration%2F%5D%2FFunctions%2F-1507622200)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| <a name="ru.nsu.mmp.pds.deque/Deep/deeper/#/PointingToDeclaration/"></a>[deeper](deeper.md)| <a name="ru.nsu.mmp.pds.deque/Deep/deeper/#/PointingToDeclaration/"></a> [jvm] val [deeper](deeper.md): [FingerTree](../-finger-tree/index.md)<[FingerTree.Node](../-finger-tree/-node/index.md)<[E](index.md)>>   <br>
| <a name="ru.nsu.mmp.pds.deque/Deep/prefix/#/PointingToDeclaration/"></a>[prefix](prefix.md)| <a name="ru.nsu.mmp.pds.deque/Deep/prefix/#/PointingToDeclaration/"></a> [jvm] val [prefix](prefix.md): [FingerTree.Affix](../-finger-tree/-affix/index.md)<[E](index.md)>   <br>
| <a name="ru.nsu.mmp.pds.deque/Deep/suffix/#/PointingToDeclaration/"></a>[suffix](suffix.md)| <a name="ru.nsu.mmp.pds.deque/Deep/suffix/#/PointingToDeclaration/"></a> [jvm] val [suffix](suffix.md): [FingerTree.Affix](../-finger-tree/-affix/index.md)<[E](index.md)>   <br>

