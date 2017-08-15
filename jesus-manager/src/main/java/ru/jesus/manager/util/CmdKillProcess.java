package ru.jesus.manager.util;

/**
 * Created by ILIA on 15.08.2017.
 */
public class CmdKillProcess extends CmdCommandInvoker {

    public CmdKillProcess(int pid) {
        super(String.format("taskkill -PID %d -F", pid));
    }

    public void kill() {
        this.execute();
        System.out.println("Kill: " + cmdOut);
    }
}
