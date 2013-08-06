primefacesTest
==============

Testing primefaces functionality.  This project is in reference to the primefaces forum entry:

  http://forum.primefaces.org/viewtopic.php?f=3&t=33107

1. Clone the repository

  git clone https://github.com/mikedehaan/primefacesTest.git

2. Change to the newly cloned project

  cd primefacesTest

3. Run maven to start tomcat7

  mvn clean tomcat7:run

4. Access the application in the browser

  http://localhost:8080/primefacesTest

5. Click the button marked "ui-button"

6. Read the console logs generated from log4j and notice values are not set
<pre>
  [http-bio-8080-exec-10]12:37:49,370 | DEBUG | SampleDataTablePageBean.validate | - Local: [null]
  [http-bio-8080-exec-10]12:37:49,371 | DEBUG | SampleDataTablePageBean.validate | - Submitted: [null]
  [http-bio-8080-exec-10]12:37:49,371 | DEBUG | SampleDataTablePageBean.validate | - Reading Value threw an exception
  org.apache.myfaces.view.facelets.el.ContextAwareELException: javax.el.ELException: java.lang.ArrayIndexOutOfBoundsException: -1
</pre>
