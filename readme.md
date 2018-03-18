bq Spring 5 architecture .

main web app 
  : spring core
  : spring tx 
  : dpring hibernate/jpa 2.=
  : module elatsic search 5.5.0 with spring data elastic search

we defined plugin to embeded tomcat 7 : 
  command for use : 
    bq> mvn clean package -Pembeded-tomcat tomcat7:run

for CI/CD pipelining test : 

  for unit test only : 
    bq> mvn clean test -DskipITtest // you can ommit the parameter
  for integration test only : 
    bq> mvn clean package -DskipTests failsafe:integration-test

     