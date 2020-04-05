# StoreApp
Projeto web usando Spring Boot, Maven, ProjectLombok,, Materialize e Thymeleaf

----------------------
PASSOS NECESSÁRIOS
----------------------
1 - MAVEN

Após clonar o projeto será preciso realizar um Maven Install para realizar o download das Libs.

2 - Banco de Dados

Também será preciso instalar o Postgres, caso queira manter o mesmo banco de dados que estou usando para persistir os dados.
Para download do Postgres: https://www.enterprisedb.com/downloads/postgres-postgresql-downloads

Caso não queira utilizar o Postgres, basta alterar as seguintes propriedades na classe com.storeapp.StoreApp.DataConfiguration:

```
dataSource.setDriverClassName("org.postgresql.Driver");
adapter.setDatabase(Database.POSTGRESQL);
adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
```

Além de lembrar de colocar o 'user' e 'password' de acordo com o utilizado no banco.

Outro ponto importante é que terá que alterar o pom.xml para poder alterar a dependência do banco Postgres para o banco de sua escolha.

Não se esqueça de criar banco de dados com o nome 'StoreApp' ou altere, ainda na classe DataConfiguration, a linha de código que define a url para adicionar o nome que deseja:

```
dataSource.setUrl("jdbc:postgresql://localhost/StoreApp");
```

A construção do banco está definida na seguinte linha da classe DataConfiguration:

```
adapter.setGenerateDdl(true);
```

Ela indica que serão adicionadas/atualizadas estruturas no banco, mas não serão excluídas as já existentes.

3 - Project Lombok
  Para que essa bblioteca funcione no eclipse será preciso instalar a mesma.
  Para isso basta procurar o jar da lib no repositório do Maven (.m2) e executar ele com um duplo clique. O endereço deve ser algo como: '\.m2\repository\org\projectlombok\lombok\1.18.12'
  Ao executar a lib, busque o local de instalação do seu eclipse e siga com a instalação.
  Se seu eclipse estiver aberto, pode ser necessário reiniciar o mesmo.

OBS: Essa lib auxilia na redução da verbosidade do Java. Além disso, também auxilia no log da aplicação.

4 - Página inicial da aplicação

http://localhost:8080/

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
