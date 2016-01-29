INSERT INTO configuration
(id, author,      upload_path,            title,         creation_date) VALUES
( 1, 'Anna', 'C:/uploads/', 'Awesome Things', '2015-01-01 12:00:00');

INSERT INTO post
(id,          title,           content, author,         creation_date, active) VALUES
( 1, 'test title 1',  'test content 1', 'Anna', '2015-01-01 12:00:00',   false),
( 2, 'test title 2',  'test content 2', 'Anna', '2015-01-01 11:00:00',   true),
( 3, 'test title 3',  'test content 3', 'Anna', '2015-01-01 10:00:00',   false);

INSERT INTO photo
(id, post_id,       path) VALUES
( 1,       1, 'test1.jpg'),
( 2,       1, 'test2.jpg');