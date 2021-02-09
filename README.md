# witchSagaGeekseat

Step to run my API : 
1. Please run the code on eclipse with default port 2711, but if you want to change it, please change it in application.properties with "server.port" tag.
2. After run the application, please use postman to hit my API with this criteria :
	a. json body :

	   {
			"dataPerson":[
				{
					"ageOfDeath":10,
					"yearOfDeath":12
				},
				{
					"ageOfDeath": 13,
					"yearOfDeath": 17
				}
			]
		}
	
	b. method : POST
	c. url    : localhost:2711/api/fightWitch
	*if you want to change the url site, you can change it in application.properties with "returnOfTheCoder.path" tag.
3. the result will be seen after doing the step and send the JSon body data.
