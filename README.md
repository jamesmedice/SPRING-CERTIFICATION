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



QUESTIONS 
[Container, Dependency, And IOC][][]
[Container, Dependency, And IOC][What is dependency injection and what are the advantages?][]
[Container, Dependency, And IOC][What is an interface and what are the advantages of making use of them in Java?][]
[Container, Dependency, And IOC][What is meant by "container" and how do you create one?][]
[Container, Dependency, And IOC][What is the concept of a container and what is its lifecycle?][]
[Container, Dependency, And IOC][Dependency injection using Java configuration][]
[Container, Dependency, And IOC][Dependency injection in XML, using constructor or setter injection][]
[Container, Dependency, And IOC][Dependency injection using annotations (@Component, @Autowired)][]
[Container, Dependency, And IOC][Component scanning, Stereotypes and Meta-Annotations][]
[Container, Dependency, And IOC][Scopes for Spring beans. What is the default?][]
[Container, Dependency, And IOC][What is an initialization method and how is it declared in a Spring bean?][]
[Container, Dependency, And IOC][What is a destroy method, how is it declared and when is it called?][]
[Container, Dependency, And IOC][What is a BeanFactoryPostProcessor and what is it used for?][]
[Container, Dependency, And IOC][What is a BeanPostProcessor and how is the difference to a BeanFactoryPostProcessor? What do they do? When are they called?][]
[Container, Dependency, And IOC][Are beans lazily or eagerly instantiated by default? How do you alter this behavior?][]
[Container, Dependency, And IOC][What does component-scanning do?][]
[Container, Dependency, And IOC][What is the behavior of the annotation @Autowired with regards to field injection, constructor injection and method injection?][]
[Container, Dependency, And IOC][How does the @Qualifier annotation complement the use of @Autowired?][]
[Container, Dependency, And IOC][What is the role of the @PostConstruct and @PreDestroy annotations? When will they get called?][]
[Container, Dependency, And IOC][What is a proxy object and what are the two different types of proxies Spring can create?][]
[Container, Dependency, And IOC][What is the power of a proxy object and where are the disadvantages?][]
[Container, Dependency, And IOC][What are the limitations of these proxies (per type)?][]
[Container, Dependency, And IOC][How do you inject scalar/literal values into Spring beans?][]
[Container, Dependency, And IOC][How are you going to create a new instance of an ApplicationContext?][]
[Container, Dependency, And IOC][What is a prefix?][]
[Container, Dependency, And IOC][What is the lifecycle on an ApplicationContext?][]
[Container, Dependency, And IOC][What does the @Bean annotation do?][]
[Container, Dependency, And IOC][How are you going to create an ApplicationContext in an integration test or a JUnit test?][]
[Container, Dependency, And IOC][What do you have to do, if you would like to inject something into a private field?][]
[Container, Dependency, And IOC][What are the advantages of JavaConfig? What are the limitations?][]
[Container, Dependency, And IOC][What is the default bean id if you only use "@Bean"?][]
[Container, Dependency, And IOC][Can you use @Bean together with @Profile?][]
[Container, Dependency, And IOC][What is Spring Expression Language (SpEL for short)?][]
[Container, Dependency, And IOC][What is the environment abstraction in Spring?][]
[Container, Dependency, And IOC][How do you configure a profile. What are possible use cases where they might be useful?][]
[Container, Dependency, And IOC][How many profiles can you have?][]
[Container, Dependency, And IOC][How do you enable JSR-250 annotations like @PostConstruct?][]
[Container, Dependency, And IOC][Why are you not allowed to annotate a final class with @Configuration][]
[Container, Dependency, And IOC][Which application context implementation are you using when you have used @Configuration?][]
[Container, Dependency, And IOC][Why must you have to have a default constructor in your @Configuration annotated class?][]
[Container, Dependency, And IOC][Why are you not allowed to annotate final methods with @Bean?][]
[Container, Dependency, And IOC][What is the preferred way to close an application context?][]
[Container, Dependency, And IOC][How can you create a shared application context in a JUnit test?][]
[Container, Dependency, And IOC][What does a static @Bean method do?  What is a ProperySourcesPlaceholderConfigurer used for?  What is a namespace used for in XML configuration?][]
[Container, Dependency, And IOC][If you saw one of the <context/> elements covered in the course, would you know what it does?  What is @Value used for?  What is the difference between $ and # in @Value expressions?][]
[The Aspect-Oriented Programming][][]
[The Aspect-Oriented Programming][What is the concept of AOP? Which problem does it solve?][]
[The Aspect-Oriented Programming][What is a pointcut, a join point, an advice, an aspect, weaving?][]
[The Aspect-Oriented Programming][How does Spring solve (implement) a cross cutting concern?][]
[The Aspect-Oriented Programming][Which are the limitations of the two proxy-types?][]
[The Aspect-Oriented Programming][How many advice types does Spring support. What are they used for?][]
[The Aspect-Oriented Programming][What do you have to do to enable the detection of the @Aspect annotation?][]
[The Aspect-Oriented Programming][Name three typical cross cutting concerns.][]
[The Aspect-Oriented Programming][What two problems arise if you don't solve a cross cutting concern via AOP?][]
[The Aspect-Oriented Programming][What does @EnableAspectJAutoProxy do?][]
[The Aspect-Oriented Programming][What is a named pointcut?][]
[The Aspect-Oriented Programming][How do you externalize pointcuts? What is the advantage of doing this?][]
[The Aspect-Oriented Programming][What is the JoinPoint argument used for?][]
[The Aspect-Oriented Programming][What is a ProceedingJoinPoint?][]
[The Aspect-Oriented Programming][How are the five advice types called?][]
[The Aspect-Oriented Programming][Which advice do you have to use if you would like to try and catch exceptions?][]
[The Aspect-Oriented Programming][What is the difference between @EnableAspectJAutoProxy and <aop:aspectjautoproxy>?][]
[JDBC, Transactions, And ORM][][]
[JDBC, Transactions, And ORM][What is the difference between checked and unchecked exceptions?][]
[JDBC, Transactions, And ORM][Why do we (in Spring) prefer unchecked exceptions?][]
[JDBC, Transactions, And ORM][What is the data access exception hierarchy?][]
[JDBC, Transactions, And ORM][How do you configure a DataSource in Spring? Which bean is very useful for development?][]
[JDBC, Transactions, And ORM][What is the Template design pattern and what is the JDBC template?][]
[JDBC, Transactions, And ORM][What is a callback? What are the three JdbcTemplate callback interfaces described in the notes? What are they used for? ][]
[JDBC, Transactions, And ORM][Can you execute a plain SQL statement with the JDBC template?][]
[JDBC, Transactions, And ORM][Does the JDBC template acquire (and release) a connection for every method called or once per template?][]
[JDBC, Transactions, And ORM][Is the JDBC template able to participate in an existing transaction?][]
[JDBC, Transactions, And ORM][What is a transaction? What is the difference between a local and a global transaction?][]
[JDBC, Transactions, And ORM][Is a transaction a cross cutting concern? How is it implemented in Spring?][]
[JDBC, Transactions, And ORM][How are you going to set up a transaction in Spring?][]
[JDBC, Transactions, And ORM][What does @Transactional do? What is the PlatformTransactionManager?][]
[JDBC, Transactions, And ORM][What is the TransactionTemplate? Why would you use it?][]
[JDBC, Transactions, And ORM][What is a transaction isolation level? How many do we have and how are they ordered?][]
[JDBC, Transactions, And ORM][What is the difference between @EnableTransactionManagement and <tx:annotation-driven>?][]
[JDBC, Transactions, And ORM][How does the JdbcTemplate support generic queries? How does it return objects and lists/maps of objects?][]
[JDBC, Transactions, And ORM][What does transaction propagation mean?][]
[JDBC, Transactions, And ORM][What happens if one @Transactional annotated method is calling another @Transactional annotated method on the same object instance?][]
[JDBC, Transactions, And ORM][Where can the @Transactional annotation be used? What is a typical usage if you put it at class level?][]
[JDBC, Transactions, And ORM][What does declarative transaction management mean?][]
[JDBC, Transactions, And ORM][What is the default rollback policy? How can you override it?][]
[JDBC, Transactions, And ORM][What is the default rollback policy in a JUnit test, when you use the SpringJUnit4ClassRunner and annotate your @Test annotated method with @Transactional?][]
[JDBC, Transactions, And ORM][Why is the term "unit of work" so important and why does JDBC AutoCommit violate this pattern?][]
[JDBC, Transactions, And ORM][What does JPA mean - what is ORM? What is the idea behind an ORM?][]
[JDBC, Transactions, And ORM][What is a PersistenceContext and what is an EntityManager. What is the relationship between both?][]
[JDBC, Transactions, And ORM][Why do you need the @Entity annotation. Where can it be placed?][]
[JDBC, Transactions, And ORM][What do you need to do in Spring if you would like to work with JPA?][]
[JDBC, Transactions, And ORM][Are you able to participate in a given transaction in Spring while working with JPA?][]
[JDBC, Transactions, And ORM][What is the PlatformTransactionManager?][]
[JDBC, Transactions, And ORM][What does @PersistenceContext do?][]
[JDBC, Transactions, And ORM][What are disadvantages or ORM? What are the benefits?][]
[JDBC, Transactions, And ORM][What is an "instant repository"? (hint: recall Spring Data)][]
[JDBC, Transactions, And ORM][How do you define an instant repository?  What is @Query used for?][]
[Spring MVC And The Web Layer][][]
[Spring MVC And The Web Layer][MVC is an abbreviation for a design pattern. What does it stand for and what is the idea behind it?][]
[Spring MVC And The Web Layer][Do you need spring-mvc.jar in your classpath or is it part of spring-core?][]
[Spring MVC And The Web Layer][What is the DispatcherServlet and what is it used for?][]
[Spring MVC And The Web Layer][Is the DispatcherServlet instantiated via an application context?][]
[Spring MVC And The Web Layer][What is the root application context? How is it loaded?][]
[Spring MVC And The Web Layer][What is the @Controller annotation used for? How can you create a controller without an annotation?][]
[Spring MVC And The Web Layer][What is the ContextLoaderListener and what does it do?][]
[Spring MVC And The Web Layer][What are you going to do in the web.xml. Where do you place it?][]
[Spring MVC And The Web Layer][How is an incoming request mapped to a controller and mapped to a method?][]
[Spring MVC And The Web Layer][What is the @RequestParam used for?][]
[Spring MVC And The Web Layer][What are the differences between @RequestParam and @PathVariable?][]
[Spring MVC And The Web Layer][What are some of the valid return types of a controller method?][]
[Spring MVC And The Web Layer][What is a View and what's the idea behind supporting different types of View?][]
[Spring MVC And The Web Layer][How is the right View chosen when it comes to the rendering phase?][]
[Spring MVC And The Web Layer][What is the Model?][]
[Spring MVC And The Web Layer][Why do you have access to the model in your View? Where does it come from?][]
[Spring MVC And The Web Layer][What is the purpose of the session scope?][]
[Spring MVC And The Web Layer][What is the default scope in the web context?][]
[Spring MVC And The Web Layer][Why are controllers testable artifacts?][]
[Spring MVC And The Web Layer][What does the InternalResourceViewResolver do?][]
[Spring Boot][][]
[Spring Boot][What is Spring Boot?  What are the advantages of using Spring Boot?][]
[Spring Boot][Why is it 'opinionated'?  How does it work? How does it know what to configure?][]
[Spring Boot][What things affect what Spring Boot sets up?  How are properties defined? Where?][]
[Spring Boot][Would you recognize common Spring Boot annotations and configuration properties if you saw them in the exam?  What is the difference between an embedded container and a WAR?][]
[Spring Boot][What embedded containers does Spring Boot support?  What does @EnableAutoConfiguration do? What about @SpringBootApplication?][]
[Spring Boot][What is a Spring Boot starter POM? Why is it useful?][]
[Spring Boot][Spring Boot supports both Java properties and YML files. Would you recognize and understand them if you saw them?][]
[Spring Boot][Can you control logging with Spring Boot? How?][]
[Security][][]
[Security][What is the delegating filter proxy?][]
[Security][What is the security filter chain?][]
[Security][In the notes several predefined filters were shown. Do you recall what they did and what order they occurred in?][]
[Security][Are you able to add and/or replace individual filters?][]
[Security][Is it enough to hide sections of my output (e.g. JSP-Page)?][]
[Security][Why do you need the intercept-url?][]
[Security][Why do you need method security? What type of object is typically secured at the method level (think of its purpose not its Java type).][]
[Security][Is security a cross cutting concern? How is it implemented internally?][]
[Security][What do @Secured and @RolesAllowed do? What is the difference between them?][]
[Security][What is a security context?][]
[Security][In which order do you have to write multiple intercept-url's?][]
[Security][How is a Principal defined?][]
[Security][What is authentication and authorization? Which must come first?][]
[Security][In which security annotation are you allowed to use SpEL?][]
[Security][Does Spring Security support password hashing? What is salting?][]
[REST][][]
[REST][What does REST stand for?][]
[REST][What is a resource?][]
[REST][What are safe REST operations?][]
[REST][What are idempotent operations? Why is idempotency important?][]
[REST][Is REST scalable and/or interoperable?][]
[REST][What are the advantages of the RestTemplate?][]
[REST][Which HTTP methods does REST use?][]
[REST][What is an HttpMessageConverter?][]
[REST][Is REST normally stateless?][]
[REST][What does @RequestMapping do?][]
[REST][Is @Controller a stereotype? Is @RestController a stereotype?][]
[REST][What is the difference between @Controller and @RestController?][]
[REST][When do you need @ResponseBody?][]
[REST][What does @PathVariable do?][]
[REST][What is the HTTP status return code for a successful DELETE statement?][]
[REST][What does CRUD mean?][]
[REST][Is REST secure? What can you do to secure it?][]
[REST][Where do you need @EnableWebMVC?][]
[REST][Name some common http response codes. When do you need @ResponseStatus?][]
[REST][Does REST work with transport layer security (TLS)?][]
[REST][Do you need Spring MVC in your classpath?][]
[Microservices][][]
[Microservices][What is a microservices architecture?][]
[Microservices][What are the advantages and disadvantages of microservices?][]
[Microservices][What sub-projects of Spring Cloud did we cover in the course?][]
[Microservices][Would you recognize the Spring Cloud annotations and configuration we used in the course if you saw it in the exam?][]
[Microservices][What Netflix projects did we use?][]
[Microservices][What is Service Discovery? How is this related to Eureka?][]
[Microservices][How do you setup Service Discovery?][]
[Microservices][How do you access a RESTful microservice?][]

