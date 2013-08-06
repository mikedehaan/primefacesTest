primefacesTest
==============

Testing primefaces functionality


1. Clone the repository

  git clone https://github.com/mikedehaan/primefacesTest.git

2. Run maven to start tomcat7

  mvn clean tomcat7:run

3. Access the application in the browser

  http://localhost:8080/primefacesTest

4. Read the console logs generated from log4j and notice values are not set
<pre>
  [http-bio-8080-exec-10]12:37:49,370 | DEBUG | SampleDataTablePageBean.validate | - Local: [null]
  [http-bio-8080-exec-10]12:37:49,371 | DEBUG | SampleDataTablePageBean.validate | - Submitted: [null]
  [http-bio-8080-exec-10]12:37:49,371 | DEBUG | SampleDataTablePageBean.validate | - Reading Value threw an exception
  org.apache.myfaces.view.facelets.el.ContextAwareELException: javax.el.ELException: java.lang.ArrayIndexOutOfBoundsException: -1
</pre>
