create or replace view v_posto_valor_combustivel as 
select  po.razao_social as posto, 
        ba.nome as bandeira,
        ci.nome as cidade, 
        ci.uf as uf,
        vc.data_alteracao, 
        vc.valor_gasolina,
        vc.valor_etanol,
        vc.valor_diesel,
        vc.valor_gnv,
        vc.valor_glp
  from valor_combustiveis_2 vc, 
       cidades ci, 
       postos po,
       bandeira ba
 where ci.id_cidade = po.cidade
   and po.id_posto = vc.id_posto
   and ba.id_bandeira = po.bandeira
   
--   and ci.nome = 'Salvador' 
--   and ci.uf = 'BA'
group by  po.razao_social
order by po.razao_social,  ba.nome , ci.uf, ci.nome, vc.data_alteracao

select * from v_posto_valor_combustivel order by uf
