###### This rest service consumes an other one.

**Steps:**

1- cd {PATH}/spring_rest_consume

2- mvn clean install

3- java -jar target/spring_rest_consume-1.0-SNAPSHOT.jar 

OR

2'- mvn spring-boot:run

**Result**

`2016-03-15 21:57:26.705  INFO 16245 --- [main] c.m.spring.rest.consume.Application      : Quote{type='success', value=Quote{type='5', value=Spring Boot solves this problem. It gets rid of XML and wires up common components for me, so I don't have to spend hours scratching my head just to figure out how it's all pieced together.}}`
