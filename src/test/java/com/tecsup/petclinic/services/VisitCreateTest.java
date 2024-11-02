package com.tecsup.petclinic.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
@Slf4j
public class VisitCreateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        log.info("Iniciando prueba de creación de visita...");
    }

    @AfterEach
    void tearDown() {
        log.info("Finalizando prueba de creación de visita...");
    }

    @Test
    void testCrearNuevaVisita() {
        String insertQuery = "INSERT INTO visits (pet_id, visit_date, description) VALUES (?, ?, ?)";
        int rowsInserted = jdbcTemplate.update(insertQuery, 1, "2024-11-02", "Visita de control");
        Assertions.assertEquals(1, rowsInserted, "No se insertó el registro esperado.");
        log.info("Prueba de creación de un nuevo registro ejecutada con éxito, filas afectadas: {}", rowsInserted);
    }
}
