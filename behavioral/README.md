# **`Behavioral` Patterns**

Khác với **Creational** (tạo object) hay **Structural** (cấu trúc object), **`Behavioral` Patterns** tập trung giải quyết bài toán:

- phân bổ trách nhiệm (`responsibilities`)
- luồng giao tiếp (`communication`)

giữa các **objects/classes**.

> _Mục tiêu tối thượng là giữ cho các component tương tác với nhau trơn tru nhưng vẫn đảm bảo loose coupling._

## **Patterns**

- [Chain of Responsibility](./cor/ChainOfResponsibility.md) -> **Truyền request** qua chuỗi **handler** | **`Pipeline` / `Filter`**
- [Command](./command/CommandPattern.md) -> **Đóng gói request** thành object | **`Undo` / `Queue`**
- [Interpreter](https://www.tutorialspoint.com/design_pattern/interpreter_pattern.htm)
- [Iterator](https://www.tutorialspoint.com/design_pattern/iterator_pattern.htm) -> **Duyệt collection** mà không lộ cấu trúc nội bộ | **`Sequential access`**
- [Mediator](./mediator/MediatorPattern.md) -> Trung gian **điều phối giao tiếp** | **`Decouple many-to-many`**
- [Momento](https://www.tutorialspoint.com/design_pattern/memento_pattern.htm)
- [Observer](./observer/ObserverPattern.md) -> Một thay đổi → nhiều đối tượng được thông báo | **`Subscribe` / `Notify`**
- [State](./state/StatePattern.md) -> Thay đổi hành vi khi state thay đổi | **`Finite State Machine`**
- [Strategy](./strategy/StrategyPattern.md) -> Chọn thuật toán lúc runtime | **`Swap algorithm`**
- [Template](./template/TemplatePattern.md) -> **Skeleton** thuật toán, subclass điền chi tiết | **`Hook` / `Override`**
