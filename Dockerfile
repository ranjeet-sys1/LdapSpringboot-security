FROM openjdk:8
VOLUME /tmp
EXPOSE 8081
ADD target/LdapSpringSecurity-0.0.1-SNAPSHOT.jar LdapSpringSecurity-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/LdapSpringSecurity-0.0.1-SNAPSHOT.jar"]