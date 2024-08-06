-- Scenario 2: A customer can be promoted to VIP status based on their balance.
-- Question: Write a PL/SQL block that iterates through all customers and sets a flag IsVIP to TRUE for those with a balance over $10,000.
ALTER TABLE Customers
ADD IsVIP NUMBER(1) DEFAULT 0;


BEGIN
   
    UPDATE Customers
    SET IsVIP = 1
    WHERE Balance > 10000;

    COMMIT; 
END;
/

-- Verify the updates
SELECT * FROM Customers;
