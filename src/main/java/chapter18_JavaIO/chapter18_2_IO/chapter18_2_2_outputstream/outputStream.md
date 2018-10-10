##OutputStream类型
**OutputStream**决定了输出要去往的目标：字节数组、文件或管道
##数据源：
|    类              | 功能 | 如何使用 |
| -------------------| --- | ---------|
| ByteArrayOutputStream | 在内存中创建缓冲区，所有送往流的数据都要放置在此缓冲区 |缓冲区初始化尺寸（可选），指定数据的目的地：将其与FilterOutputStream相连以提供有用的接口 |
| FileOutputStream |  将信息写入文件 |字符串，表示文件名、文件或FileDescription对象。指定数据的目的地：将其与FilterOutputStream相连以提供有用的接口|
| PipedOutputStream | 任何写入其中的数据都会作为PipedInputStream的输出，实现“管道化”概念 |作为多线程的数据的目的地：将其与FilterOutputStream相连以提供有用的接口|
| FilterOutputStream | 抽象类，作为装饰器的接口，装饰器为其他OutputStream提供有用的功能 ||
