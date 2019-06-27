FROM openjdk

MAINTAINER dgy

ENV LANG en_US.UTF-8

RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

RUN mkdir -p /app/se418

COPY /target/se418-0.1.jar /app/se418

WORKDIR /app/se418

ENTRYPOINT ["java","-jar","se418-0.1.jar"]

EXPOSE 8050
