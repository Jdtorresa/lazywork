package com.lazywork.servicios;

import com.lazywork.entidad.Incidencia;
import com.lazywork.entidad.UsuarioRol;
import com.lazywork.repositorio.EstadosIncidenciasCrudRepository;
import com.lazywork.repositorio.IncidenciaCrudRepository;
import com.lazywork.repositorio.PrioridadesIncidenciasCrudRepository;
import com.lazywork.repositorio.UsuarioCrudRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class
IncidenciaService {

    @PersistenceContext
    private EntityManager entityManager;
    private IncidenciaCrudRepository incidenciaRepository;

    private EstadosIncidenciasCrudRepository estadosIncidenciasCrudRepository;
    private PrioridadesIncidenciasCrudRepository prioridadesIncidenciasCrudRepository;
    private UsuarioCrudRepository usuarioCrudRepository;
    @Autowired
    public IncidenciaService(IncidenciaCrudRepository incidenciaRepository, EstadosIncidenciasCrudRepository estadosIncidenciasCrudRepository, PrioridadesIncidenciasCrudRepository prioridadesIncidenciasCrudRepository, UsuarioCrudRepository usuarioCrudRepository) {
        this.incidenciaRepository = incidenciaRepository;
        this.estadosIncidenciasCrudRepository = estadosIncidenciasCrudRepository;
        this.prioridadesIncidenciasCrudRepository = prioridadesIncidenciasCrudRepository;
        this.usuarioCrudRepository = usuarioCrudRepository;
    }

    public List<Incidencia> obtenerTodasLasIncidencias() {
        return (List<Incidencia>) incidenciaRepository.findAll();
    }

    public Optional<Incidencia> obtenerIncidenciaPorId(Long id) {
        return incidenciaRepository.findById((id));
    }

    public Incidencia crearIncidencia(Incidencia incidencia) {

        incidencia.setEstado(estadosIncidenciasCrudRepository.findById(incidencia.getEstado().getEstadoID()).get());
        incidencia.setPrioridad(prioridadesIncidenciasCrudRepository.findById(incidencia.getPrioridad().getPrioridadID()).get());
        incidencia.setUsuario(usuarioCrudRepository.findById(incidencia.getUsuario().getId()).get());
        incidencia.setFechaRegistro(LocalDate.now());

        return incidenciaRepository.save(incidencia);
    }

    public Incidencia actualizarIncidencia(Incidencia incidencia) {

        incidencia.setFechaRegistro(LocalDate.now());
        return incidenciaRepository.save(incidencia);
    }

    public void eliminarIncidencia(Long id) {
        incidenciaRepository.deleteById(id);
    }
    @Transactional
    public void actualizarIncidenciasNivel1Prioridad1() {
        String sql = "UPDATE incidencias\n" +
                "SET usuarioid = (SELECT usuarioid FROM usuarios WHERE nivel_soporte = 'nivel 1')\n" +
                "WHERE estadoid = (SELECT estadoid FROM estados_incidencia WHERE tipo_estado = 'en curso')\n" +
                "  AND prioridadid = 1;";

        entityManager.createNativeQuery(sql).executeUpdate();
    }

    @Transactional
    public void actualizarIncidenciasNivel2Prioridad2() {
        String sql = "UPDATE incidencias\n" +
                "SET usuarioid = (SELECT usuarioid FROM usuarios WHERE nivel_soporte = 'nivel 2')\n" +
                "WHERE estadoid = (SELECT estadoid FROM estados_incidencia WHERE tipo_estado = 'en curso')\n" +
                "  AND prioridadid = 2;";

        entityManager.createNativeQuery(sql).executeUpdate();
    }

    @Transactional
    public void actualizarIncidenciasNivel3Prioridad3() {
        String sql = "UPDATE incidencias AS i\n" +
                "JOIN usuarios AS u ON i.estadoid = (SELECT estadoid FROM estados_incidencia WHERE tipo_estado = 'en curso') AND i.prioridadid = 3\n" +
                "SET i.usuarioid = u.usuarioid\n" +
                "WHERE u.nivel_soporte = 'nivel 3';";

        entityManager.createNativeQuery(sql).executeUpdate();
    }
    @Transactional
    public void actualizarIncidenciasNivel4Prioridad4() {
        String sql = "UPDATE incidencias AS i\n" +
                "JOIN usuarios AS u ON i.estadoid = (SELECT estadoid FROM estados_incidencia WHERE tipo_estado = 'en curso') AND i.prioridadid = 4\n" +
                "SET i.usuarioid = u.usuarioid\n" +
                "WHERE u.nivel_soporte = 'nivel 4';";

        entityManager.createNativeQuery(sql).executeUpdate();
    }




    public List<Incidencia> obtenerIncidenciasEstado4() {
        // Utiliza el método de tu repositorio para obtener las incidencias con estado 4
        return incidenciaRepository.findByEstado_EstadoID(4L);
    }
    public List<Incidencia> obtenerIncidenciasEstado3() {
        // Utiliza el método de tu repositorio para obtener las incidencias con estado 4
        return incidenciaRepository.findByEstado_EstadoID(3L);
    }

    public List<Incidencia> obtenerIncidenciasEstado1() {
        // Utiliza el método de tu repositorio para obtener las incidencias con estado 4
        return incidenciaRepository.findByEstado_EstadoID(1L);
    }


}
