# **_Structional_ Patterns**

**`Structural`** tập trung vào việc **lắp ráp các object và class** hiện có lại với nhau thành **một cấu trúc lớn hơn, phức tạp hơn nhưng vẫn giữ được tính linh hoạt (flexible) và dễ bảo trì**.

- **Composition over Inheritance**:

  Trong lập trình OOP truyền thống, kĩ sư rất hay lạm dụng Kế thừa (Inheritance - quan hệ IS-A) để tái sử dụng code. Nhưng khi project scale up, kế thừa sinh ra 2 đòn chí mạng:
  - **Tight Coupling**: **Subclass bị `phụ thuộc cứng` vào Superclass ở thời điểm `compile-time`**. Sửa một logic nhỏ ở class cha có thể làm vỡ (break) hàng loạt class con (Fragile Base Class Problem).
  - **Combinatorial Explosion**: Nếu có `3 loại Database` và `3 loại OS`, dùng kế thừa, phải đẻ ra $3 \times 3 = 9$ `subclasses` để cover hết các case

  **Structural Patterns** giải quyết bài toán này bằng Composition (Chứa đựng - quan hệ HAS-A). Thay vì class A kế thừa class B, thiết kế để class A chứa một instance của class B dưới dạng một interface.

- **`Interface-Based` Design** : **Structural Patterns** **KHÔNG THỂ** sống thiếu `Interface`.

  > Kĩ thuật cốt lõi ở đây là: Tách biệt hoàn toàn phần Trừu tượng (Abstraction - Interface/Contract) khỏi phần Thực thi (Implementation - Concrete Class).

  Giúp **Đồng nhất hóa giao tiếp**

- **Cơ chế Ủy quyền (`Delegation`) và Bao bọc (`Wrapping`)**

  Để thay thế cho việc `override method` của class cha trong **Kế thừa**, **Structural Patterns** xài 2 kĩ thuật thao tác object cực mạnh:
  - **`Delegation` (Ủy quyền)**:
    - Một object nhận request từ client
    - nhưng thay vì tự xử lý, nó "đá" (forward) request đó cho một object khác mà nó đang chứa (delegate object) để xử lý giùm.

    > Trong Kotlin, thậm chí có hẳn từ khóa by để support native delegation type (ví dụ: `class MyService(repo: Repository) : Repository by repo`), giúp code cực kì clean mà không cần viết boilerplate.

  - **`Wrapping` (Bao bọc)**: Tao lấy object A, nhét nó vào trong ruột object B (thằng B này implement cùng interface với A). Client gọi B, B chạy thêm các pre-processing logic, sau đó gọi A, rồi B lại chạy tiếp post-processing logic.

    > Đây là nền tảng kĩ thuật để đắp thêm tính năng (AOP - Aspect Oriented Programming), chặn request, hoặc transform data mà không làm ô nhiễm (pollute) source code gốc của object A.

---

## **Patterns**

- [Adapter](./adapter/AdapterPattern.md)
- [Bridge](./bridge/BridgePattern.md)
- [Composite](./composite/CompositePattern.md)
- [Decorator](./decorator/DecoratorPattern.md)
- [Facade](./facade/FacadePattern.md)
- [Flyweight](./flyweight/FlyweightPattern.md)
- [Proxy](./proxy/ProxyPattern.md)