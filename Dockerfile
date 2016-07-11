FROM alpine

ENV JAVA_HOME  /usr/lib/jvm/java-1.8-openjdk
ENV M2_HOME /usr/local/apache-maven/apache-maven-3.3.9
ENV PATH ${PATH}:${M2_HOME}/bin

ENV MAVEN_OPTS "-Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8000,suspend=n"

RUN apk update \
  && apk add \
    bash curl openjdk8 jetty-runner \
  && rm -rf \
    /tmp/* \
    /var/cache/apk/*

ADD apache-maven-3.3.9-bin.tar.gz /usr/local/apache-maven/

COPY RESTfulExample /app/RESTfulExample
WORKDIR /app/RESTfulExample

COPY lib/repository /root/.m2/repository
RUN mvn package
EXPOSE 8080

CMD jetty-runner --path /RESTfulExample /app/RESTfulExample/target/RESTfulExample.war
