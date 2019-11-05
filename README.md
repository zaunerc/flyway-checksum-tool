# flyway-checksum-tool

A simple tool which can be used to calculate the [Flyway](https://flywaydb.org)
checksum for a given file. Flyway uses the CRC32 algorithm for checksum generation. 

## Usage

1. `$ ./gradlew build`
1. `$ java -jar build/libs/flyway-checksum-tool.jar <path to file>`

## Example run

```shell script
user@host:~/devel/flyway-checksum-tool$ java -jar build/libs/flyway-checksum-tool.jar /home/user/devel/spring-boot-project/src/main/resources/db/migration/V000001__initial_schema.sql
Checksum: 1159271788, File: /home/user/devel/spring-boot-project/src/main/resources/db/migration/V000001__initial_schema.sql
user@host:~/devel/flyway-checksum-tool$ 
```

## Futher hints

* https://flywaydb.org/documentation/commandline/repair
