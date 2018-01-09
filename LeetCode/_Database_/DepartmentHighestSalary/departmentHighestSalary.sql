# Write your MySQL query statement below
SELECT a.Name as Department, b.Name as Employee, b.Salary as Salary
FROM Employee b, Department a 
WHERE a.Id = b.DepartmentId AND b.Salary = (SELECT Max(Salary) FROM Employee c WHERE c.DepartmentId = a.Id);