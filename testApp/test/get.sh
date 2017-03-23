#!/bin/bash


#curl --verbose -f -X POST --data-binary @hello http://127.0.0.1:8080/testApp/testService/hello -H "Content-Type:application/json"


curl --verbose -f -X POST --data-binary @hello http://127.0.0.1:8080/testApp/testService/helloPersist -H "Content-Type:application/json"
