package ru.jesus.manager.util;

import java.io.*;
import java.util.Arrays;

/**
 * Created by ILIA on 14.08.2017.
 */
public class CloseProcessOnPort {

    public static void main(String[] args) {
//        new CloseProcessOnPort(new String[]{"cmd.exe", "/C", "echo", "%PATH%"}).start();
//        new CloseProcessOnPort(new String[]{"cmd.exe", "/C", "netstat", "-a", "-o", "|", "findstr", "1505"}).start();
        new CloseProcessOnPort(9014);

    }

    public CloseProcessOnPort(int port) {
        String pid = new CmdSelectPID(port).selectPID();
        System.out.println("PID " + pid);
        new CmdKillProcess(Integer.parseInt(pid)).kill();
    }
}
