INTRODUCTION TO SPRING
*  Java configuration and the Spring application context
*  @Configuration and @Bean annotations
*  @Import: working with multiple configuration files
*  Defining bean scopes
*  Launching a Spring Application and obtaining Beans

SPRING JAVA CONFIGURATION: A DEEPER LOOK
*  External properties & Property sources
*  Environment abstraction
*  Using bean profiles
*  Spring Expression Language (SpEL)
*  How it Works: Inheritance based proxies

ANNOTATION-BASED DEPENDENCY INJECTION
*  Autowiring and component scanning
*  Java configuration versus annotations, mixing.
*  Lifecycle annotations: @PostConstruct and @PreDestroy
*  Stereotypes and meta-annotations

FACTORY PATTERN IN SPRING
*  Using Spring FactoryBeans

ADVANCED SPRING: HOW DOES SPRING WORK INTERNALLY?
*  The Spring Bean Lifecycle
*  The BeanFactoryPostProcessor interception point
*  The BeanPostProcessor interception point
*  Spring Bean Proxies
*  @Bean method return types

ASPECT-ORIENTED PROGRAMMING
*  What problems does AOP solve?
*  Differences between Spring AOP and AspectJ
*  Defining pointcut expressions
*  Implementing an advice: @Around, @Before, @After

TESTING A SPRING-BASED APPLICATION
*  Spring and Test Driven Development
*  Spring 5 integration testing with JUnit 5
*  Application context caching and the @DirtiesContext annotation
*  Profile selection with @ActiveProfiles
*  Easy test data setup with @Sql

DATA ACCESS AND JDBC WITH SPRING
*  How Spring integrates with existing data access technologies
*  DataAccessException hierarchy
*  Implementing caching using @Cacheable • Embedded databases for testing
*  Spring‘s JdbcTemplate

DATABASE TRANSACTIONS WITH SPRING
*  Transactions overview
*  Transaction management with Spring
*  Isolation levels, transaction propagation and rollback rules
*  Transactions and integration testing

SPRING BOOT INTRODUCTION
*  Introduction to Spring Boot
*  Value Proposition of Spring Boot
*  Creating a simple Boot application using Spring Initializr web-site

SPRING BOOT DEPENDENCIES, AUTO-CONFIGURATION AND RUNTIME
*  Dependency management using Spring Boot starters
*  How auto-configuration works
*  Configuration properties
*  Overriding auto-configuration
*  Using CommandLineRunner

JPA WITH SPRING AND SPRING DATA
*  Quick introduction to ORM with JPA
*  Benefits of using Spring with JPA
*  JPA configuration in Spring
*  Configuring Spring JPA using Spring Boot
*  Spring Data JPA dynamic repositories

SPRING MVC ARCHITECTURE AND OVERVIEW
*  Introduction to Spring MVC and request processing
*  Controller method signatures
*  Using @Controller, @RestController and @GetMapping annotations
*  Configuring Spring MVC with Spring Boot
*  Spring Boot packaging options, JAR or WAR

REST WITH SPRING MVC
*  An introduction to the REST architectural style
*  Controlling HTTP response codes with @ResponseStatus
*  Implementing REST with Spring MVC, @RequestMapping, @RequestBody and @ResponseBody
*  Spring MVC’s HttpMessageConverters and automatic content negotiation

SPRING SECURITY
*  What problems does Spring Security solve?
*  Configuring authentication
*  Implementing authorization by intercepting URLs
*  Authorization at the Java method level
*  Understanding the Spring Security filter chain

ACTUATORS, METRICS AND HEALTH INDICATORS
*  Enabling Spring Boot Actuator
*  Custom Metrics
*  Health Indicators
*  Creating custom Health Indicators
*  External monitoring systems

SPRING BOOT TESTING ENHANCEMENTS
*  Spring Boot testing overview
*  Integration testing and slices
*  Slices to test different layers of the application
