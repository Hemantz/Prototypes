# Prototypes
Sample prototypes for deeper understanding

# Consistent Hashing

This project demonstrates the concept of **Consistent Hashing** in Java.  
Consistent Hashing is widely used in distributed systems to efficiently distribute data across multiple nodes (servers, caches, etc.) with minimal data reshuffling when nodes are added or removed.

---

## 🔹 What is Consistent Hashing?

Normally, with **modulus-based hashing** (e.g., `hash(key) % N`), when the number of nodes changes, **almost all keys need to be remapped**.  
Consistent Hashing solves this by using a **hash ring**:
- Each node is assigned a position on the hash ring.
- Each key is mapped to the nearest node clockwise on the ring.
- When nodes join or leave, **only a small portion of keys need to be reassigned**.

This makes it ideal for:
- Distributed caches (e.g., Memcached, Redis Cluster)
- Databases (e.g., Cassandra, DynamoDB) - 
- Load balancing

### Important Note
Virtual Nodes: They are ideal for stateless servers (like caches or load balancers) because they provide better distribution across the ring.
Not recommended for Stateful Servers (like Databases): Multiple virtual nodes per physical machine can make data replication complex, since state must be replicated from multiple virtual nodes to a single physical node.

📦 Gradle Dependency

Add Guava library to your build.gradle:

```
dependencies {
    implementation 'com.google.guava:guava:33.2.1-jre'
}
```

📖 References

Amazon Dynamo Paper
Consistent Hashing Explained
