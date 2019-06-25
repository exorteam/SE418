FROM openjdk

MAINTAINER dgy

ENV LANG en_US.UTF-8

RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

RUN mkdir -p /app/eureka

COPY /target/eureka-0.0.1-SNAPSHOT.jar /app/eureka

WORKDIR /app/eureka

ENTRYPOINT ["java","-jar","eureka-0.0.1-SNAPSHOT.jar"]

