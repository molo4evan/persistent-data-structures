//[persistent-data-structures](../../index.md)/[ru.nsu.mmp.pds.deque](../index.md)/[FingerTreeDeque](index.md)/[addAll](add-all.md)



# addAll  
[jvm]  
Content  
open override fun [addAll](add-all.md)(c: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[E](index.md)>): [FingerTreeDeque](index.md)<[E](index.md)>  
More info  


Асимптотика конкатенации с другой FingerTreeDeque - O(lg(min(this.size, c.size))). Для других типов коллекций асимптотика - O(add) * c.size.

  



