package ru.jesus.manager.util;

import java.io.*;

/**
 * Created by ILIA on 11.07.2017.
 */
public class BatRunner extends Thread {

    private Process process;
    private final String dirBat;
    private final String nameBat;

    public BatRunner(String dirBat, String nameBat) {
        this.dirBat = dirBat;
        this.nameBat = nameBat;
    }


    @Override
    public void run() {
        execBat("windows-1251");
    }

    /**
     * Выполнить команду операционной системы
     * @param szEncoding - кодировка, в которой выводится сообщение в консоль ОС
     */
    private void execBat(String szEncoding){
        try {
            ProcessBuilder pb = new ProcessBuilder(nameBat);
            pb.redirectErrorStream(true);// если флаг ProcessBuilder.redirectErrorStream() выставлен в true, то stderr будет слит с stdout, и errors будет пуст.
            pb.directory(new File(dirBat));
            process = pb.start();
            System.out.println(process.getClass().getName());
            BatInputReader outputGobbler = new BatInputReader(new InputStreamReader(process.getInputStream(), szEncoding));
            outputGobbler.start();
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            outputGobbler.destroyRead();
            //FIXME-ilia: нелзя закрыть Login server. Закрывается только консоль. Надо либо послать ^C либо получить PID и убить процесс.
//            process.destroy();
//            pb.directory();

//            this.destroyBat();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("STOP BatRunner");
    }

    public void destroyBat(){
        process.destroy();
        System.out.println("DESTROY");
    }
}
