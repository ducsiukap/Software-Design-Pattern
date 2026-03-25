# **`Creational` Patterns**

## **`1.` Defines**

**`Creational` Patterns**: Nhóm này tập trung vào giải quyết các vấn đề liên quan đến cơ chế khởi tạo object (Object creation mechanisms).

**Cụ thể**:

- thay vì dùng `new` (khởi tạo qua `constructor` trực tiếp), khiến code bị **tightly coupling** và **khó scale** (vi phạm nguyên tắc `DIP` của `SOLID`)
- nhóm này cung cấp các cơ chế khởi tạo - `abstraction layer` - để instantiate object **linh hoạt và an toàn hơn**

**Mục đích**: Che giấu logic tạo object phức tạp và giúp hệ thống độc lập với cách các object được tạo ra.

---

## **`2.` Patterns**

- #### [Singleton](./singleton/SingletonPattern.md)
- #### [Factory](./factory/FactoryPattern.md)
- #### [Prototype](./prototype/PrototypePattern.md)
- #### [Builder](./builder/BuilderPattern.md)
- #### [ObjectPool](./objectpool/ObjectPoolPattern.md)