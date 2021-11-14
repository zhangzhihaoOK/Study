package com.zzh.mybatis.DailyStudy.Text;


import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class client {
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        ByteArrayOutputStream bao = null;
        try {
            InetAddress ia = InetAddress.getByName("127.0.0.1");
            socket = new Socket(ia,7788);
            os = socket.getOutputStream();
            fis = new FileInputStream(new File("靓仔.jpg"));
            byte[] cbuf = new byte[50];
            int len;
            while((len = fis.read(cbuf)) != -1){
                os.write(cbuf,0,len);
            }
            socket.shutdownOutput();
            is = socket.getInputStream();
            bao = new ByteArrayOutputStream();
            byte[] buf = new byte[10];
            int leng;
            while((leng = is.read(buf))!= -1){
                bao.write(buf,0,leng);
            }
            System.out.println(bao.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {if(bao != null){
            try {
                bao.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } if(is != null){
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            if(os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void Server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream fr = null;
        FileOutputStream fos = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(7788);
            socket = ss.accept();

            fr = socket.getInputStream();

            fos = new FileOutputStream("靓仔777.jpg");

            byte[] cbuf = new byte[50];
            int len;
            while((len = fr.read(cbuf)) != -1){
                fos.write(cbuf,0,len);
            }
            os = socket.getOutputStream();
            os.write("你好,你发送的图片我已经收到了".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {if(os != null){
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if(fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }if(ss != null) {
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}