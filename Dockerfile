FROM openjdk:11

RUN mkdir /app

COPY app /app

WORKDIR /app

CMD java Main
