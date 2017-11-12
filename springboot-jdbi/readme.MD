An example on how to configure JDBI + Spring Transaction + Spring Boot. 
@JdbiRepository is a custom annotation to register a JDBI dao instead of manually retrieving it from DBI. In order to use
this annotation, please enable it by putting this snippet of code in one of configuration classes
````
@EnableJdbiRepository("net.tmhung.example.repository")
````

How to run

- Install Maven 3 and JDK 8
- Under the project directory, run this command
```bash
mvn spring-boot:run
```
- Sample logs if it's launched successfully
````
017-11-13 00:07:59.292  WARN 22599 --- [           main] n.t.example.listener.StartUpListener     : On Startup do something ....
2017-11-13 00:07:59.343  INFO 22599 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2017-11-13 00:07:59.354  INFO 22599 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Started.
2017-11-13 00:07:59.605  INFO 22599 --- [           main] n.t.example.service.HelloWorldService    : [name=ACCOUNTING, location=NEW YORK]
2017-11-13 00:07:59.606  INFO 22599 --- [           main] n.t.example.service.HelloWorldService    : [name=RESEARCH, location=DALLAS]
2017-11-13 00:07:59.606  INFO 22599 --- [           main] n.t.example.service.HelloWorldService    : [name=SALES, location=CHICAGO]
2017-11-13 00:07:59.606  INFO 22599 --- [           main] n.t.example.service.HelloWorldService    : [name=OPERATIONS, location=BOSTON]
2017-11-13 00:07:59.608  INFO 22599 --- [           main] net.tmhung.example.App                   : Started App in 2.624 seconds (JVM running for 5.71)

````