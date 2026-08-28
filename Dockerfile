FROM mcr.microsoft.com/playwright/java:v1.55.0-noble

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

ENV TEST_SUITE=smoke

CMD mvn clean test -Dcucumber.filter.tags=@${TEST_SUITE}