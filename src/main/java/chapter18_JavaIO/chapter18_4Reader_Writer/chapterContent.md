##Reader和Writer
1、Reader和Writer不是用来替代InputStream和OutputStream的类<br>
2、InputStream和OutputStream在以字节形式的I/O中提供极有价值的功能；Reader和Writer提供兼容Unicode和面向字符的I/O<br>
3、有时候我们必须把来自“字符“层次结构的类和来自“字节”层次结构的类结合起来使用。这时就要用到适配器类（**Adapter**）：InputStreamReader可以把InputStream转换成Reader，OutputStreamWriter可以把outputStream转换成Writer<br>

设计Reader和Writer主要为了国际化。老的I/O流继承层次结构仅支持8位字节流，并不能很好的处理16位Unicode字符流。添加Reader和Writer就是为了在所有的I/O操作中支持Unicode

###18.4.1 数据的来源以及去处
尽量使用Reader和Writer，程序无法成功编译，就不得不使用面向字节的类库。

###18.4.2 更改流的行为
对于InputStream和OutputStream，使用FilterInputStream和FilterOutputStream的装饰器子类来修改流以满足特殊需求。<br>
Reader和Writer的情况类似。使用readLine()要使用BufferedReader，除此之外要有限使用DataInputStream