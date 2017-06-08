# Analisador Léxico
==============================================================
O Analisador Léxico – Projeto para o processamento de arquivos XML do documento Word. O analisador deve reconhecer as estruturas e criar uma lista com os tokens encontrados. Os tokens representam as unidades léxicas encontradas no texto. Cada token deve conter o seu tipo e o seu valor.

## Objetivos Principais 

- Criar uma sistema usando as tecnologias: Spring Batch;
- Criar um sistema usando tecnologias Framework Spring como um todo;
- Usar um ambiente Plataform as a Service - PaaS;
- [Jenkins](https://jenkins.io/) - Integração Contínua; 
- Projetar Sistemas usando Arquiterura Microservices;
- Implantação Contínua (Continuous Deployment);

Para construir a imagem usei as orientações discutidas em [Oskar Hane: 2015].

### Adquirir Proficiências em Habilidades


1. Spring 4.x, Spring Boot, Spring Security, Spring Core, Spring OAuth;
    <p><img src="https://github.com/pssilva/java-framework-spring/blob/master/doc-repo/spring-core-arquitetura.png" alt="Arquitetura do Spring Core 4.x" height="300" width="400"/></p>
2. EJB 2, EJB 3, Hibernate 3/JPA, Hibernate 2/JPA, Java SWT, JBoss 4.x, 7.x, Wildfly;
3. Experiência em sistemas de banco de dados NoSQL (Cassandra, [MongoDB](https://www.mongodb.com/), etc.);
    <p><img src="https://github.com/pssilva/java-framework-spring/blob/master/doc-repo/mongoDB.png" alt="Experiência em sistemas de banco de dados NoSQL" height="50" width="195"/></p>
4. Experiência em sistemas de containerização (e.g. [Docker](https://hub.docker.com/r/pss1suporte/paas-docker/));
    <p><img src="https://github.com/pssilva/java-framework-spring/blob/master/doc-repo/docker.png" alt="Experiência em sistemas de containerização Docker" height="50" width="195"></p>
5. Experiência em sistemas Linux e shell scripting;
    <p><img src="https://github.com/pssilva/java-framework-spring/blob/master/doc-repo/shell-linux.jpeg" alt="Experiência em sistemas Linux e shell scripting" height="91" width="150"></p>
6. Experiência em sistemas Amazon Web Services - AWS;
    <p><img src="https://github.com/pssilva/java-framework-spring/blob/master/doc-repo/aws.png" alt="Experiência em sistemas Amazon Web Services - AWS" height="50" width="195"></p>
7. Experiência em usar Oracle WebLogic Server;
    <p><img src="https://github.com/pssilva/java-framework-spring/blob/master/doc-repo/ows.png" alt="Experiência em sistemas Linux e shell scripting" height="91" width="150"></p>
8. Experiência em projetos utilizando micro serviços (Microservices) e computação distribuída;

![Microservices](https://github.com/pssilva/java-framework-spring/blob/master/doc-repo/microservices-domain.png)

### Como usar:
Considerando que temos uma instância do Amazon Machine Image - AMI iniciada: [aqui](https://docs.aws.amazon.com/pt_br/AWSEC2/latest/UserGuide/AccessingInstances.html) AWS EC2. Execute os comandos abaixo:

1. Clonar o projeto: `git clone https://github.com/pssilva/java-framework-spring.git`;
2. Acessar a pasta: `cd java-framework-spring`;
3. Maven: `mvn package`;
4. path WildFly: `echo "export WILDFLY_HOME=/[PATH_TO]/wildfly-10.1.0.Final" >> ~/.bash_profile`;
5. source path: `source ~/.bash_profile`;
6. start WildFly: `nohup $WILDFLY_HOME/bin/./standalone.sh > /dev/null 2>&1 & `;
7. Em outro terminal, deploy: `source ~/.bash_profile && nohup $WILDFLY_HOME/bin/jboss-cli.sh --connect --command="deploy --force target/java-framework-spring.war" > /dev/null 2>&1 & `;
8. acessar o link: `localhost:8080/java-framework-spring/`;


### Temas 
O projeto será adaptado para os seguintes temas (themes):

1. [AdminLTE](https://github.com/almasaeed2010/AdminLTE); <br />
>AdminLTE
!["AdminLTE Presentation"](https://almsaeedstudio.com/AdminLTE2.png "AdminLTE Presentation")

2. [Gentelella Allela](https://github.com/puikinsh/gentelella); <br />
>Gentelella Allela
![Gentelella Bootstrap Admin Template](https://github.com/pssilva/java-framework-spring/blob/master/doc-repo/theme-gentelella.png "Gentelella Theme Browser Preview")

### Referência
\[Sébastien Goasguen: 2016\], O’Reilly Media, Inc., [Docker Cookbook](http://www.allitebooks.com/docker-cookbook/): SOLUTIONS AND EXAMPLES FOR BUILDING DISTRIBUTED APPLICATIONS.<br />
\[Alan Mark Berg: 2015\],  Packt Publishing, [Jenkins Continuous Integration Cookbook](https://ebooks-it.org/1784390089-ebook.htm), Second Edition<br />
\[Alan Mark Berg: 2015 - 5\],  __ Chapter 5: Kubernetes, pag 149.<br />
\[Christian Posta: 2016\], O’Reilly Media, Inc., [Microservices for Java Developers](https://developers.redhat.com/promotions/microservices-for-java-developers/): A Hands-on Introduction to Frameworks and Containers <br />
\[Markus Eisele: 2016\], O’Reilly Media, Inc., [Modern Java EE Design Patterns](https://developers.redhat.com/promotions/distributed-javaee-architecture/): Building Scalable Architecture for Sustainable Enterprise Development. <br />  
