
-- Function: exerciciogatilho()

-- DROP FUNCTION exerciciogatilho();

CREATE OR REPLACE FUNCTION exerciciogatilho()
  RETURNS trigger AS
$BODY$


    BEGIN
        -- Verificar se foi fornecido a descricao do Exercicio
       
        IF NEW.descricao IS NULL THEN
            RAISE EXCEPTION '% não pode ter um exercicio nulo', NEW.descricao;
        END IF;
  
     
     
        
        RETURN NEW;
    END;
  
 $BODY$
  LANGUAGE plpgsql;

  
  CREATE TRIGGER exerciciogatilho BEFORE INSERT OR UPDATE ON exercicio
    FOR EACH ROW EXECUTE PROCEDURE exerciciogatilho();
