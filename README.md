**How to use?**

**1)** Download/install maven, git and docker-compose!

https://maven.apache.org/

https://git-scm.com/

https://docs.docker.com/compose/

**2)** Git clone or download the source code!

`git clone https://github.com/onuramca/challenge.git`

**3)** Open a terminal and change directory to the parent folder

**4)** Run `mvn clean package`

**5)** Copy the backend-1.0.jar to the same folder with Dockerfile

`cp target/backend-1.0.jar backend-1.0.jar`

**6)** Run `docker-compose up` (may require root privileges). This takes some time because docker will

**i.** pull the postgres image

**ii.** pull the jdk image

**iii.** setup the database 

**iv.** run the containers

**7)** Connect to the postgres db from your favourite tool and run the statements in insert.sql 

(necessary for populating the required lookup tables and inserting some sample data)

**8)** Open the application in a browser:

http://localhost:8080/swagger-ui/#

**9)** To try webhooks locally checkout this example (https://www.twilio.com/blog/2013/10/test-your-webhooks-locally-with-ngrok.html):

**i.** sign up to a popular webhook service such as Twilio using your own phone number and get a trial phone number

**ii.** install ngrok and sign up to be able to start a HTTP tunnel to your local machine

https://ngrok.com/

**iii.** match your Twilio trial number with the public dns of your application's webhook URL at localhost

**iv.** send an SMS to your Twilio trial number and it will hit your local application backend





