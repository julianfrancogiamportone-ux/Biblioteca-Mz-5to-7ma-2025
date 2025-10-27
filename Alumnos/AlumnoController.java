@RestController
@RequestMapping("/alumnos")
class AlumnoController {

    private final AlumnoAIService aiService;

    public AlumnoController(AlumnoAIService aiService) {
        this.aiService = aiService;
    }

    @GetMapping
    public List<Alumno> listar() { return aiService.listarAlumnos(); }

    @GetMapping("/{id}")
    public Alumno obtener(@PathVariable Long id) { return aiService.obtenerAlumno(id); }

    @PostMapping
    public Alumno crear(@RequestBody Alumno alumno) { return aiService.crearAlumno(alumno); }

    @DeleteMapping("/{id}")
  }