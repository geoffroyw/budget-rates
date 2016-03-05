## budget-rates
Service to fetch the exchange rates published by ECB (https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml) and expose a cross-currency conversion service.

## Build and run

To build the project, execute  
```
./gradlew build
```

Then execute  
```
java -jar build/libs/budget-rates-0.1.0.jar
```

One can also directly execute ```./gradlew bootRun``` to build and run the project.

## Usage

To convert 123 EUR in USD, one should make the following GET request
```
http://localhost:8080/convert?amount=123&amountCurrency=EUR&toCurrency
```

Response will be the following JSON  

```json  
{  
 "asOf": "2016-02-18T20:40:34.811",  
  "fromCurrency": "EUR",  
  "toCurrency": "USD",  
  "amountInFromCurrency": 10,  
  "amountInToCurrency": 11.0840  
}
```

## Dependencies

* MongoDB
