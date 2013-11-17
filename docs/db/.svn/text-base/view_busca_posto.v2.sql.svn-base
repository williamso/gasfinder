create or replace view v_busca_posto as
select po.id_posto as code,
	     po.razao_social as nomePosto, 
       po.endereco as endereco, 
       ba.nome as bandeira, 
       ci.nome as cidade, 
       ci.uf as uf, 
       vc.valor_gasolina as valorGasolina, 
       vc.valor_etanol as valorEtanol, 
       vc.valor_diesel as valorDiesel, 
       vc.valor_gnv as valorGNV, 
       vc.valor_glp as valorGLP, 
	     po.latitude as latitude,
	     po.longitude as longitude, 
       vc.data_alteracao as dataAtualizacao,
       vc.status as status
  from postos po, 
       bandeira ba, 
       cidades ci, 
       valor_combustiveis_2 vc
 where po.cidade = ci.id_cidade
   and po.bandeira = ba.id_bandeira
   and po.id_posto = vc.id_posto
   and status = 'A'
group by po.razao_social, po.endereco, ba.nome, ci.nome, ci.uf
order by ci.uf, ci.nome, ba.nome, po.razao_social