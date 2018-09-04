# springboot-redis
springboot redis ws integration


Start Redis Docker with port of 33334
docker run -p 33334:6379 -it --name redisx --rm redis


start 2 instance of springboot app than 

call http://localhost:8080/ws/RedisWebService.sendMessage method

redis will share the messages between the instances 


