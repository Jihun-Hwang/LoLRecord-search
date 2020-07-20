# LoLRecord-search
The LoLRecord-search API can be used to load 5 most recent match stats of a given summoner in Riot Game's League of Legends.

![Example Result Image](/result-img2.png)


## Required Inputs

Below is a table which describes required input fields to use this API.
| Parameter | Type | Description |
| ---- | ---- | ----------- |
| summonerName | String | Name of summoner to query |
| apiKey | String | Personal API key for Riot API |


## Set-Up

1. Pull this repository using the below command in a terminal.
```
git clone https://github.com/ajou-RealCoding1-group4-git/LoLRecord-search.git
```

2. Open the project using a Java IDE. We have tested with IntelliJ IDEA. Java 1.8 is recommended for maximum compatibility with Maven. MongoDB is recommended to view the database. Please install other dependencies according to ``POM.xml``.

3. Run the local web server by running the below class.
```
LoLRecordSearchApplication.java
```

4. Open a web browser and navigate to the Swagger UI by entering the below address.
```
localhost:8888
```
If Swagger UI doesn't appear, change the port number to something other than `8888`. The port number can be changed in the application.properties file located at the below location.
```
LoLRecord-search\src\main\resources\application.properties
```

5. Input required fields to use this API.
You need to pass a summoner name and your personal API key for the Riot API.
Try to make inputs CaSe SeNsItIvE for best accuracy.

6. Check the response body for match results of 5 most recent games.


## Implementation

Members of our team has done research and reviewed class materials to implement this API. We greatly thank our instructor for helping us on our way to implement this API.

Team Members: 황지훈, 고예준, 김소이, 최형택


## Discussions

This section illustrates past discussions our team had while implementing the API.

### 1. Saving previously searched summoner names to database
| Type | Description | Selected |
| - | - | - |
| Save | Saves summoner name to reuse in the future. | O |
| Don't Save | Self-explanatory |  |

Our API first checks input summoner name and looks it up in our database. If there is an identical match, our API will use saved data to pull match information from Riot servers. If there isn't a match, our API will pull account data from Riot servers, save pulled account data to our database, and then fetch match information.

Saving summoner names reduces future use of Riot API when pulling summoner data. Summoner data includes encryptedSummonerName, accountId, and other data. These data are required to retrieve match data from Riot APIs and since they don't change over time it is more efficient to store these data to a database. 

### 2. Frequency to pull match data via Riot API: On-demand vs Queued intervals

| Type | Description | Selected |
| ---- | ----------- | -------- |
| Queued intervals | Previously searched summoner names are added to a queue. These summoners' match data will be updated when the API is running less frequently than Riot API's limits. |   |
| On-demand | Pulls match data when our user searches a certain summoner. | O |


The queued interval method saves the pulled match data in a database. This method will check if the current summoner name to search has been looked up previously. If it was been searched before, our API will return data from our database of stored match datas. If it is a first search, our API will access Riot servers and add this newly searched summoner name to a queue. When idle, our API will update exising match data of summoners in the queue with a time interval.

The on-demand method doesn't save match data to a database. It simply pulls fresh data from Riot servers when requested.
