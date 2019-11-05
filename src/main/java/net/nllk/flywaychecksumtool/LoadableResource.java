package net.nllk.flywaychecksumtool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;

/*
 * LATEST: https://github.com/flyway/flyway/blob/master/flyway-core/src/main/java/org/flywaydb/core/internal/resource/LoadableResource.java
 * USED: https://github.com/flyway/flyway/blob/66ed42c/flyway-core/src/main/java/org/flywaydb/core/internal/resource/LoadableResource.java
 */

public class LoadableResource {

    public static int checksum(String filePath) {

        final File file = new File(filePath);
        final CRC32 crc32 = new CRC32();

        try (FileReader fileReader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(fileReader, 4096); ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line != null) {
                    line = BomFilter.FilterBomFromString(line);

                    do {
                        crc32.update(StringUtils.trimLineBreak(line).getBytes(StandardCharsets.UTF_8));
                    } while ((line = bufferedReader.readLine()) != null);

                }
            }
        } catch (IOException e) {
            System.out.printf("Error while trying to read file %s: %s\n", filePath, e.getMessage());
            System.exit(1);
        }

        int checksum = (int) crc32.getValue();
        return checksum;
    }

}
