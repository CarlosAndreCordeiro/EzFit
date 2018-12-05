


-- Function: verificadata_gatilho()

-- DROP FUNCTION verificadata_gatilho();

CREATE OR REPLACE FUNCTION verificaCref()
  RETURNS trigger AS
$BODY$
    BEGIN
        -- Verificar se foi o professor Cref
     
     
        IF NEW.cref IS NULL THEN
            RAISE EXCEPTION '% não pode ter um CREF nulo', NEW.cref;
        END IF;
    
     
         
        RETURN NEW;
    END;
  
$BODY$
  LANGUAGE plpgsql;

  CREATE TRIGGER verificaCref BEFORE INSERT OR UPDATE ON Professor
    FOR EACH ROW EXECUTE PROCEDURE verificaCref();
