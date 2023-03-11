create
    database test;
create
    user 'docker'@'172.17.0.1' identified by 'docker';
grant all privileges on test.* to
    'docker'@'172.17.0.1';
flush
    privileges;