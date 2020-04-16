SELECT modulecode, duration FROM modules WHERE duration < 6;

SELECT b.batchcode, b.trainerid, b.coursecode, b.startdate, b.capacity, b.batchstrength
FROM batches b
INNER JOIN trainers t ON b.trainerid = t.trainerid
WHERE t.trainername = 'KRISHNAN';

SELECT m.modulename
FROM modules m
INNER JOIN courseandmodules cam ON m.modulecode = cam.modulecode
WHERE coursecode = 100;

SELECT m.modulename, c.coursecode
FROM modules m
INNER JOIN courseandmodules cam ON m.modulecode = cam.modulecode
WHERE coursecode = 100;

SELECT COUNT(modulecode) as NumberofModules
FROM courseandmodules
WHERE coursecode = 100;

SELECT coursecode, COUNT(modulecode) as NumberofModules
FROM courseandmodules
GROUP BY coursecode;

SELECT title, fees 
FROM courses 
ORDER BY fees DESC 
LIMIT 1;

SELECT studentid, studentname, batchcode, place, phone
FROM students
WHERE batchcode = 3001;

SELECT studentid, studentname, batchcode, place, phone
FROM students
WHERE place = 'CHENNAI';

SELECT COUNT(*) AS LESSTHANSIXDAYS
FROM modules
WHERE duration < 6;

SELECT b.batchcode, c.title, DATE(b.startdate)
FROM batches b
INNER JOIN courses c ON b.coursecode = c.coursecode
WHERE DATE(b.startdate) BETWEEN '2012-05-01' AND '2012-05-31';

SELECT c.coursescode, c.title, c.fees
FROM courses c 
INNER JOIN batches b ON c.coursecode = b.coursecode 
WHERE b.startdate NOT BETWEEN '2011-12-31' AND '2012-02-01';

SELECT modulename 
FROM modules 
WHERE modulecode IN (
	SELECT cm.modulecode 
	FROM courseandmodules cm
	INNER JOIN courses c ON c.coursecode = cm.coursecode
	WHERE c.title = 'Oracle DBA');

SELECT s.studentid, s.studentname, s.batchcode, s.place, s.phone  
FROM students s
INNER JOIN batches b ON b.batchcode = s.batchcode
WHERE s.place = 'CHENNAI' AND b.startdate BETWEEN '2012-01-01' AND '2012-12-31';

SELECT studentid, studentname 
FROM students 
WHERE batchcode IN (
	SELECT s.batchcode 
	FROM students s
	INNER JOIN batches b ON b.batchcode = s.batchcode
	WHERE b.coursecode = 200);