package com.tribble2;

import com.tribble2.db.AttributeDefinitionRepository;
import com.tribble2.db.TypeDefinitionRepository;
import com.tribble2.model.AttributeDefinition;
import com.tribble2.model.AttributeType;
import com.tribble2.model.TypeDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Tribble2Application {

    public static void main(String[] args) {
        SpringApplication.run(Tribble2Application.class, args);
    }


    @Bean
    public CommandLineRunner loadData(TypeDefinitionRepository typeRepo, AttributeDefinitionRepository attrRepo) {

        return args -> {

            attrRepo.save(new AttributeDefinition("internal bool 1", "display 1", "dest 1", AttributeType.BOOLEAN));
            attrRepo.save(new AttributeDefinition("internal integer 2", "display 2", "dest 2", AttributeType.INTEGER));
            attrRepo.save(new AttributeDefinition("internal string 3", "display 3", "dest 3", AttributeType.STRING));
            attrRepo.save(new AttributeDefinition("internal real nbr 4", "display 4", "dest 4", AttributeType.REAL_NUMBER));
            attrRepo.save(new AttributeDefinition("internal real nbr + unit 5", "display 5", "dest 5", AttributeType.REAL_NUMBER_WITH_UNIT));


            for (int i = 0; i < 10; i++) {
                typeRepo.save(new TypeDefinition("internal type name" + i, "display type name" + i, "dest kurcze" + i, "path icon" + i, true, null));
            }

            for (int i = 11; i < 15; i++) {
                typeRepo.save(new TypeDefinition("internal type name" + i, "display type name" + i, "dest kurcze" + i, "path icon" + i, true, 1L));
            }

            for (int i = 20; i < 25; i++) {
                typeRepo.save(new TypeDefinition("internal type name" + i, "display type name" + i, "dest kurcze" + i, "path icon" + i, true, 3L));
            }

            int i=666;
            typeRepo.save(new TypeDefinition("internal type name" + i, "display type name46654" + i, "dest kurcze" + i, "path icon" + i, false, 11L));
            typeRepo.save(new TypeDefinition("internal type name" + i, "display type name5ft56gt645fd" + i, "dest kurcze" + i, "path icon" + i, false, 11L));
            typeRepo.save(new TypeDefinition("internal type name" + i, "display type n5fd" + i, "dest kurcze" + i, "path icon" + i, false, 12L));

        };
    }
}
