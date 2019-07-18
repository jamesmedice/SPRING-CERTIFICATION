# ASPECT-ORIENTED PROGRAMMING


- What problems does AOP solve?
- Differences between Spring AOP and AspectJ
- Defining pointcut expressions
- Implementing an advice: @Around, @Before, @After


Method Signature Patterns

execution(* com.aspects.pointcut.DemoClass.*(..)) : This advice will be applied to all the methods of DemoClass.
execution(* DemoClass.*(..)): You can omit the package if the DemoClass and the advice is in the same package.
execution(public * DemoClass.*(..)): This advice will be applied to the public methods of DemoClass.
execution(public int DemoClass.*(..)): This advice will be applied to the public methods of DemoClass and returning an int.
execution(public int DemoClass.*(int, ..)): This advice will be applied to the public methods of DemoClass and returning an int and having first parameter as int.
execution(public int DemoClass.*(int, int)): This advice will be applied to the public methods of DemoClass and returning an int and having both parameters as int.

within(com.aspects.blog.package.*) : This will match all the methods in all classes of com.aspects.blog.package.
within(com.aspects.blog.package..*) : This will match all the methods in all classes of com.aspects.blog.package and its sub packages. The only difference is the extra dot(.) after package.
within(com.aspects.blog.package.DemoClass) : This will match all the methods in the DemoClass.
within(DemoClass) : Again, if the target class is located in the same package as this aspect, the package name can be omitted.
within(DemoInterface+) : This will match all the methods which are in classes which implement DemoInterface.