
select
	(select name
	from auto
	group by name
	order by count(*) desc
			, name desc
		limit 1
	) as name_auto,
	
	(select body_id
	from auto
	group by body_id
	order by count(*) desc
			, body_id desc
		limit 1
	) as body_id,
	
	(select engine_id
	from auto
	group by engine_id
	order by count(*) desc
			, engine_id desc
		limit 1
	) as engine_id, 
	
	(select trans_id
	from auto
	group by trans_id
	order by count(*) desc
			, trans_id desc
		limit 1
	) as trans_id;
	
create view details as select 
	(select name
	from auto
	group by name
	order by count(*) desc
			, name desc
		limit 1
	) as name_auto,
	
	(select body_id
	from auto
	group by body_id
	order by count(*) desc
			, body_id desc
		limit 1
	) as body_id,
	
	(select engine_id
	from auto
	group by engine_id
	order by count(*) desc
			, engine_id desc
		limit 1
	) as engine_id, 
	
	(select trans_id
	from auto
	group by trans_id
	order by count(*) desc
			, trans_id desc
		limit 1
	) as trans_id;
	
select * from details;
alter view details rename to details_auto;
select * from details_auto;
drop view details_auto;					

							