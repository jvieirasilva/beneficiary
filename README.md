# Steps para execução do end point.
O Objetivo dessa api é gravar dados de beneficiários e documentos via swaager usando spring boot e jpa/Hibernate

1-Execute swagger:  http://localhost:8080/swagger-ui/index.html#/

2-Execute o endpoint de : jwt-authentication-controller  - authenticate - Com os seguintes paramentros: 
{
  "username": "joseneto",
  "password": "password"
}
3-Copiar o token obitido com a execução do endpoint e submeter no botão do lado direito do swagger chamado : Authorize

Após todos esses procedimentos api estará disponível para execução.

