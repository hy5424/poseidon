FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD poseidon-0.0.1-SNAPSHOT.jar lottery.jar
RUN sh -c 'touch /lottery.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /lottery.jar" ]