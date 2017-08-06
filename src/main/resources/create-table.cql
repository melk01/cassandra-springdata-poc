docker exec -it cassandra-3.10 /bin/bash
cqlsh

CREATE KEYSPACE IF NOT EXISTS poc_keyspace WITH REPLICATION={'class':'SimpleStrategy','replication_factor':'1'};

USE poc_keyspace;

CREATE TABLE IF NOT EXISTS poc_keyspace.COMMIT (
       ID timeuuid,
       AUTHER text,
       MESSAGE text,
       DATE timestamp,
       PRIMARY KEY (ID,AUTHER)
);
CREATE INDEX IF NOT EXISTS id_index ON poc_keyspace.COMMIT(AUTHER);

DROP TABLE poc_keyspace.COMMIT;
INSERT INTO poc_keyspace.COMMIT (ID, AUTHER,MESSAGE,DATE) values(now(), 'melk01','add cache',dateof(now()));