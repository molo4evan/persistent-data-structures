package ru.nsu.mmp.pds

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.nsu.mmp.pds.arraylist.BTreeArrayList

class ArrayTest {

    @Test
    fun `Create array`() {
        val arrayList = BTreeArrayList(5, 30, 3, { "123" })
        assertEquals(arrayList.size, 5)
    }


}