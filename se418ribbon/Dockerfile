FROM openjdk

MAINTAINER dgy

ENV LANG en_US.UTF-8

RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

RUN mkdir -p /app/ribbon

COPY /target/se418ribbon-0.0.1-SNAPSHOT.jar /app/ribbon

WORKDIR /app/ribbon

ENTRYPOINT ["java","-jar","se418ribbon-0.0.1-SNAPSHOT.jar"]

EXPOSE 8000
