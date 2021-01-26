[![Inline docs](https://img.shields.io/badge/docs-latest-gray)](https://github.com/molo4evan/persistent-data-structures/tree/master/documentation/index.md) ![Build](https://github.com/molo4evan/persistent-data-structures/workflows/CI/badge.svg?branch=master) ![Release](https://github.com/molo4evan/persistent-data-structures/workflows/Release/badge.svg) [![codecov](https://codecov.io/gh/molo4evan/persistent-data-structures/branch/master/graph/badge.svg?token=F0XJ7SXC54)](https://codecov.io/gh/molo4evan/persistent-data-structures)

# Persistent Data Structures
"Modern methods of programming" course project

## Implemented structures
* FingerTreeDeque<E> - persistent equivalent of 2-linked list (deque), based on finger-trees. Additions and deletions to/from start and end performs for O(lg size) worst case and O(1) amortized.
* BTreeArrayList<E> - persistent equivalen of an array, based on B-trees. Get(index) is performed for O(log b (size)), update(index, element) is performed for O(b * log b (size)).
* PersistentTreeMap<K, V> - persistent equivalent of dictionary, based on AVL trees. Performs Get(key) and Put(key, value) for O(log size), takes O(size + updates * log (size)) space.
  
## Usage
To use this library you can follow either of next two options:
* Go to the latest release and download corresponding JAR archive.
* Build library by you own by cloning repo and performing './gradlew shadowJar' for Unix-based OS or './gradlew.bat shadowJar' for Windows-based ones.

## Requirements
* JDK 11 or later.

## Benchmarks
Benchmarking is provided via JMH (Java Microbenchmark Harness). To see benchmark results for specific release, download corresponding 'benchmark-results.json' from release page. You can then upload it to this [JMH Visualization Tool](https://jmh.morethan.io) to see visualization charts.
