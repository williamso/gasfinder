-- Inserir as bandeiras do select abaixo


select * from gas_station where id not in(  
select g.id -- , g.bairro, v.id_cidade, g.endereco, g.bandeira 
  from gas_station g, /*v_cidades_cities v,*/ bandeira b 
 where -- g.id_cidade = v.id 
 g.bandeira = b.nome)
  
   
select *  from gas_station -- 11429

-- select * from cidades where id_cidade = 6
create view v_cidades_cities as 
select c.id, ci.id_cidade
  from cities c, cidades ci, estados e 
 where c.nome = ci.nome 
   and ci.id_uf = e.id_uf
   and c.estado = e.nome

select count(*) from gas_station
select * from v_cidades_cities
select max(id_cidade) from cidades
select * from cidades where uf = 'GO' and nome like "%Planaltina%"

update cidades set nome = "Armacao Dos Buzios" where id_cidade = 6668
update cities set nome = "Mogi-mirim" where estado = 'São Paulo' and nome = 'Mogi Mirim';
update cities set nome = "Mogi-guacu" where estado = 'São Paulo' and nome = 'Mogi Guacu';
update cities set nome = "Santa Barbara D'oeste" where estado = 'São Paulo' and nome = 'Santa Barbara D.oeste';
insert into cidades values(9715, 5, 'BA', 'Livramento De Nossa Senhora');