create or replace view v_valor_combustivel_hist as
select po.id_posto as code,
       co.nome as combustivel, 
       vc.valor_combustivel as valor, 
      vc.data_alteracao as dataAtualizacao
  from postos po, 
       valor_combustiveis vc, 
       combustiveis co
 where po.id_posto = vc.id_posto
   and vc.combustivel = co.id_combustivel
group by po.id_posto, co.nome,vc.data_alteracao
order by po.id_posto, vc.data_alteracao