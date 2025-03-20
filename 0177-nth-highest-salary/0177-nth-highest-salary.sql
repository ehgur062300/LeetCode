CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT

BEGIN
    SET N = N-1;

    IF N < 0 THEN
        RETURN NULL;
    END IF;

    RETURN (
        SELECT DISTINCT salary 
        FROM Employee 
        ORDER BY salary DESC 
        LIMIT N, 1
    );
END