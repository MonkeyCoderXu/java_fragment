
while(true) {  

02     Socket socket = server.accept();   

03     new Thread() {  

04         public void run() {  

05             InputStream in = socket.getInputStream();  

06             while(true) {//input逻辑  

07                 in.read(...)  

08             }     

09         }    

10     }.start()     

11     new Thread() {  

12             //类似input  

13       }.start()   

14 } 
