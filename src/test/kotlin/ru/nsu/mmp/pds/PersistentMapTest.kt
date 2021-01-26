package ru.nsu.mmp.pds

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.nsu.mmp.pds.map.PersistentTreeMap

class PersistentMapTest {
    @Test
    fun `Add element`() {
        val map = PersistentTreeMap<Int, String>()
        val key = 3
        val value = "гвоздика"
        val resultMap = map.put(key, value)
        assertEquals(value, resultMap[key])
        assertEquals(null, map[key])
        assertEquals(false, resultMap.isEmpty())
    }

    @Test
    fun `Add elements`() {
        val map = PersistentTreeMap<Int, String>()
            .put(8, "гвоздика")
            .put(6, "гиацинт")
            .put(3, "мак")
            .put(1, "ирис")
            .put(4, "нарцисс")
            .put(10, "лилия")
        val key = 7
        val value = "роза"
        val resultMap = map.put(key, value)
        assertEquals(value, resultMap[key])
        assertEquals(null, map[key])
    }

    @Test
    fun `Remove element`() {
        val key = 3
        val value = "гвоздика"
        val map = PersistentTreeMap<Int, String>().put(key, value)
        val resultMap = map.remove(key)
        assertEquals(value, map[key])
        assertEquals(null, resultMap[key])
    }

    @Test
    fun `Remove head element`() {
        val key = 8
        val value = "гвоздика"
        val map = PersistentTreeMap<Int, String>()
            .put(key, value)
            .put(3, "мак")
            .put(6, "гиацинт")
            .put(10, "лилия")
            .put(1, "ирис")
            .put(4, "нарцисс")
        val resultMap = map.remove(key)
        assertEquals(value, map[key])
        assertEquals(null, resultMap[key])
    }

    @Test
    fun `Put some elements`() {
        val map = hashMapOf<Int, String>()
        map[3] = "мак"
        map[6] = "гиацинт"
        map[10] = "лилия"
        map[1] = "ирис"
        map[4] = "нарцисс"
        val key = 8
        val value = "гвоздика"
        val persistentMap = PersistentTreeMap<Int, String>().put(key, value)
        val resultMap = persistentMap.putAll(map)
        assertEquals(map.size + 1, resultMap.size)
        assertEquals(null, persistentMap[3])
        assertEquals("мак", resultMap[3])
        assertEquals(value, resultMap[key])
    }

    @Test
    fun `Get previous version`() {
        val map = PersistentTreeMap<Int, String>()
        val key = 3
        val value = "гвоздика"
        val resultMap = map.put(key, value)
        assertEquals(map, resultMap.tryToUndo())
    }

    @Test
    fun `Get next version`() {
        val map = PersistentTreeMap<Int, String>()
        val key = 3
        val value = "гвоздика"
        val resultMap = map.put(key, value)
        assertEquals(resultMap, map.tryToRedo())
    }

    @Test
    fun `Find element`() {
        val map = PersistentTreeMap<Int, String>()
        val key = 3
        val value = "гвоздика"
        val resultMap = map.put(key, value)
        assertEquals(true, resultMap.containsKey(key))
        assertEquals(true, resultMap.containsValue(value))
    }

    @Test
    fun `Get keys`() {
        val key = 8
        val value = "гвоздика"
        val map = PersistentTreeMap<Int, String>()
            .put(key, value)
            .put(3, "мак")
            .put(6, "гиацинт")
            .put(10, "лилия")
            .put(1, "ирис")
            .put(4, "нарцисс")
        val keys = map.keys
        assertEquals(true, keys.contains(key))
        assertEquals(map.size, keys.size)
    }

    @Test
    fun `Get values`() {
        val key = 8
        val value = "гвоздика"
        val map = PersistentTreeMap<Int, String>()
            .put(key, value)
            .put(3, "мак")
            .put(6, "гиацинт")
            .put(10, "лилия")
            .put(1, "ирис")
            .put(4, "нарцисс")
        val values = map.values
        assertEquals(true, values.contains(value))
        assertEquals(map.size, values.size)
    }

    @Test
    fun `Get entries`() {
        val key = 8
        val value = "гвоздика"
        val map = PersistentTreeMap<Int, String>()
            .put(key, value)
            .put(3, "мак")
            .put(6, "гиацинт")
            .put(10, "лилия")
            .put(1, "ирис")
            .put(4, "нарцисс")
        val entries = map.entries
        assertEquals(true, entries.contains(PersistentTreeMap.Entry(key, value)))
        assertEquals(map.size, entries.size)
    }
}