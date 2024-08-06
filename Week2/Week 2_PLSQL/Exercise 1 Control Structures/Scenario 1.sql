-- Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years old.
-- Question: Write a PL/SQL block that loops through all customers, checks their age, and if they are above 60, apply a 1% discount to their current loan interest rates.

UPDATE Loans
SET InterestRate = InterestRate - 0.01
WHERE CustomerID IN (
    SELECT CustomerID
    FROM Customers
    WHERE MONTHS_BETWEEN(SYSDATE, DOB) / 12 > 60
);
