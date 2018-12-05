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
        --  
      
        --      
        IF NEW.descricao = null THEN
            RAISE EXCEPTION '% não pode ter um Nome nulo', NEW.descricao;
        END IF;
     
        
        RETURN NEW;
    END;
  
 $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION exerciciogatilho()
  OWNER TO postgres;
