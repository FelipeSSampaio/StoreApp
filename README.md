# StoreApp
Projeto web usando Spring Boot, Maven, ProjectLombok e Thymeleaf

----------------------
PROBLEMAS ENFRENTADOS
----------------------
1 - Eclipse
  Pode ser que o eclipse apresente um erro de configuração do maven logo após a importação do código criado no Spring Initializr.
  Para corrigir esse erro basta adicionar o código abaixo dentro da tag properties, onde já deve ter uma indicação da versão do java;
  
  ```
  ...
  <properties>
		<java.version>1.8</java.version>
    <maven-jar-plugin.version>3.1.1</maven-jar-plugin.version>
  </properties>
  ...
  ```
