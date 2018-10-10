##FilterOutputStream类型
**FilterOutputStream类型**能够完成两件不同的事情。DataOutputStream允许我们读取不同的基础类型数据和String对象。搭配相应的DataOutputStream,可以通过数据流将基本类型数据从一个地方迁移到另一个地方。
##FilterOutputStream类型：
|    类              | 功能 | 如何使用 |
| -------------------| --- | ---------|
| DataOutputStream | 与DataOutputStream搭配使用，因此我们可以按照可移植方式从流中获取基本类型数据（int、char、long） | OutputStream，包含用于读取基本类型数据的全部接口
| PrintStream | 用于产生格式化输出，DataOutputStream处理数据存储，PrintStream处理显示| OutputStream,可以用boolean指示是否在每次换行时清空缓冲区（可选的）应该是对OutputStream对象的“final"封装。可能会经常使用它
| BufferedOutputStream | 使用它避免每次发送数据都要进行实际的写操作。代表使用“缓冲区”，可以使用flush（）清空缓存 | OutputStream,可指定缓冲区大小（可选的）本质上不提供接口，只不过是在进程中添加缓冲区所必需的，与接口对象搭配