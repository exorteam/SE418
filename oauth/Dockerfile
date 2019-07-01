FROM openjdk

MAINTAINER dgy

ENV LANG en_US.UTF-8

RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

RUN mkdir -p /app/oauth

COPY /target/boot-security-oauth2-0.0.1-SNAPSHOT.jar /app/oauth

WORKDIR /app/oauth

ENTRYPOINT ["java","-jar","boot-security-oauth2-0.0.1-SNAPSHOT.jar"]

EXPOSE 9800
