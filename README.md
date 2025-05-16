
# Cache is 🔁 Java Cache System with Design Patterns

This project implements a modular, extensible cache system in Java using **creational design patterns**, built as part of a GrowthHungry Academy Computer Science assignment.

## 📚 Features

- ✅ **Creational Design Patterns**
  - **Singleton**: Used in `SimpleCache` for a globally shared cache instance.
  - **Factory**: Used in `CacheFactory` to create different types of cache implementations dynamically.

- ✅ **Cache Interfaces**
  - Keys: `String`
  - Values: `int`
  - Core operations:
    - `put(String key, int value)`
    - `get(String key)`
    - `remove(String key)`
    - `clear()`
    - `size()`
    - `containsKey(String key)`

---

## 🧠 Supported Cache Types

| Type     | Description                              | Class Name   |
|----------|------------------------------------------|--------------|
| `LRU`    | Least Recently Used – uses `LinkedHashMap` with access order | `LRUCache` |
| `FIFO`   | First In First Out – removes oldest entry first | `FIFOCache` |
| `LFU`    | Least Frequently Used – removes least-used entry | `LFUCache` |
| `Simple` | Singleton-style basic cache (no eviction) | `SimpleCache` (bonus) |

---

## 🏗️ Architecture

