FROM ubuntu:20.04


RUN apt-get clean && apt-get update && apt-get install -y \
    wget \
    unzip \
    && rm -rf /var/lib/apt/lists/*


RUN wget https://github.com/adoptium/temurin18-binaries/releases/download/jdk-18.0.2.1+1/OpenJDK18U-jdk_x64_linux_hotspot_18.0.2.1_1.tar.gz \
    -P /tmp \
    && mkdir /opt/jdk \
    && tar -xzf /tmp/OpenJDK18U-jdk_x64_linux_hotspot_18.0.2.1_1.tar.gz -C /opt/jdk \
    && ln -s /opt/jdk/jdk-18.0.2.1+1 /opt/jdk/latest \
    && rm /tmp/OpenJDK18U-jdk_x64_linux_hotspot_18.0.2.1_1.tar.gz


ENV JAVA_HOME=/opt/jdk/latest
ENV PATH="${JAVA_HOME}/bin:${PATH}"


RUN wget https://services.gradle.org/distributions/gradle-8.8-bin.zip \
    -P /tmp \
    && unzip -d /opt/gradle /tmp/gradle-8.8-bin.zip \
    && ln -s /opt/gradle/gradle-8.8 /opt/gradle/latest \
    && rm /tmp/gradle-8.8-bin.zip


ENV GRADLE_HOME=/opt/gradle/latest
ENV PATH="${GRADLE_HOME}/bin:${PATH}"


WORKDIR /app


COPY . .

RUN ./gradlew build


CMD ["./gradlew", "test"]
