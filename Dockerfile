FROM openjdk:17-jdk-alpine
RUN addgroup -S app && adduser -S app -G app
USER app

ENV SERVER_PORT=3001 \
    PG_USERNAME=postgres \
    PG_PASSWORD=dune2000 \
    PG_URL=jdbc:postgresql://localhost:5432/capstone \
    JWT_SECRET=9ptnwiQBGsuSKqoGkch7AVVtWV5VnjJAKqoGkch7AV \
    OKTA_ID=0oafrdovtvjWQjhCh5d7 \
    OKTA_ISSUER=https://dev-18053921.okta.com/oauth2/default \
    OKTA_AUDIENCE=api://default

COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]




