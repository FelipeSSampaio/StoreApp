# StoreApp
Projeto web usando Spring Boot, Maven, ProjectLombok,, Materialyze e Thymeleaf

----------------------
PRIMEIROS PASSOS
----------------------
1 - Maven

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
2 - ProjectLombok
  É preciso ter atenção com essa biblioteca porque é necessário instalar a mesma no eclipse, caso contrário seus getters e setters não serão encontrados, assim como o toString() e demais métodos comuns de um modelo, e simplesmente não darão erro.
