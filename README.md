#################################
#  Sample Spring AOP Projects   #
#################################

## Dependency Injection
- @Autowiredinject other Spring beans

## Java Config
- @Configuration for configuration class
- @ComponentScanto scan a package for Spring beans
- @Component, @Service, @Repository to mark Spring beans
- @Bean method creates a Spring bean

## XML configuration
- bean element defines Spring bean
- annotation-configto enable @Autowired
- component-scan element to scan a package for Spring beans

## Spring test framework
- @RunWithenables Spring support
- @ContextConfigurationpoints to XML configuration / Java Config

## AOP cross-cutting concerns:
- Tracing
- Exception handling
- Transactions
- Security

## Result
- Code tangling: Multiple concerns in each piece of code
- Code scattering: Aspects are not implemented in one place

## Aspect =
- Advice - what code is executed +
- Pointcut - where the code is executed
- Aspects are Spring Beans
- Add @Aspect annotation
- Advices are methods
- @Before annotation
- Contains pointcut expression

```sh
<beans>
   <aop:aspectj-autoproxy />
   <context:component-scan base-package="simpleaspect" />
</beans>
```

## Advices
- Before Advice
- After Advice
- Around Advice
- After Throwing
- After Returning


## Pointcuts:
- Where should an advice be added?
- Method Execution Pointcut
- return type
- package name
- class name
- method name
- parameters
- Power through wildcards
- Can also use annotations
- Bean name pointcut
- Boolean operators
- Pointcuts can be reused (@Pointcut)

```java
public class MyPointcuts {
   @Pointcut("execution(@annotation.Trace* *(..))")
   public void traceAnnotated() {
   }
}

Use @Pointcut annotation
Note: Method’s purpose is just to be annotated

@Around("MyPointcuts.traceAnnotated()")
   public void trace(ProceedingJoinPoint proceedingJP) throwsThrowable {
   }
````

## Some pointcuts expressions
```java
Execution of method hello, no parameters, any return type
execution(* hello())

Execution of method hello, two intsas parameters, any return type
execution(* hello(int, int))

Execution of method hello, one parameter of any type, any return type
execution(* hello(*))

Execution of method hello, any number of parameters of any type, any return type
execution(* hello(..))

Execution of method hello in class Service in package com.ewolff one intsas parameters, intreturn type
execution(intcom.ewolff.Service.hello(int))

Execution of any method class name ends in Service in package com.ewolffor subpackage any parameters any return type
execution(* com.ewolff..*Service.*(..))

Execution of any method Any parameters in any class in the default package
execution(* *.*(..))

Execution of any method Any parameters in any class in any package or subpackage
execution(* *..*.*(..))

Method must be annotated, Note: fully qualified class name of the Annotation
execution(@com.ewolff.Annotation* *(..))

Class must be annotated
execution(* (@com.ewolff.Annotation*).*(..))

Method in Spring Bean, Bean name ends in ..Service, Bean name default: class name (small caps)
Java Config: @Bean method name, Annotation: parameter to @Component, @Service, @Repository
XML: name / id attribute of bean element
bean(*Service)

Pointcuts can be combined using booleanoperators i.e. || , && , !
execution(* service.*.*(..)) || execution(* repository.*.*(..))
```

## AOP Proxy

CGLIB
- Subclass dynamically create subclass
- Subclass implements the proxy

Dynamic Proxies
- Feature of the JDK
- Allow dynamic method dispatch
- For interfaces only

CGLIB is used
- if no interface is implemented
- if proxy-target-class is set to true

## Compile Time Weaving vs. Load Time Weaving
Pros Compile Time Weaving
- No modification to the environment
- No aop.xmlneeded
- Faster application startup
- Can add errors / warning

Cons Compile Time Weaving
- Cannot weave classes w/o source code
- i.e. LTW can even modify JDK classes
- Different compiler
- Compiler slower (Eclipse AJDT helps)

Prefer Compile Time Weaving - the simplest approach

## AspectJ vs. Spring AOP
Pros AspectJ
- Performance much better
- Clearer model –also indirect calls can be advised
- Can also advise constructor, field access, protected methods etc

Cons AspectJ
- Spring AOP performance usually sufficient
- Need to use different compiler / modify execution environment
- Spring AOP is already built into Spring


AspectJ is more powerful and has better performance


react.js
node/express.js
