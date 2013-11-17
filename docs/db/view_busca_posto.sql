create or replace view v_busca_posto as
select po.id_posto as code,
	   po.razao_social as nomePosto, 
       po.endereco as endereco, 
       ba.nome as bandeira, 
       ci.nome as cidade, 
       ci.uf as uf, 
       co.nome as combustivel, 
       vc.valor_combustivel as valor, 
	   po.latitude as latitude,
	   po.longitude as longitude, 
       max(vc.data_alteracao) as dataAtualizacao
  from postos po, 
       bandeira ba, 
       cidades ci, 
       valor_combustiveis vc, 
       combustiveis co
 where po.cidade = ci.id_cidade
   and po.bandeira = ba.id_bandeira
   and po.id_posto = vc.id_posto
   and co.id_combustivel = vc.combustivel
group by po.razao_social, po.endereco, ba.nome, ci.nome, ci.uf, co.nome
order by ci.uf, ci.nome, ba.nome, po.razao_social