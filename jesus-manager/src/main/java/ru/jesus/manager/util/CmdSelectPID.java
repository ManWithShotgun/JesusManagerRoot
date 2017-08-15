package ru.jesus.manager.util;

/**
 * Created by ILIA on 15.08.2017.
 */
public class CmdSelectPID extends CmdCommandInvoker {

    private int port;

    public CmdSelectPID(int port) {
        super("netstat -a -o | findstr " + port);
        this.port = port;
    }

    public String selectPID() {
        this.execute();
        String[] lines = cmdOut.split("\n");
        if (lines.length == 0) {
            System.out.println("No result search");
            //TODO-ilia throw exception
        }
        if (lines.length > 1) {
            System.out.println("Count results: " + lines.length);
        }
        String firstResult = lines[0];
        firstResult = firstResult.replaceAll("[\\s]{2,}", " ").trim();
        String[] firstResultColumns = firstResult.split(" ");
        if (!firstResultColumns[1].endsWith(":" + port)) {
            System.out.println("Bad first result");
            //TODO-ilia throw exception
        }
        return firstResultColumns[4];
    }
}
