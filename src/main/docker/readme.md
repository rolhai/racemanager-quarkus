# docker commands

# run mysql

## run new image
$ docker login

$ docker run --name rm-dev-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=rm-dev-pw -d mysql

## run existing image

$ docker start rm-dev-mysql

## show running images

$ docker ps

## stop image

$ docker stop rm-dev-mysql