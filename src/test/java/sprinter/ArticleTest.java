package sprinter;

import sprinter.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ArticleTest {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    public void createArticle() throws Exception {

        Article article = new Article("456", "Example", 12.99, 100, "Example description", true);

        assertThat(article.getName()).isEqualTo("Example");
        assertThat(article.getPrice()).isEqualTo(12.99);
    }
    /*
    @Test
    public void comprobarIgualdadEquipos() {
        // GIVEN
        // Creamos tres equipos sin id, sólo con el nombre
        Equipo equipo1 = new Equipo("Proyecto P1", "DescripciónP1");
        Equipo equipo2 = new Equipo("Proyecto P2", "DescripciónP2");
        Equipo equipo3 = new Equipo("Proyecto P2", "DescripciónP2");

        // THEN
        // Comprobamos igualdad basada en el atributo nombre
        assertThat(equipo1).isNotEqualTo(equipo2);
        assertThat(equipo2).isEqualTo(equipo3);

        // WHEN
        // Añadimos identificadores y comprobamos igualdad por identificadores
        equipo1.setId(1L);
        equipo2.setId(1L);
        equipo3.setId(2L);

        // THEN
        // Comprobamos igualdad basada en el atributo nombre
        assertThat(equipo1).isEqualTo(equipo2);
        assertThat(equipo2).isNotEqualTo(equipo3);
    }

    @Test
    public void comprobarRecuperarEquipo() {
        // GIVEN
        // En el application.properties se cargan los datos de prueba del fichero datos-test.sql

        // WHEN

        Equipo equipo = equipoRepository.findById(1L).orElse(null);

        // THEN
        assertThat(equipo).isNotNull();
        assertThat(equipo.getId()).isEqualTo(1L);
        assertThat(equipo.getNombre()).isEqualTo("Proyecto P1");
        assertThat(equipo.getDescripcion()).isEqualTo("El equipo para el proyecto P1");
    }*/
}
