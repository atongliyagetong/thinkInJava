##FilterInputStream类型
**FilterInputStream类型**能够完成两件不同的事情。DataInputStream允许我们读取不同的基础类型数据和String对象。搭配相应的DataOutputStream,可以通过数据流将基本类型数据从一个地方迁移到另一个地方。
##FilterInputStream类型：
|    类              | 功能 | 如何使用 |
| -------------------| --- | ---------|
| DataInputStream | 与DataOutputStream搭配使用，因此我们可以按照可移植方式从流中获取基本数据类型 | InputStream，包含用于读取基本数据的全部接口
| BufferedInputStream | 使用它可以防止每次读取时都进行实际写操作。代表使用“缓冲区”| InputStream,可以指定缓冲区大小（可选的） 。本质上不提供接口，只不过是向进程中添加缓冲区所必需的。与接口对象搭配 
| LinkNumberInputStream | 跟踪流中的行号，可以调用getLineNumber()和setLineNumber(int) | InputStream, 仅增加行号，因此可能要与接口对象搭配使用
| PushBackInputStream |具有“能弹出一个字节的缓冲区”。因此可以将读取到的最后一个字符回退| InputStream ,通常作为编译期的扫描器，之所以包含在内是java编译器的需要，我们可能永远不会用到
