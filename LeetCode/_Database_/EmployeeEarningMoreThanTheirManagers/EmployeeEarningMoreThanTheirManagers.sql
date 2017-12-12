# Write your MySQL query statement below
SELECT Name as Employee
FROM Employee a
WHERE (a.Salary > (SELECT Salary FROM Employee WHERE a.ManagerId = Id));

#Refer to leetcode for this solution. 
#SELECT a.Name as Employee
#FROM Employee a, Employee b
#WHERE a.ManagerId = b.Id AND a.Salary > b.Salary;