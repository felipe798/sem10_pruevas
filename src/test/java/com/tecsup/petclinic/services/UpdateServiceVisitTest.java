package com.tecsup.petclinic.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
@Slf4j
public class UpdateServiceVisitTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        log.info("Iniciando prueba...");
    }

    @AfterEach
    void tearDown() {
        log.info("Finalizando prueba...");
    }

    @Test
    void testActualizarDescripcionDeUnRegistro() {
        String updateQuery = "UPDATE visits SET description = ? WHERE id = ?";
        int rowsUpdated = jdbcTemplate.update(updateQuery, "updated rabies shot", 1);
        Assertions.assertEquals(1, rowsUpdated, "No se actualizó el registro esperado.");
        log.info("Prueba de actualización de un solo registro ejecutada con éxito, filas afectadas: {}", rowsUpdated);
    }

}

