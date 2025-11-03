@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String nacionalidad;

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }
}

   
@Repository
interface AutorRepository extends JpaRepository<Autor, Long> {}

@Service
class AutorService {

    private final AutorRepository repository;

    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    public List<Autor> listar() { return repository.findAll(); }
    public Autor obtener(Long id) { return repository.findById(id).orElse(null); }
    public Autor guardar(Autor autor) { return repository.save(autor); }
    public void eliminar(Long id) { repository.deleteById(id); }
}
@RestController
@RequestMapping("/autores")
class AutorController {

    private final AutorAIService aiService;

    public AutorController(AutorAIService aiService) {
        this.aiService = aiService;
    }

    @GetMapping
    public List<Autor> listar() { return aiService.listarAutores(); }

    @GetMapping("/{id}")
    public Autor obtener(@PathVariable Long id) { return aiService.obtenerAutor(id); }

    @PostMapping
    public Autor crear(@RequestBody Autor autor) { return aiService.crearAutor(autor); }