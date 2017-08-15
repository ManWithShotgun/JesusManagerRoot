package ru.jesus.manager.util;

import java.io.*;

/**
 * Created by ILIA on 11.07.2017.
 */
public class BatRunner extends Thread {

    private final String ENCODE = "windows-1251";
    //    private Process process;
    private String dirBat;
    private String nameBat;
    private String[] command;

    public BatRunner(String dirBat, String nameBat) {
        this.dirBat = dirBat;
        this.nameBat = nameBat;
    }

    public BatRunner(String[] command) {
        this.command = command;
    }

    @Override
    public void run() {
        if (command != null) {
            execCommand();
        } else {
            execBat();
        }
    }

    /**
     * Выполнить команду операционной системы
     */
    private void execBat() {
        ProcessBuilder pb = new ProcessBuilder(nameBat);
        pb.redirectErrorStream(true);// если флаг ProcessBuilder.redirectErrorStream() выставлен в true, то stderr будет слит с stdout, и errors будет пуст.
        pb.directory(new File(dirBat));
        exec(pb);
    }

    private void execCommand() {
        System.out.println("COMMAND");
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.redirectErrorStream(true);// если флаг ProcessBuilder.redirectErrorStream() выставлен в true, то stderr будет слит с stdout, и errors будет пуст.
        exec(pb);
    }

    private void exec(ProcessBuilder pb) {
        try {
            Process process = pb.start();
            System.out.println(process.getClass().getName());
            BatInputReader outputGobbler = new BatInputReader(new InputStreamReader(process.getInputStream(), ENCODE));
            outputGobbler.start();
            try {
                //вместо sleep надо ожидать клик
                System.out.println("wait");
                process.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //не закрывается сам процесс; завершает чтение с cmd
            outputGobbler.destroyRead();
            //FIXME-ilia: нелзя закрыть Login server. Закрывается только консоль. Надо либо послать ^C либо получить PID и убить процесс.
            // сделать WinProcClose кототый будет закрывать процеес по определенному порту
//            process.destroy();
//            pb.directory();

//            this.destroyBat();
            System.out.println("STOP BatRunner");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
