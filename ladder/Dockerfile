FROM openjdk

MAINTAINER dgy

ENV LANG en_US.UTF-8

RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

RUN mkdir -p /app/ladder

COPY /target/ladder-0.0.1-SNAPSHOT.jar /app/ladder

WORKDIR /app/ladder

ENTRYPOINT ["java","-jar","ladder-0.0.1-SNAPSHOT.jar"]

EXPOSE 8010
