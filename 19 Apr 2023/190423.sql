/*
Create a program to retrieve the number of years of service for a specific employee.

a. Create a stored function called GET_SERVICE_YRS to retrieve the total number of years
of service for a specific employee.
The function should accept the employee ID as a parameter and return the number of years
of service. Add error handling to account for an invalid employee ID.

b. Invoke the function. You can use the following data:
EXECUTE DBMS_OUTPUT.PUT_LINE(get_service_yrs(999))
Hint: The above statement should produce an error message because there is no employee
with employee ID 999.
 
c. Create a stored procedure called UPD_SAL to update the  salaries
for a specific job in the EMP table.
Pass three parameters to the procedure: the job , a new minimum salary, and a new
maximum salary for the job. Add exception handling to account for an invalid job name in the
EMP table. Also, raise an exception if the maximum salary supplied is less than the
minimum salary.

EXECUTE DBMS_OUTPUT.PUT_LINE ('Approximately .... ' ||get_service_yrs(7499) || ' years')
Hint: The statement should be successful and return the number of years of service
for employee with employee ID 74e abov99

Make these functions available in a package name EMPPACK

*/
set serveroutput on;

create or replace procedure UPD_SAL(for_job in VARCHAR2, new_min_sal in number, new_max_sal in number)
as
Except_No_Data_Updated exception;
Except_Invalid_Job_Name exception;
Ex_Max_Sal_Less_Than_Min_Sal exception;
var_job_count number :=0;
my_error_code VARCHAR2(100);
my_error_msg VARCHAR2(100);

begin
    if new_max_sal < new_min_sal then
        raise Ex_Max_Sal_Less_Than_Min_Sal;
    end if;
    
    select count(e.job) into var_job_count from emp e where e.job = for_job;
    if var_job_count = 0 then
        raise Except_Invalid_Job_Name;
    end if;
    
    update emp set sal = new_max_sal where job = for_job; 
    if SQL%rowcount <= 1 then
        raise Except_No_Data_Updated;
    end if;

exception
    when Except_No_Data_Updated then
        dbms_output.put_line('No Data Found Exception!');
    when Ex_Max_Sal_Less_Than_Min_Sal then
        dbms_output.put_line('Max Sal Less than Min Sal!');
    when Except_Invalid_Job_Name then
        dbms_output.put_line('Invalid Job Name!');       
    when others then
        dbms_output.put_line('Other Error!');
        --my_error_code := SQLCODE;
        --my_error_msg := SQLERRM;
        --dbms_output.put_line('Error with code ' || my_error_code || ' and msg ' ||  my_error_msg);
end;
/

--var_job varchar2(30)
exec UPD_SAL('SALESMAN', 999, 1000);

select count(e.job) from emp e where e.job = 'SALESMAN';
--select * from emp;

create or replace function get_service_yrs(var_empno in number)
return integer
is
loc_service integer;
loc_empcount integer;
No_Data_Found exception;
begin
    select count(e.empno) into loc_empcount from emp e where e.empno = var_empno;
    
    if loc_empcount = 0 then
        raise No_Data_Found;
    end if;

    select TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)/12) into loc_service from emp where empno = var_empno;
    return loc_service;
exception
    when No_Data_Found then
        dbms_output.put_line('Invalid Emp No!');
end;
/

--select count(e.empno) from emp e where e.empno = 123;
--select TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)/12) from emp;

EXECUTE DBMS_OUTPUT.PUT_LINE(get_service_yrs(999));