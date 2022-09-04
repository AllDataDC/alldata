REPLACE INTO datasource(id, name, type, connect_config, build_in, app_id, creator, last_modifier, description) VALUES (1, 'sreworks_es', 'es', '{"schema":"http","port":${DATA_ES_PORT},"host":"${DATA_ES_HOST}","username":"${DATA_ES_USER}","password":"${DATA_ES_PASSWORD}"}', true, 0, 'sreworks', 'sreworks', 'sreworks_es数据源');

REPLACE INTO datasource(id, name, type, connect_config, build_in, app_id, creator, last_modifier, description) VALUES (2, 'sreworks_meta_mysql', 'mysql', '{"password":"${DB_PASSWORD}","port":${DB_PORT},"host":"${DB_HOST}","db":"sreworks_meta","username":"${DB_USER}"}', true, 0, 'sreworks', 'sreworks', 'sreworks_meta数据源');