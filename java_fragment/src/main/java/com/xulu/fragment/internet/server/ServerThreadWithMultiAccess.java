
public static void run() {  

02     Selector selector=Selector.open();  

03     ServerSocketChannel ssc=ServerSocketChannel.open();  

04     ssc.configureBlocking(false); //设置为非阻塞  

05     ServerSocket ss = ssc.socket(); //用来监听连接的ServerSocket  

06     ss.bind(new InetSocketAddress(26666)); //绑定端口  

07     ssc.register(selector,SelectionKey.OP_ACCEPT); //注册有新连接  

08    

09     Iterator<SelectionKey> iter=selectionKeys.iterator();  

10         while(iter.hasNext()){  

11             SelectionKey key=iter.next();  

12             if((key.readyOps()&SelectionKey.OP_ACCEPT)==SelectionKey.OP_ACCEPT)  

13             { //如果有新的连接请求，则新建一个SocketChannel  

14                 ServerSocketChannel nssc=(ServerSocketChannel)key.channel();  

15                 SocketChannel sc=nssc.accept();  

16                 sc.configureBlocking(false); //非阻塞  

17                 sc.register(selector, SelectionKey.OP_READ); //监听READ操作  

18             }else if((key.readyOps()&SelectionKey.OP_READ)==SelectionKey.OP_READ) {  

19         //此socket上有数据可以读入   

20                 SocketChannel sc=(SocketChannel)key.channel();  

21                 ByteBuffer echoBuffer=ByteBuffer.allocate(20);   

22                 echoBuffer.clear();  

23                 int a=sc.read(echoBuffer); //读入数据  

24                 echoBuffer.flip();  

25                 //处理数据  

26             }  

27         }  

28 } 
