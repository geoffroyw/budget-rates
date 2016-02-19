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

## Dependencies

* MongoDB
