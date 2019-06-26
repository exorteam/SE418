FROM openjdk

MAINTAINER dgy

ENV LANG en_US.UTF-8

RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

RUN mkdir -p /app/gateway

COPY /target/se418gateway-0.0.1-SNAPSHOT.jar /app/gateway

WORKDIR /app/gateway

ENTRYPOINT ["java","-jar","se418gateway-0.0.1-SNAPSHOT.jar"]

EXPOSE 7000
