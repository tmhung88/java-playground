An example on how to configure JDBI + Spring Transaction + Spring Boot. 
@JdbiRepository is a custom annotation to register a JDBI dao instead of manually retrieving it from DBI. In order to use
this annotation, please enable it by putting this snippet of code in one of configuration classes
````
@Import(JdbiRepositoryScanRegistrar.class)
@JdbiRepositoryScan("net.tmhung.example.repository")
````