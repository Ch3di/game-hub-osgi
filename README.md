# Game Hub Project
## Brief Introduction to OSGi Felix 
Apache Felix is an open-source implementation of the OSGi Core Release 6 framework specification. The initial codebase was donated from the Oscar project at ObjectWeb. The developers worked on Felix for a full year and have made various improvements while retaining the original footprint and performance.
![OSGi Architecture](https://i.postimg.cc/qMtnFFL2/Untitled.png)

## Authors
* Chady Wadii Bouhlel
* Azer Taboubi

## Project Description
The OSGi specification introduced the ability to start a bundle while packages that it will use are not exported by another bundle at the time of activation. 

This is very useful for plugin applications where plugins can be dynamically installed long after the central core of the application is activated. 
This powerful OSGi Felix feature gave the impression of being in our “Game Hub” project.  

Game Hub is an OSGi platform that allows the user to find their favorite games in one place. 
It is a game center that hosts three games which are “Tetris”, “Snake” and “Sokoban”. 

Tetris, Snake and Sokoban are three different standalone OSGi bundles that implements the interface “GameInterface”. The “GameInterface” has “launchGame()” method. This interface is provided by another bundle called “GameAPI”. These three games are independent Java Swing applications that are encapsulated inside three different OSGi bundles. 

Thanks to registering all the three games and their interface as services, the “GameCenterServer” can easily find or track them. So, it can invoke the method launchGame() implemented by the three games to run them. The “GameCenterServer” implements the interface “GameCenterServerInterface” provided by “GameCenterServerAPI”. This interface contains the “runServer()” method which permit the clients to call the server. The server is Java Swing application that list all the games and allow the users to select and play the games. 

Finally, the “GameCenterGuest” which represents the client, invoke the “runServer()” method implemented by the server to launch it. So, the user can interact with as described in the last paragraph. 

Since the “GameCenterGuest” is not going to be called by any other bundle in opposite of the previous mentioned bundles, it is not registered as service. When you start it, it has just called the “GameCenterServer”.

## GameHub Architecture: Class Diagram
![GameHub Architecture Diagram](https://i.ibb.co/vLTTK3F/Picture1.jpg)

## Deployment on Apache Felix
* Launch Apache Felix framework from the jar binary. 

* Install the application bundles using the Felix console. 

* Start the bundles one by one  using the start command and the bundle IDs  

* Respect the following order while installing and starting the bundles to get the best result: 
  * GameAPI 
  * Tetris, Sokoban, Snake 
  * GameCenterServerAPI 
  * GameCenterServer 
  * GameCenterGuest 
* Starting the “GameServerGuest” bundle will launch the “GameCenter” Java Swing interface which from the user can enjoy the games. 


## Major Difficulties 
* The deployed Jar fails to load local host stored images on top of the JFrame object. 
  -> have hosted the images on the internet. Then we used Java URL class to get them instead of including them in the Jar file. 
* Lack of well-guided documentations or practical examples on the internet. The way that activating a simple Jar and starting it took a lot of our time… 

 

 

