#!/bin/sh

if [ -f /root/_daniel/$1/target ]
then
    echo "The directories are ready!"
else
    mkdir -p /root/_daniel/$1/target
fi

docker build -t $1 $1
docker stop aaa
docker rmaaa
docker run -p 800:8080 --name aaa -d $1
echo $!