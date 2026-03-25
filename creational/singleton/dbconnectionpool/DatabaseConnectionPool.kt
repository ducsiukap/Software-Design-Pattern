import java.util.concurrent.ArrayBlockingQueue

object DatabaseConnectionPool {
    private const val maxConnections = 50
    private val connections = ArrayBlockingQueue<Connection>(maxConnections)

    init {
        // khởi tạo sẵn connection
        for (i in 1..maxConnections) {
            connections.put(Connection(i))
        }
    }

    @Synchronized
    fun getConnection(): Connection {
        // ArrayBlockingQueue.take()
        //  + nếu còn -> trả về phần tử đầu tiên
        //  + nếu hết -> block thread và đợi (không throw exception/ return null)
        return connections.take()
    }

    @Synchronized
    fun releaseConnection(connection: Connection) {
        connections.put(connection)
    }
}

// java tương tự,
// bổ sung
//  + private constructor
//  + static instance
//  + static method to get the DatabaseConnectionPool.instance