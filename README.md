Analisador Léxico
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


- Spring 4.x, Spring Boot, Spring Security, Spring Core, Spring OAuth;
    <p><img src="https://github.com/pssilva/lexcal-processor/blob/master/doc-repo/spring-core-arquitetura.png" alt="Arquitetura do Spring Core 4.x" height="300" width="400"/></p>
- Spring Batch, Spring Boot, Spring Security, Spring Core, Spring OAuth;
    <p><img src="https://github.com/pssilva/lexcal-processor/blob/master/doc-repo/Spring-Batch.png" alt="Spring Bath do Spring Core 4.x" height="300" width="400"/></p>
- EJB 2, EJB 3, Hibernate 3/JPA, Hibernate 2/JPA, Java SWT, JBoss 4.x, 7.x, Wildfly;
- Experiência em sistemas de banco de dados NoSQL (Cassandra, [MongoDB](https://www.mongodb.com/), etc.);
    <p><img src="https://github.com/pssilva/lexcal-processor/blob/master/doc-repo/mongoDB.png" alt="Experiência em sistemas de banco de dados NoSQL" height="50" width="195"/></p>
- Experiência em sistemas de containerização (e.g. [Docker](https://hub.docker.com/r/pss1suporte/paas-docker/));
    <p><img src="https://github.com/pssilva/lexcal-processor/blob/master/doc-repo/docker.png" alt="Experiência em sistemas de containerização Docker" height="50" width="195"></p>
- Experiência em sistemas Linux e shell scripting;
    <p><img src="https://github.com/pssilva/lexcal-processor/blob/master/doc-repo/shell-linux.jpeg" alt="Experiência em sistemas Linux e shell scripting" height="91" width="150"></p>

- Experiência em projetos utilizando micro serviços (Microservices) e computação distribuída;

![Microservices](https://github.com/pssilva/lexcal-processor/blob/master/doc-repo/microservices-domain.png)

### Como usar:
Considerando que temos uma instância do Amazon Machine Image - AMI iniciada: [aqui](https://docs.aws.amazon.com/pt_br/AWSEC2/latest/UserGuide/AccessingInstances.html) AWS EC2. Execute os comandos abaixo:

1. Clonar o projeto: `git clone https://github.com/pssilva/lexcal-processor.git`;
2. Acessar a pasta: `cd lexcal-processor`;
3. Criar um .xml do SM Word: File>Save as ...; <br />
	Será usado no atributo: -fi /PATH_TO_VALIDE_XML/name_file_word.xml 
4. Maven: `mvn package`;
5. Comando para testar: `java -jar target/analisador-lexico-0.0.1-SNAPSHOT.jar -fi /PATH_TO_VALIDE_XML/name_file_word.xml -fo /PATH_TO_SAME_PLACE/name_file_out_my.jso`;


### Referência
\[P. Raja Malleswara Rao: 2015\], Packt Publishing, [Spring Batch Essentials](https://www.packtpub.com/application-development/spring-batch-essentials): Design, develop, and deliver robust batch applications with the power of the Spring Batch framework.<br />
\[Sébastien Goasguen: 2016\], O’Reilly Media, Inc., [Docker Cookbook](http://www.allitebooks.com/docker-cookbook/): SOLUTIONS AND EXAMPLES FOR BUILDING DISTRIBUTED APPLICATIONS.<br />
\[Alan Mark Berg: 2015\],  Packt Publishing, [Jenkins Continuous Integration Cookbook](https://ebooks-it.org/1784390089-ebook.htm), Second Edition<br />
\[Christian Posta: 2016\], O’Reilly Media, Inc., [Microservices for Java Developers](https://developers.redhat.com/promotions/microservices-for-java-developers/): A Hands-on Introduction to Frameworks and Containers <br />
\[Markus Eisele: 2016\], O’Reilly Media, Inc., [Modern Java EE Design Patterns](https://developers.redhat.com/promotions/distributed-javaee-architecture/): Building Scalable Architecture for Sustainable Enterprise Development. <br />  
