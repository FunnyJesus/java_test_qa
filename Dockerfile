FROM gradle:7.2.0-jdk17

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle build

RUN gradle test

LABEL authors="user"

ENTRYPOINT ["top", "-b"]