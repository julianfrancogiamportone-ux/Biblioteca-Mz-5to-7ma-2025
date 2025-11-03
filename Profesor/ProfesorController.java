@RestController
@RequestMapping("/profesores")
class ProfesorController {

    private final ProfesorAIService aiService;

    public ProfesorController(ProfesorAIService aiService) {
        this.aiService = aiService;
    }

    @GetMapping
    public List<Profesor> listar() { return aiService.listarProfesores(); }

    @GetMapping("/{id}")
    public Profesor obtener(@PathVariable Long id) { return aiService.obtenerProfesor(id); }

    @PostMapping
    public Profesor crear(@RequestBody Profesor profesor) { return aiService.crearProfesor(profesor); }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) }