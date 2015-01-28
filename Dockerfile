




FROM dockerfile/java

ADD InnovationRoom/filepyramid.jar /loop/filepyramid.jar
ADD InnovationRoom/expressionevaluation.jar /loop/expressionevaluation.jar

RUN apt-get update && apt-get install -y supervisor
RUN mkdir -p /var/log/supervisor

COPY supervisord.conf /etc/supervisor/conf.d/supervisord.conf
EXPOSE 4567
ENTRYPOINT []
CMD ["/usr/bin/supervisord"]

