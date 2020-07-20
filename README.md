# LoLRecord-search
The LoLRecord-search API can be used to load 5 most recent match stats of a given summoner in Riot Game's League of Legends.

## Required Inputs

Below is a table which describes required input fields to use this API.
| Name | Type | Description |
| ---- | ---- | ----------- |
| summonerName | String | Name of summoner to query |
| apiKey | String | Personal API key for Riot API |

## Set-up

1. Pull this repository using the below command in a terminal.
```
git clone https://github.com/ajou-RealCoding1-group4-git/LoLRecord-search.git
``

2. Open the project using a Java IDE. We have tested with IntelliJ IDEA. Java 1.8 is recommended for maximum compatibility with Maven.

3. Run the local web server by running the below class.
```
LoLRecordSearchApplication.java
```

4. Open a web browser and navigate to the Swagger UI by entering the below address.
```
localhost:8888
```

5. Input required fields to use this API.
You need to pass a summoner name and your personal API key for the Riot API.
Try to make inputs CaSe SeNsItIvE for best accuracy.

6. Check the response body for match results of 5 most recent games.

## Implementation

Members of our team has done research and revision of class materials to implement this API. 

| Name |
| ---- |
| 황지훈 |
| 고예준 |
| 김소이 |
| 최형택 |
