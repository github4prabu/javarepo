--To write a  Cursor to display the list of employees who are Working as a Managers or Analyst.

set serveroutput on;
declare
    emprec emp%rowtype;
    cursor mycur1 (pjob varchar2(25)) is select * from emp where job = pjob;
begin
    open mycur1;
    loop
        fetch mycur1 into emprec;
        exit when mycur1%NOTFOUND;    
        dbms_output.put_line(emprec.empno || '     ' || emprec.sal); 
    end loop;
    close mycur1;
end;
/

--Write PL/SQL code in Cursor to display employee names and salary
declare
    emprec emp%rowtype;
    cursor mycur2 is select emp.empno,emp.sal from emp;
begin
    open mycur2;
    loop
        fetch mycur2.empno, mycur2.sal into emprec;
        exit when mycur2%NOTFOUND;    
        dbms_output.put_line(emprec.empno || '     ' || emprec.sal); 
    end loop;
    close mycur2;
end;
/

--Write PL/SQL code in PL/SQL Block to find the Reverse of the  number
declare
getnum number := &number;
revnum varchar2(20);
begin
    for i in reverse 1..length(getnum) loop
        revnum := revnum || to_char(i);
    end loop;
   dbms_output.put_line(' reverse num is ' || revnum);   
end;
/