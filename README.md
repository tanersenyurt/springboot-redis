# springboot-redis
springboot redis ws integration


Start Redis Docker with port of 33334
docker run -p 33334:6379 -it --name redisx --rm redis


start 2 instance of springboot app than 

call http://localhost:8080/ws/RedisWebService.sendMessage method

redis will share the messages between the instances 

[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=tanersenyurt_springboot-redis&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=tanersenyurt_springboot-redis)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=tanersenyurt_springboot-redis&metric=ncloc)](https://sonarcloud.io/dashboard?id=tanersenyurt_springboot-redis)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=tanersenyurt_springboot-redis&metric=coverage)](https://sonarcloud.io/dashboard?id=tanersenyurt_springboot-redis)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=tanersenyurt_springboot-redis&metric=sqale_index)](https://sonarcloud.io/dashboard?id=tanersenyurt_springboot-redis)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=tanersenyurt_springboot-redis&metric=code_smells)](https://sonarcloud.io/dashboard?id=tanersenyurt_springboot-redis)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=tanersenyurt_springboot-redis&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=tanersenyurt_springboot-redis)
[![Duplicated Lines](https://sonarcloud.io/api/project_badges/measure?project=tanersenyurt_springboot-redis&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=tanersenyurt_springboot-redis)


