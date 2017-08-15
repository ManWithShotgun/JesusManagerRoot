package ru.jesus.manager.util;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ILIA on 15.08.2017.
 */
public class CmdCommandInvoker {
    private final String ENCODE = "windows-1251";
    private String[] command;
    protected String cmdOut;

    public CmdCommandInvoker(String[] command) {
        this.command = command;
    }

    public CmdCommandInvoker(String commandLine) {
        String[] commands = commandLine.replaceAll("[\\s]{2,}", " ").trim().split(" ");
        this.command = concat(new String[]{"cmd.exe", "/C"}, commands);
    }

    private String[] concat(String[] a, String[] b) {
        int aLen = a.length;
        int bLen = b.length;
        String[] c = new String[aLen + bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }

    public void execute() {
        try {
            ProcessBuilder pb = new ProcessBuilder(command);
            pb.redirectErrorStream(true);// если флаг ProcessBuilder.redirectErrorStream() выставлен в true, то stderr будет слит с stdout, и errors будет пуст.
            Process process = pb.start();
            BatInputReader outputGobbler = new BatInputReader(new InputStreamReader(process.getInputStream(), ENCODE));
            outputGobbler.setBuff(true);
            outputGobbler.start();
            try {
                System.out.println("wait");
                process.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end");
            cmdOut = outputGobbler.getBuffStr();
            outputGobbler.destroyRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("STOP BatRunner");
    }
}
