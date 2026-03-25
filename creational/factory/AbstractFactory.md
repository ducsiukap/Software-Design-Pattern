# **`Abstract Factory` Pattern**

![Abstract Factory](image.png)

## **`1.` Abstract Factory - _Factory of Factory_**

### **Bản chất**

**Abstract Factory** defines an `interface` or `abstract class` for **creating families of `related (or dependent) objects`** but **without specifying their concrete sub-classes**

### **Advantage**

- `isolates` the `client code` from `concrete (implementation) classes`

  > Tách `Logic nghiệp vụ` với `các lớp triển khai` (**Cùng logic nghiệp vụ, nhưng có nhiều nhóm Products - `Family` - triển khai**)

- eases the exchanging of object families
- promotes `consistency` among objects (tăng tính **nhất quán** giữa các object liên quan)

## **`2.` Example Implements**

```kotlin
// --- Abstract Products ---
interface FileStorage { fun upload(file: ByteArray) }
interface MessageBroker { fun publish(msg: String) }

// --- Concrete Products (Family 1: AWS) ---
class S3Storage : FileStorage { override fun upload(file: ByteArray) = println("Upload to S3") }
class SQSBroker : MessageBroker { override fun publish(msg: String) = println("Publish to SQS") }

// --- Concrete Products (Family 2: GCP) ---
class GCSStorage : FileStorage { override fun upload(file: ByteArray) = println("Upload to GCS") }
class PubSubBroker : MessageBroker { override fun publish(msg: String) = println("Publish to PubSub") }

// --- Abstract Factory ---
interface CloudInfrastructureFactory {
    fun createFileStorage(): FileStorage
    fun createMessageBroker(): MessageBroker
}

// --- Concrete Factories ---
// Trong Spring Boot, bro có thể dùng @Component kèm @Profile hoặc @ConditionalOnProperty để inject đúng Factory
class AwsFactory : CloudInfrastructureFactory {
    override fun createFileStorage() = S3Storage()
    override fun createMessageBroker() = SQSBroker()
}

class GcpFactory : CloudInfrastructureFactory {
    override fun createFileStorage() = GCSStorage()
    override fun createMessageBroker() = PubSubBroker()
}

// --- Client (Service Layer) ---
// Injection thông qua constructor, hệ thống sẽ tự động cung cấp bộ component tương thích
class DataPipelineService(private val factory: CloudInfrastructureFactory) {
    fun processData(data: ByteArray, logMsg: String) {
        val storage = factory.createFileStorage()
        val broker = factory.createMessageBroker()

        storage.upload(data)
        broker.publish(logMsg)
    }
}
```
