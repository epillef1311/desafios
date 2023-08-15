SELECT employee.id, employee.name, AVG(salary.value) AS average_salary
FROM employee
JOIN salary ON employee.id = salary.employee_id
WHERE salary.payment_date >= DATE_SUB(CURDATE(), INTERVAL 3 MONTH)
GROUP BY employee.id, employee.name
ORDER BY average_salary DESC
LIMIT 3;