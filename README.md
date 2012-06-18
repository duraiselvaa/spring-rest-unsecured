spring-webservice
=================

Prerequisite:
-------------

1. Install MySQL for your corresponding operating system with MySQL workbench
2. Create the sample table Book with the following fields:

id
name
author
publication

3. Note down the root password and the URL, port number to use for the connection parameters.


Dependencies:
=============

1. Spring Data JPA
2. Hibernate
3. MySQL


Using STS:
==========

It is very convenient to use STS to create the Spring project - so it creates the basic structure and required config files, then 
we can change them according to our requirement.


Build Instructions:
===================

1. Directly build and deploy from STS using 'Run As -> Run on Server..'.

If you have already installed Tomcat - you could specify that specific installation directory to be used with STS.

2. Build from command prompt using:

$ mvn clean install

and the generated rest.war needs to be deployed in Tomcat. 


Test Instructions:
==================

This specific application doesn't have any views, and the output comes in JSON format. This could be verified using

1. CURL
2. RESTClient (http://code.google.com/p/rest-client/)


The RESTClient could be opened in the browser once installed. 

REST Client: How To use:
============

1. choose the Request methods (GET, PUT, DELETE, POST)
2. specify request headers if required - Accept:application/json (this is required to pass the data as JSON during POST and PUT)
3. specify the Request Parameter (entity in JSON format to be saved or updated)
4. Specify the URL 
5. click 'Send'
6. We could check the differnt tabs availble to verify 'Response (raw)', 'Response Headers' etc. 



REST API - URLs:
================

GET : - http://localhost:8080/rest/book - will return the list of all the books in the format - [{"id": "1","name":"REST handbook","author":"M","publication":"Disney"}{}{}]

GET : http://localhost:8080/rest/book/x - will return the Entity with the given id 'x'

PUT : http://localhost:8080/rest/book - updates the given book with new detail - this requires the Book to be passed as the Request Param. - 
{"id": "1","name":"REST handbook","author":"S","publication":"Sun"}

DELETE : http://localhost:8080/rest/book/x - where x is the id of the entity to be deleted

POST : http://localhost:8080/rest/book - this requires the Book to be passed as the Request Param.


Upcoming :
==========
REST with Spring Security






