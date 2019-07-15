# ADVANCED SPRING: HOW DOES SPRING WORK INTERNALLY?


-  The Spring Bean Lifecycle
-  The BeanFactoryPostProcessor interception point
-  The BeanPostProcessor interception point
-  Spring Bean Proxies
-  @Bean method return types



The important Aware interfaces are:

ApplicationContextAware – to inject ApplicationContext object, example usage is to get the array of bean definition names.
BeanFactoryAware – to inject BeanFactory object, example usage is to check scope of a bean.
BeanNameAware – to know the bean name defined in the configuration file.
ResourceLoaderAware – to inject ResourceLoader object, example usage is to get the input stream for a file in the classpath.
ServletContextAware – to inject ServletContext object in MVC application, example usage is to read context parameters and attributes.
ServletConfigAware – to inject ServletConfig object in MVC application, example usage is to get servlet config parameters.