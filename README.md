# Apache Karaf feature 
Implementation SOAP service feature using Blueprint  
Maven project:  
1. mvn package  
2. mvn clean install 

Karaf:  
feature:repo-add cxf 3.1.5

copy KAR file cxf.soap/soap-feature/deploy/soap-feature-1.0.0.kar to KARAF_HOME/deploy/

webconsole karaf: http://localhost:8181/system/console/bundles  
list cxf services : http://localhost:8181/cxf/




