testing messageBroker

hornetQ, installing jnp-client to the local repository, can't find any remote repo having that lib

mvn install:install-file -Dfile=/home/poyan/jms/hornetq-2.2.14.Final/lib/jnp-client.jar -DgroupId=local -DartifactId=jnp-client -Dversion=2.2.14 -Dpackaging=jar -DgeneratePom=true

mvn install:install-file -Dfile=/home/poyan/jms/hornetq-2.2.14.Final/lib/netty.jar -DgroupId=local -DartifactId=netty -Dversion=2.2.14 -Dpackaging=jar -DgeneratePom=true

mvn install:install-file -Dfile=/home/poyan/jms/hornetq-2.2.14.Final/lib/hornetq-core-client.jar -DgroupId=local -DartifactId=hornetq-core-client -Dversion=2.2.14 -Dpackaging=jar -DgeneratePom=true


