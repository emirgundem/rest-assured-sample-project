Rest Assured Api Testing Project

In this project, api tests we performed with fake json-server using rest assured.

![](../../Desktop/image-103.png)

1- GET POST
2- ADD POST
3- UPDATE POST
4- PATCH POST
5- DELETE POST

In this project typicode/json-server is used to run the tests.
Note : You must have nodejs ınstalled on your computer to run test.


Getting Started

Install JSON Server 

npm install -g json-server


Create a db.json file with some data

{
"posts": [
{ "id": 1, "title": "json-server", "author": "typicode" }
],
"comments": [
{ "id": 1, "body": "some comment", "postId": 1 }
],
"profile": { "name": "typicode" }
}

Start JSON Server

json-server --watch db.json

Now if you go to http://localhost:3000/posts/1, you'll get

{ "id": 1, "title": "json-server", "author": "typicode" }
