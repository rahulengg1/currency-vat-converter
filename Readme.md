"currentTime": "15:29:08.232"# currency-vat-converter

Implement a application which has three services current time, currency conversion and vat validation.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

> Prerequisite

##### To run application on docker environment

* Docker 
* Docker-compose

##### To run application without docker environment

* Maven
* Java 8 or higher

> Steps

##### On Docker environment

1. Clone the repository where docker service is available.
2. Go inside the project directory using command line.
3. Run docker-compose up to start application
4. To rebuild the application use docker-compose build and then docker-compose up to start application.
5. You can change application port in docker-compose.yml. Current port number is "8081". Please check and modify according to your need.

   
##### Without Docker environment

1. Clone the repository.
2. Go inside the project directory using command line.
3. Install mvn and execute mvn clean spring-boot:run. Application port is 8081, you can change in application.yml file.


Test the endpoints using swagger http://localhost:8081/swagger-ui.html#/


  * http://localhost:8081/api/getCurrentTime
  * http://localhost:8081/api/currency/convert
  * http://localhost:8081/api/vat/validate
  
  or you can use any REST API test tools such as Postman or SoapUI.

## Task Description



Serve the following API endpoints:

* Output the current time (as valid JSON)
* Convert currency inputs
	* endpoint: /api/currency/convert
	* inputs: amount (in source-currency), source-currency, target-currency
	* output: amount in target-currency (as valid JSON)
	* you may use static conversion data or connect to a public converter (e.g. https://currencylayer.com/documentation)

* Validate a VAT input and return
	* input: potential VAT number
	* output: country (code) for VAT number (as valid JSON)
	* you may use a static mapping or connect to a public api (e.g. https://api.cloudmersive.com/swagger/index.html?urls.primaryName=Validate%20API)


#### GET /getCurrentTime

Response:

```
{
  "currentTime": "15:29:08.232"
}
```
Timezone "UTC"


#### POST /currency/convert

This is the endpoint for convert amount from one currency to another


Request:

```
{
  "amount": 0,
  "sourceCurrency": "ABC",
  "targetCurrency": "XYZ"
}
```

Response :

```
{
  "amount": 0.010796
}
```

#### Common Error Response :

```
{
  "timeStamp": "2019-11-14T13:57:30.014+0000",
  "status": HTTP Status Code,
  "error": [
    "Error Message"
  ]
}
```


#### POST /vat/validate

This is the endpoint is to get Country code from VAT No.


Request:

```
{
  "vatNo": "string"
}
```

Response :

```
{
  "countryCode": "ST"
}
```

## Development and Architecture Aspects

> Technology/Tools used

* Java 8
* Spring boot
* Maven 
* Swagger for documentation
* Docker

> Following Development principles are used

<I>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Clean Code, KISS, DRY, SOLID and Oops principle.</I>

## Test Cases

Unit Test cases and Integration test cases were written. Please use below command to run test cases


```
mvn clean test
```



To check code coverage find following file inside working directory - target/site/jacoco/index.html file. 
