##InputStream类型
**InputStream**的作用是用来表示那些从不同数据源产生输入的类
##数据源：
|    类              | 功能 | 如何使用 |
| -------------------| --- | ---------|
| ByteArrayInputStream | 允许将内存的缓冲区当做Inputstream使用 |缓冲区，字节从中取出作为一种数据源：将其与FilterInputStream相连以提供有用的接口 |
| StringBufferInputStream | 将String转换成InputStream|字符串，底层实现使用StringBuffer作为一种数据源：将其与FilterInputStream相连以提供有用的接口|
| FileInputStream |  从文件中读取信息 |字符串，表示文件名、文件或FileDescription对象。作为一种数据源：将其与FilterInoputStream相连以提供有用的接口|
| PipedInputStream |  产生用于写入PipedOutPutStream的数据，实现“管道化”概念 |作为多线程中的数据源：将其与FilterInoputStream相连以提供有用的接口|
| SequenceInputStream | 将两个或多个InputStream转换成一个InputStream |两个InputStream对象或一个容纳InputStream对象的容器Enumeration，作为一种数据源：将其与FilterInoputStream相连以提供有用的接口|
| FilterInputStream | 抽象类，作为装饰器的接口，装饰器为其他InputStream提供有用的功能 ||
