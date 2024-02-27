FROM openjdk:17
EXPOSE 8090
ADD target/clinic-system-0.0.1-SNAPSHOT.war clinic-system-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java","-jar","/clinic-system-0.0.1-SNAPSHOT.war" ]