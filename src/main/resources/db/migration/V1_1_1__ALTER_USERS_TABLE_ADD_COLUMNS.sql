DECLARE
    IS_ACTIVE_COLUMN_EXISTS NUMBER;
    IS_CREATED_ON_COLUMN_EXISTS NUMBER;
    IS_UPDATED_ON_COLUMN_EXISTS NUMBER;
BEGIN

SELECT COUNT(1) INTO IS_ACTIVE_COLUMN_EXISTS
FROM ALL_TAB_COLUMNS
WHERE  TABLE_NAME = UPPER('USERS')
    AND COLUMN_NAME = UPPER('ACTIVE');

SELECT COUNT(1) INTO IS_CREATED_ON_COLUMN_EXISTS
FROM ALL_TAB_COLUMNS
WHERE  TABLE_NAME = UPPER('USERS')
    AND COLUMN_NAME = UPPER('CREATED_ON');

SELECT COUNT(1) INTO IS_UPDATED_ON_COLUMN_EXISTS
FROM ALL_TAB_COLUMNS
WHERE  TABLE_NAME = UPPER('USERS')
    AND COLUMN_NAME = UPPER('UPDATED_ON');

IF IS_ACTIVE_COLUMN_EXISTS = 0 THEN
EXECUTE IMMEDIATE q'[
    ALTER TABLE USERS
    ADD ACTIVE NUMBER(1,0) DEFAULT 1
]';
END IF;

IF IS_CREATED_ON_COLUMN_EXISTS = 0 THEN
EXECUTE IMMEDIATE q'[
    ALTER TABLE USERS
    ADD CREATED_ON TIMESTAMP DEFAULT SYSTIMESTAMP
]';
END IF;

IF IS_UPDATED_ON_COLUMN_EXISTS = 0 THEN
EXECUTE IMMEDIATE q'[
    ALTER TABLE USERS
    ADD UPDATED_ON TIMESTAMP
]';
END IF;

END;
/

