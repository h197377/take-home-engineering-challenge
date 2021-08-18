# What? 
This is the coding sample for Microsoft Commercial Software Engineering challenge. It is a RESTful web serivce built using Spring framework.  

All logic exists in `foodTruckLocator/src/main/java/com/foodTruckLocator/foodTruckLocator`
Resources exists in `foodTruckLocator/src/main/resources/assets/csv`
Unit tests exists in `foodTruckLocator/src/test/java/com/foodTruckLocator/foodTruckLocator`

There are 3 APIs available
- `/getFoodTruck/{locationId}` will retrieve a food truck information, or blank if there are no such food truck with the provided locationId
- `/getFoodTrucksByBlock/{block}` will retrieve a list of food trucks at a given block, including food trucks with no blocks
- `/insertFoodTruck` will allow user to add a food truck 


# Usage

1. `git clone  https://github.com/h197377/take-home-engineering-challenge.git && cd take-home-engineering-challenge/foodTruckLocator/`
2. `./gradlew build && ./gradlew bootRun`

Then, open up another terminal 

*To get a food truck* 
```
curl --location --request GET 'http://localhost:8080/getFoodTruck/848184'
```

*To get all food trucks by a block*
```
curl --location --request GET 'http://localhost:8080/getFoodTrucksByBlock/3708'
```

*To add a truck* 
```
curl --location --request POST 'http://localhost:8080/insertFoodTruck/' \
--header 'Content-Type: application/json' \
--data-raw '{"locationId":"123456789","applicant":"Test Applicant","facilityType":"Push Cart","cnn":"30727000","locationDescription":"MARKET ST: DRUMM ST intersection","address":"5 THE EMBARCADERO","blockLot":"0234017","block":"0991","lot":"017","permit":"15MFF-0159","status":"REQUESTED","foodItems":"","x":"6013916.72","y":"2117244.027","latitude":"37.7943310032468","longitude":"-122.395811053023","schedule":"http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule&params=permit=15MFF-0159&ExportPDF=1&Filename=15MFF-0159_schedule.pdf","daysHours":"","noiSent":"","approved":"","received":"2015-12-31","priorPermit":"0","expirationDate":"03/15/2016 12:00:00 AM","location":"home"}'
```

You can then try to retreive its info to verify
```
curl --location --request GET 'http://localhost:8080/getFoodTruck/123456789'
curl --location --request GET 'http://localhost:8080/getFoodTrucksByBlock/0991'
```

# Local testing 
1. `git clone https://github.com/h197377/take-home-engineering-challenge.git && cd take-home-engineering-challenge/foodTruckLocator/`
2. `./gradlew test`
