#!/bin/bash
echo "restart service";
sudo docker run --name=se418 -d -p 8080:8080 se418:v1;
