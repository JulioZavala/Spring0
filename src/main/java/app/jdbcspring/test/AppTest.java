package app.jdbcspring.test;

import app.jdbcspring.dao.ServicioDAO;
import app.jdbcspring.model.Servicio;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

    public static void main(String[] args) {
        //AppTest.saveServicio();
        AppTest.getAll();
        //AppTest.getServicio(new Servicio(3));


    }

    public static void saveServicio() {


        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc_database.xml");
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");

        Servicio servicio = new Servicio();
        servicio.setDescripcion("Alquiler de toallas");
        servicio.setCostoHora(55.55d);
        servicioDAO.save(servicio);
    }

    public static void getServicio(Servicio servicio) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc_database.xml");
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");

        Servicio servicioFull = servicioDAO.get(servicio);
        System.out.println(servicioFull.getDescripcion() + " " + servicio.getCostoHora());

    }

    public static void getAll() {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc_database.xml");
        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");

        List<Servicio> servicios = servicioDAO.list();

        for (Servicio servicio : servicios) {
            System.out.println(servicio.getDescripcion() + " " + servicio.getCostoHora());

        }
    }
}
