# spring_boot_api_backend_site_jobs_with_solid
<p>
Api backend com conceitos solid utilizando o Spring Boot PostegreSQL, JPA, valid, autenticação JWT, Hibernate  e swagger.</br>

Testes de integration e e2e</br>

<img src="tests.png"/>

url swagger: http://localhost:3333/swagger-ui/ 
</br>
no swagger você pode ver quais parametros para cada rota

<h1>Importante</h1>

 em main/resources/application.properties
 
 spring.datasource.url=URLdoPostegreSql </br>
 spring.datasource.username=SeuUserName </br>
 spring.datasource.password=SuaSenha </br>
 
 
 <h3>Algumas informações importante</h3> </br>
 
 Api do projeto feito no react native, é uma api que gerencia criação de usuarios, vagas de emprego e matching do usuário com a vaga</br>
 https://github.com/AndersonKV/react_native_app_jobs
  

<b>FUNCIONAMENTO</B>

<b>Camada de Users</b></br>
permite criar usuários com dois tipos de privilegio, user e company</br>
perfil user pode aplicar a vaga, necessario estar autenticado, e não é permitido criar uma</br>
perfil company pode postar a vaga, necessario estar autenticado, e não é permitido aplicar a qualquer vaga</br>
permite atualizar dados, com verificação se email já existe ou se os dados estão devidamente tratados</br>
pode buscar por id, deleta</br>

<b>Camada de Posts</b></br>
criação de post</br>
busca por id, id_job, filtro de busca de linguagem</br>
se a vaga já estiver vencida lança um error na hora de aplicar</br>

 
 user model ->  {</br>
	"name": "anderson",  </br>
	"email": "andersongmail.com",  </br>
	"password": "andersongmail.com",  </br>
		"confirm_password": "andersongmail.com",  </br>
		"role": "user || company"  </br>
}  </br>

job model ->  {</br>
		 "title": "lorem ipsum lorem ipsum lorem",  </br>
 			"name_company": "lorem ipsum lorem ipsum lorem",  </br>
  			"tech": ["react", "c++"],  </br>
 			"responsibilities": "lorem ipsum lorem ipsum lorem",  </br>
				"requirements": "lorem ipsum lorem ipsum lorem",  </br>
 			"types_contract": "clt", </br>
 			"size_company": "grande", </br>
 			"experience_level": "pleno", </br>
 			"expired_days":  "1", </br>
 			"salary": "5000", </br>
 			"remote": "sim", </br>
		"benefits": "lorem ipsum lorem ipsum lorem", </br>
	"token": "", </br>
	"id_user": "" </br>
} </br>
 
 
auth model -> {</br>
		"email": "andersongmail.com",</br>
	"password": "andersongmail.com"</br>
 }</br>


apply model -> {</br>
 	"id_user": "", </br>
	"id_job": "", </br>
	"token": "" </br>
 } </br>
 
<h2>Explore as APIs</h2>

<h3>UserController</h3>

POST /api/v1/users/create </br>
GET /api/v1/users/list_users </br>
GET /api/v1/users/find_by_id </br>
UPDATE /api/v1/users/update </br>

DELETE /api/v1/users/delete_by_id </br>
DELETE /api/v1/users/destroyer </br>

<h3>JobController</h3>

POST /api/v1/jobs/create </br>
GET /api/v1/jobs/list_jobs </br>
GET /api/v1/jobs/find_by_id </br>
GET /api/v1/jobs/find_by_id_user </br>
GET /api/v1/jobs/find_by_id_job </br>
GET /api/v1/jobs/find_by_tech </br>
GET /api/v1/jobs/find_the_last_three_jobs </br>

UPDATE /api/v1/jobs/update </br>

DELETE /api/v1/jobs/delete_by_id </br>
DELETE /api/v1/jobs/destroyer </br>


<h3>ApplyController</h3>

POST /api/v1/matchings/create </br>
GET /api/v1/matchings/list_applys </br>
GET /api/v1/matchings/find_by_id </br>
GET /api/v1/matchings/find_by_id_user </br>
GET /api/v1/matchings/find_by_id_job </br>
GET /api/v1/matchings/find_by_id_and_id_user_and_id_job </br>

UPDATE /api/v1/matchings/update </br>

DELETE /api/v1/matchings/delete</br>
DELETE /api/v1/matchings/delete_by_id </br>
DELETE /api/v1/matchings/destroyer </br>

<h3>AuthController</h3>

POST /api/v1/authenticate/sign_in </br>
POST /api/v1/authenticate/sign_in_token </br>


<h3>Passos para o SETUP</h3>
Clone o repo e abra com intellij que ele faz o resto, o app vai rodar em http://localhost:3333/
 </p>
