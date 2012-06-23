## Prerequisite

- Install MySQL for your corresponding operating system with MySQL workbench
- Note down the root password and the URL, port number to use for the connection parameters.
- Create the sample table Book with the following fields:

id <br/>
name <br/>
author <br/>
publication <br/>


## Technology Stack


- Spring Data JPA
- Hibernate
- MySQL


## Using STS

It is very convenient to use STS to create the Spring project - it creates the basic structure and required config files, then 
we can change them according to our requirement.


## Build Instructions

- Directly build and deploy from STS using 'Run As -> Run on Server..'. If you have already installed Tomcat - you could specify that specific installation directory to be used with STS.

- Build from command prompt and the genrated rest.war can be deployed in Tomcat <br/>

`$ mvn clean install` <br/>


## Test Instructions

This specific application doesn't have any views, and the output comes in JSON format. This could be verified using

- RESTClient
- CURL


## RESTClient

- This is an add-on to Firefox and could be installed from: https://addons.mozilla.org/en-US/firefox/addon/restclient/
- Once installed the RESTClient icon will be available in the 'Navigation Toolbar' like any other add-on.


### How to test using RESTClient

- choose the Request methods (GET, PUT, DELETE, POST)
- specify request headers if required - Accept:application/json (this is required to pass the data as JSON during POST and PUT)
- specify the Request Parameter (entity in JSON format to be saved or updated)
- specify the URL 
- click 'Send'
- We could check the differnt tabs availble to verify 'Response (raw)', 'Response Headers' etc. 

## REST API

**Request mappings**

<table>
<tr>
<td><b>Operation Description</b></td>
<td><b>URI</b></td>
<td><b>HTTP Method (Verb)</b></td>
<td><b>Request Body</b></td>
<td><b>Response on Success</b></td>
<td><b>Response on Failure</b></td>
</tr>

<tr>
<td>Fetch all the books</td>
<td>http://localhost:8080/rest/book</td>
<td>GET</td>
<td></td>
<td>
200 OK <p/>
List&lt;Books&gt;
</td>
<td></td>
</tr>

<tr>
<td>Fetch Book by id</td>
<td>http://localhost:8080/rest/book/{id}</td>
<td>GET</td>
<td></td>
<td>
200 OK <p/>
Book<p/>
</td>
<td>
404 Not Found <p/>
500 Server Error <p/>
</td>
</tr>

<tr>
<td>Delete a book</td>
<td>http://localhost:8080/rest/book/{id}</td>
<td>DELETE</td>
<td></td>
<td>204 No Content</td>
<td>404 Not Found</td>
</tr>

<tr>
<td>Create Book</td>
<td>http://localhost:8080/rest/book</td>
<td>POST</td>
<td>Book</td>
<td>201 Created</td>
<td>500 Server Error</td>
</tr>

<tr>
<td>Update Book</td>
<td>http://localhost:8080/rest/book</td>
<td>PUT</td>
<td>Book</td>
<td></td>
<td>500 Server Error</td>
</tr>

</table>


## Upcoming

Spring Rest Secured using Spring Security






