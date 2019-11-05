package net.nllk.flywaychecksumtool;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;

public class FlywayChecksumTool {

    public static void main(String[] args) {

        if (args.length != 1) {
            printHelpAndExit();
        }

        if (args[0].equals("-h") || args[0].equals("--help")) {
            printHelpAndExit();
        }

        int checksum = LoadableResource.checksum(args[0]);
        System.out.printf("Checksum: %d, File: %s\n", checksum, args[0]);
    }

    private static void printHelpAndExit() {
        System.out.println("Usage: java -jar flyway-checksum-tool <path to file>");
        System.exit(0);
    }

}
