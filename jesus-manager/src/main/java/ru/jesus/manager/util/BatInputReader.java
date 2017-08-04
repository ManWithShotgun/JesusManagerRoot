package ru.jesus.manager.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ILIA on 11.07.2017.
 */
public class BatInputReader extends Thread {
    private InputStreamReader is;
    private BufferedReader buffer;
    private boolean isRead = true;

    BatInputReader(InputStreamReader is) {
        this.is = is;
        this.buffer = new BufferedReader(is);
    }

    public void run() {
        try {

//                String line=null;
//                while ((line = buffer.readLine()) != null) {
//                    System.out.println(line);
//                }

            int c;
            while (isRead) {
                if(is.ready()) {
                    c = is.read();
                    //System.out.println(c + " : " + isRead);
                    System.out.write(c);
                    //System.out.println(is.ready());
                }
            }
            System.out.println("STOP while");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            System.out.println("STOP BatInputReader1");
            try {
                if (is != null) is.close();
            } catch (Exception Ex) {
                //TODO-ilia create log exception: can't create thread
            }
            try {
                if (buffer != null) buffer.close();
            } catch (Exception Ex) {
                //TODO-ilia create log exception: can't create thread
            }
        }
        System.out.println("STOP BatInputReader");
    }

    public void destroyRead(){
        this.isRead = false;
    }

    /*

    Код для записи в асинхрон. Может пригодиться.
    *
    * public static class StreamGobbler2 extends Thread {
        OutputStream os;

        StreamGobbler2(OutputStream os) {
            this.os = os;
        }

        public void run() {
            int intval=0;
            byte[] b = new byte[80];
            String line = null;

            try {
                while ((intval = System.in.read())!=-1) {
                    os.write(intval);
                    os.flush();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            System.out.println("Gobber 2 ended");
        }

    }
    */
}
