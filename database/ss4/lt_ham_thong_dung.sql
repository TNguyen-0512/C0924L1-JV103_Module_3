USE quan_ly_sinh_vien;
-- câu 1--
SELECT * 
FROM Subject 
WHERE Credit = (SELECT MAX(Credit) FROM Subject);

-- câu 2 
SELECT s.*
FROM Subject s
JOIN Mark m ON s.SubId = m.SubId
WHERE m.Mark = (SELECT MAX(Mark) FROM Mark);

-- câu 3
SELECT st.StudentId, st.StudentName, COALESCE(AVG(m.Mark), 0) AS AvgMark
FROM Student st
LEFT JOIN Mark m ON st.StudentId = m.StudentId
GROUP BY st.StudentId, st.StudentName
ORDER BY AvgMark DESC;