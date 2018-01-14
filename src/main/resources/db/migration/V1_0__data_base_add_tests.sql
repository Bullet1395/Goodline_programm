INSERT INTO USERS (LOGIN, HASH_PASSWORD, SALT) VALUES ('User_Read',
                                                       '39ff6454325ff3fd4a8d2a08a77688139cf7ca2f5d8a91e8b70827630ab7ecba6c8d910625504e7bf54d3bc8af486856f3e94fdb83ef7a6ed2b3739b73c5b',
                                                       'ad2880182c0ab3acb6923c2cac3c3c');
INSERT INTO USERS (LOGIN, HASH_PASSWORD, SALT) VALUES ('User_Write',
                                                       '30168a133db8384c766814e91b79b30a4f7de7dbccfa4e89ef767e5e5e886d3bd3664853194452101621301e54b7c60f4affdb541a6ad7f83fbfed6fe69',
                                                       'ce137c1fb46bd36351e84a82eeda4f93');
INSERT INTO USERS (LOGIN, HASH_PASSWORD, SALT) VALUES ('User_Execute',
                                                       'a07a56aade7ea69c3353116880a0c643cb48ed16b5ffd3eccac116e3a1f3f7dc6c913e35db4a34b98414c6a5ff5e9c38a77e5f0f1ab6d4e20217bc5783c9efd',
                                                       '75e0de893cad6f865bb590a55e5de5');
INSERT INTO USERS (LOGIN, HASH_PASSWORD, SALT) VALUES ('jdoe',
                                                       'a71a88ad22d82940f2751edf14ba9e6f08a7e1e918ba446d5e6a487ee98bd2b4fe552d43d7443cb1118804be1af21e5e36f574722c1b2cc30825822521dc433',
                                                       '8b687329e7e33027f2615cced770ff57');
INSERT INTO USERS (LOGIN, HASH_PASSWORD, SALT) VALUES ('jrow',
                                                       '37685b4efc9439c54771283586ecf051cad9b87dcd636ff54c6c2757456f7245feb6c75902eba42fe9cf3e9245cf215a3732912165c85250eac2efc66a0',
                                                       'a191c5ba8c4155cdb9e6f8d6514d8b4');
INSERT INTO USERS (LOGIN, HASH_PASSWORD, SALT) VALUES ('xxx',
                                                       'ea1d8c67e58b8f865a75e7fb497f0aec088681b5b92d927c7c99351ad7fa0953698dd7e66c42c47de1c2e67f84f75807cb9f9d02c2415acd8692527605a',
                                                       'f48bc1fe17ebffeac71a7225afb4e3b');

INSERT INTO RESOURCES (LOGIN, RESOURCE, ROLE) VALUES ('User_Read',
                                                      'C.R.RR',
                                                      'READ');

INSERT INTO RESOURCES (LOGIN, RESOURCE, ROLE) VALUES ('User_Read',
                                                      'C.W.WR.R',
                                                      'READ');

INSERT INTO RESOURCES (LOGIN, RESOURCE, ROLE) VALUES ('User_Write',
                                                      'C.W.WR',
                                                      'WRITE');

INSERT INTO RESOURCES (LOGIN, RESOURCE, ROLE) VALUES ('User_Write',
                                                      'C.R.RR.W',
                                                      'WRITE');

INSERT INTO RESOURCES (LOGIN, RESOURCE, ROLE) VALUES ('User_Execute',
                                                      'C.E.ER',
                                                      'EXECUTE');

INSERT INTO RESOURCES (LOGIN, RESOURCE, ROLE) VALUES ('jdoe',
                                                      'a',
                                                      'READ');

INSERT INTO RESOURCES (LOGIN, RESOURCE, ROLE) VALUES ('jdoe',
                                                      'a.b',
                                                      'WRITE');

INSERT INTO RESOURCES (LOGIN, RESOURCE, ROLE) VALUES ('jrow',
                                                      'a.b.c',
                                                      'EXECUTE');

INSERT INTO RESOURCES (LOGIN, RESOURCE, ROLE) VALUES ('jdoe',
                                                      'a.bc',
                                                      'EXECUTE');
